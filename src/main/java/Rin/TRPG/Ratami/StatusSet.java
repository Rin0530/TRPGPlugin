package Rin.TRPG.Ratami;

import org.bukkit.command.*;

public class StatusSet implements CommandExecutor{
    private Plugin plugin;

    public StatusSet(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        PL senderPL = plugin.getPl().get(sender.getName());

        if(args[0].equals("main")){
            senderPL.setMainStatus(args[1], Integer.parseInt(args[2])); 
        }else if(args[0].equals("other")){
            senderPL.addOtherStatus(args[1], Integer.parseInt(args[2]));
        }
        sender.sendMessage(args[1]+"を"+args[2]+"に設定しました");
        plugin.getServer().dispatchCommand(sender, "clear @p minecraft:written_book{display:{Name:'{\"text\":\"数値設定本\"}'}} 1");
        return true;
    }
}

