package Rin.TRPG.Ratami;

import org.bukkit.command.*;

public class GiveBook implements CommandExecutor{
    private Plugin plugin;

    public GiveBook(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        String target = sender.getName();
        if(args.length == 1)
            target = args[0];
        plugin.getServer().dispatchCommand(sender, "team join PL "+target);
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "team modify PL nametagVisibility never");

        plugin.getServer().dispatchCommand(sender,"give @p minecraft:written_book{display:{Name:'{\"text\":\"ステータス設定\",\"color\":\"red\",\"bold\":true,\"italic\":true}'},title:\"ステータス設定\",author:\"\",generation:0,pages:['[{\"text\":\"ステータス設定\n\n\",\"color\":\"black\",\"italic\":true},{\"text\":\"設定したい能力値や技能ポイントをクリックしてください。\n\",\"color\":\"black\",\"bold\":false,\"italic\":false},{\"text\":\"クリックするとそれに対応した新しい本が手に入ります。\n\n\",\"bold\":false,\"italic\":false},{\"text\":\"能力値一覧、および\n技能一覧は次のページ以降にあります\",\"bold\":false,\"italic\":false}]','[{\"text\":\"STR\",\"color\":\"black\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book main STR\"}},{\"text\":\"\nCON\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book main CON\"}},{\"text\":\"\nPOW\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book main POW\"}},{\"text\":\"\nDEX\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book main DEX\"}},{\"text\":\"\nAPP\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book main APP\"}},{\"text\":\"\nSIZ\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book main SIZ\"}},{\"text\":\"\nINT\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book main INT\"}},{\"text\":\"\nEDU\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book main EDU\"}}]','[{\"text\":\"\n回避\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"回避\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 回避\"}},{\"text\":\"\nキック\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"キック\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other キック\"}},{\"text\":\"\n組み付き\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"組み付き\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 組み付き\"}},{\"text\":\"\nこぶし（パンチ）\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"こぶし（パンチ）\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other こぶし（パンチ）\"}},{\"text\":\"\n頭突き\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"頭突き\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 頭突き\"}},{\"text\":\"\n投擲\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"投擲\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 投擲\"}},{\"text\":\"\nマーシャルアーツ\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"マーシャルアーツ\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other マーシャルアーツ\"}},{\"text\":\"\n拳銃\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"拳銃\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 拳銃\"}},{\"text\":\"\nサブマシンガン\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"サブマシンガン\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other サブマシンガン\"}},{\"text\":\"\nショットガン\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"ショットガン\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other ショットガン\"}},{\"text\":\"\nマシンガン\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"マシンガン\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other マシンガン\"}},{\"text\":\"\nライフル\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"ライフル\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other ライフル\"}}]','[{\"text\":\"\n応急手当\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"応急手当\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 応急手当\"}},{\"text\":\"\n鍵開け\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"鍵開け\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 鍵開け\"}},{\"text\":\"\n隠す\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"隠す\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 隠す\"}},{\"text\":\"\n隠れる\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"隠れる\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 隠れる\"}},{\"text\":\"\n聞き耳\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"聞き耳\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 聞き耳\"}},{\"text\":\"\n忍び歩き\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"忍び歩き\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 忍び歩き\"}},{\"text\":\"\n写真術\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"写真術\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 写真術\"}},{\"text\":\"\n精神分析\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"精神分析\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 精神分析\"}},{\"text\":\"\n追跡\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"追跡\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 追跡\"}},{\"text\":\"\n登攀\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"登攀\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 登攀\"}},{\"text\":\"\n図書館\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"図書館\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 図書館\"}},{\"text\":\"\n目星\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"目星\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 目星\"}}]','[{\"text\":\"\n運転\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"運転\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 運転\"}},{\"text\":\"\n機械修理\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"機械修理\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 機械修理\"}},{\"text\":\"\n重機械操作\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"重機械操作\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 重機械操作\"}},{\"text\":\"\n乗馬\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"乗馬\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 乗馬\"}},{\"text\":\"\n水泳\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"水泳\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 水泳\"}},{\"text\":\"\n製作\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"製作\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 製作\"}},{\"text\":\"\n操縦\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"操縦\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 操縦\"}},{\"text\":\"\n跳躍\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"跳躍\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 跳躍\"}},{\"text\":\"\n電気修理\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"電気修理\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 電気修理\"}},{\"text\":\"\nナビゲート\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"ナビゲート\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other ナビゲート\"}},{\"text\":\"\n変装\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"変装\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 変装\"}}]','[{\"text\":\"\n言いくるめ\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"言いくるめ\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 言いくるめ\"}},{\"text\":\"\n信用\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"信用\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 信用\"}},{\"text\":\"\n説得\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"説得\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 説得\"}},{\"text\":\"\n値切り\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"値切り\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 値切り\"}},{\"text\":\"\n母国語\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"母国語\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 母国語\"}}]','[{\"text\":\"\n医学\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"医学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 医学\"}},{\"text\":\"\nオカルト\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"オカルト\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other オカルト\"}},{\"text\":\"\n化学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"化学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 化学\"}},{\"text\":\"\nクトゥルフ神話\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"クトゥルフ神話\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other クトゥルフ神話\"}},{\"text\":\"\n芸術\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"芸術\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 芸術\"}},{\"text\":\"\n経理\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"経理\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 経理\"}},{\"text\":\"\n考古学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"考古学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 考古学\"}},{\"text\":\"\nコンピューター\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"コンピューター\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other コンピューター\"}},{\"text\":\"\n心理学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"心理学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 心理学\"}},{\"text\":\"\n人類学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"人類学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 人類学\"}},{\"text\":\"\n生物学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"生物学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 生物学\"}},{\"text\":\"\n地質学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"地質学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 地質学\"}},{\"text\":\"\n電子工学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"電子工学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 電子工学\"}},{\"text\":\"\n天文学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"天文学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 天文学\"}},{\"text\":\"\n博物学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"博物学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 博物学\"}}]','[{\"text\":\"\n物理学\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"物理学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 物理学\"}},{\"text\":\"\n法律\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"法律\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 法律\"}},{\"text\":\"\n薬学\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"薬学\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 薬学\"}},{\"text\":\"\n歴史\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"歴史\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book other 歴史\"}},{\"text\":\"\n\n完了\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"完了\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/removeBook\"}}]']} 1"); 
        return true;
    }
}