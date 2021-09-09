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
        String cmd = "";
        if(args[0].equals("main"))
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),"give "+sender.getName()+" minecraft:written_book{display:{Name:'{\"text\":\"数値設定本\",\"bold\":true}'},title:\"\",author:\"\",pages:['[{\"text\":\""+args[1]+"の値をクリック\n\"},{\"text\":\"1\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(1)+" 1\"}},{\"text\":\"2\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(2)+" 2\"}},{\"text\":\"3\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(3)+" 3\"}},{\"text\":\"4\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(4)+" 4\"}},{\"text\":\"5\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(5)+" 5\"}},{\"text\":\"6\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(5)+" 6\"}},{\"text\":\"7\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(7)+" 7\"}},{\"text\":\"8\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(8)+" 8\"}},{\"text\":\"9\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(9)+" 9\"}},{\"text\":\"10\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(10)+" 10\"}},{\"text\":\"11\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(11)+" 11\"}},{\"text\":\"12\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(12)+" 12\"}},{\"text\":\"13\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(13)+" 13\"}}]','[{\"text\":\"14\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(14)+" 14\"}},{\"text\":\"15\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(15)+" 15\"}},{\"text\":\"16\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(16)+" 16\"}},{\"text\":\"17\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(17)+" 17\"}},{\"text\":\"18\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(18)+" 18\"}},{\"text\":\"19\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(19)+" 19\"}},{\"text\":\"20\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(20)+" 20\"}},{\"text\":\"21\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(21)+" 21\"}}]']} 1");
        else{
            cmd ="give "+sender.getName()+" written_book{display:{Name:'{\"text\":\"数値設定本\",\"bold\":true}'},title:\"数値設定本\",author:\"\",pages:['[{\"text\":\""+args[1]+"\n\nの能力値\"},{\"text\":\"をクリックしてください\n\n\"},{\"text\":\"値は次のページから\"}]','[";
            for(int i = 1;i < 100;i++){
            cmd += "{\"text\":\""+String.valueOf(i)+"\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\""+String.valueOf(i)+"\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+"  "+String.valueOf(i)+"\"}}";
                if(i % 14 != 0){
                    cmd += ",";
                }else {
                    cmd += "]','[";
                }
            }
            cmd += "{\"text\":\"\"}";
            cmd += "]']}";
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), cmd);
        }
        return true;
    }
}