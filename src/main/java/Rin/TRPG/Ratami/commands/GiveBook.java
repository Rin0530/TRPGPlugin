package Rin.TRPG.Ratami.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.command.*;

import Rin.TRPG.Ratami.PL;
import Rin.TRPG.Ratami.Plugin;

public class GiveBook implements CommandExecutor{
    private Plugin plugin;

    public GiveBook(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        String target = sender.getName();
        PL pl = plugin.getPl().get(target);
        if(args.length == 1)
            target = args[0];
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "team join PL "+target);
        sender.setOp(false);
        plugin.getPl().get(sender.getName()).getPlayer().setGameMode(GameMode.ADVENTURE);
        //plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "team modify PL nametagVisibility never");

        StringBuilder builder = new StringBuilder("give "+sender.getName()+" minecraft:written_book{display:");
        //Name プロパティ設定
        builder.append("{Name:'{");
        builder.append("\"text\":\"ステータス設定\",");
        builder.append("\"bold\":true,");
        builder.append("\"italic\":true}'},");   //displatプロパティ終了

        //titleプロパティ
        builder.append("title:\"ステータス設定\",");
        //authorプロパティ
        builder.append("author:\"\",");

        //generationプロパティ
        builder.append("generation:0,");

        //pageaプロパティ
        builder.append("pages:['");
        //1ページ目
        builder.append("[");
        builder.append("{\"text\":\"ステータス設定\n\n\"},");
        builder.append("{\"text\":\"設定したい能力値や技能ポイントをクリックしてください。\"},");
        builder.append("{\"text\":\"クリックするとそれに対応した新しい本が手に入ります。\"},");
        builder.append("{\"text\":\"能力値一覧、および技能一覧は次のページ以降にあります\"}]',");

        //2ページ目
        builder.append("'[");
        builder = addPage(builder, pl.getMainStatus(), "main ");

        //3ページ目以降
        builder = addPage(builder, pl.getOtherStatus(), "other ");
        builder.append("{\"text\":\"\n\n\"},");

        //完了コマンドを追加
        builder = addPage(builder, Arrays.asList("完了"), "remove");

        //後始末
        builder.append("{\"text\":\"\"}");
        builder.append("]']}");

        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),builder.toString());

        return true;
    }

    private StringBuilder addPage(StringBuilder builder, List<String> names, String subCommand){
        List<String> nextLines = Arrays.asList("EDU","ライフル","目星","変装","母国語","地質学");
        for(String text :names){
            builder.append("{");
                //textプロパティ
                builder.append("\"text\":\""+text+"\n\",");
                //boldプロパティ
                builder.append("\"bold\":true,");
                //hoverEventプロパティ
                builder.append("\"hoverEvent\":{");
                    builder.append("\"action\":\"show_text\",");
                    builder.append("\"value\":[{");
                    builder.append("\"text\":\""+text+"\"}]");
                builder.append("},");
                //clickEventプロパティ
                builder.append("\"clickEvent\":{");
                    builder.append("\"action\":\"run_command\",");
                    if(subCommand.equals("remove"))
                        builder.append("\"value\":\"/removebook\"");
                    else
                        builder.append("\"value\":\"/book "+subCommand+text+"\"");
                builder.append("}");
            builder.append("}");
            if(nextLines.contains(text))
                builder.append("]','[");
            else
                builder.append(",");
        }
        return builder;
    }
}