package Rin.TRPG.Ratami;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class StatusBook implements CommandExecutor{
    private Plugin plugin;

    public StatusBook(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        sender.sendMessage("give book");
       /* String text = "\"text\"";
        String number = "\"数値設定本\"";
        String str = "\"STRの値をクリック\\n\"";
        String color = "\"color\"";
        String blue = "\"blue\"";
        String bold = "\"bold\"";
        String clickEvent = "\"clickEvent\"";
        String action = "\"action\"";
        String run_command = "\"run_command\"";
        String value = "\"value\"";
        String status = "\"/StatusSet main STR";*/
        plugin.getServer().dispatchCommand(sender, "give @p minecraft:written_book{display:{Name:'{\"text\":\"数値設定本\"}'},title:\"\",author:\"\",pages:['[{\"text\":\"STRの値をクリック\n\"},{\"text\":\"1\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 1\"}},{\"text\":\"2\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 2\"}},{\"text\":\"3\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 3\"}},{\"text\":\"4\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 4\"}},{\"text\":\"5\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 5\"}},{\"text\":\"6\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 6\"}},{\"text\":\"7\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 7\"}},{\"text\":\"8\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 8\"}},{\"text\":\"9\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 9\"}},{\"text\":\"10\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 10\"}},{\"text\":\"11\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 11\"}},{\"text\":\"12\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 12\"}},{\"text\":\"13\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 13\"}},{\"text\":\"14\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 14\"}}]','[{\"text\":\"15\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 15\"}},{\"text\":\"16\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 16\"}},{\"text\":\"17\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 17\"}},{\"text\":\"18\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/StatusSet main STR 18\"}}]']} 1");
        return true;
    }
    
}