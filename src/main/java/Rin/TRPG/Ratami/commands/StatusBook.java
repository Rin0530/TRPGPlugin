package Rin.TRPG.Ratami.commands;

import org.bukkit.command.*;

import Rin.TRPG.Ratami.Plugin;

public class StatusBook implements CommandExecutor{
    private Plugin plugin;

    public StatusBook(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        StringBuilder cmd = new StringBuilder("give "+sender.getName()+" minecraft:written_book");
        String subCommand;
        int maxVlaue;
        if(args[0].equals("main")){
            subCommand = args[0];
            maxVlaue = 21;
        }
        else {
            subCommand = "other";
            maxVlaue = 100;
        }
        cmd.append("{display:{");
        cmd.append("Name:'{");
        cmd.append("\"text\":\"数値設定本\",");
        cmd.append("\"bold\":true}'},");
        cmd.append("title:\"数値設定本\",");
        cmd.append("author:\"\",");
        cmd.append("pages:['");
        cmd.append("[{\"text\":\""+args[1]+"\n\nの能力値\"},");
        cmd.append("{\"text\":\"をクリックしてください\n\n\"},");
        cmd.append("{\"text\":\"値は次のページから\"}]','");

        cmd.append("[");
        for(int i = 1;i <= maxVlaue; i++){
            String num = String.valueOf(i);
            cmd.append("{");
            //textプロパティ
            cmd.append("\"text\":\""+num+"\n\",");
            //colorプロパティ
            cmd.append("\"color\":\"blue\",");
            //boldプロパティ
            cmd.append("\"bold\":true,");
            //clickEventプロパティ
            cmd.append("\"clickEvent\":{");
                cmd.append("\"action\":\"run_command\",");
                cmd.append("\"value\":\"/statusset "+subCommand+" "+args[1]+" "+num+"\"}");
            cmd.append("}");
            if(i % 14 == 0)
                cmd.append("]','[");
            else
                cmd.append(",");
        }
        
        cmd.append("{\"text\":\"\"}");
        cmd.append("]']}");
        return plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), cmd.toString());
    }
}