package Rin.TRPG.Ratami;

import org.bukkit.command.*;

public class Name implements CommandExecutor{
    Plugin plugin;
    public Name(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(args.length != 2){
            sender.sendMessage(String.valueOf(args.length));
            return false;
        }
        plugin.getPl().get(args[0]).setName(args[1]);
        return true;
    }
}