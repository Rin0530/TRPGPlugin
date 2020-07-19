package Rin.TRPG.Ratami;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class HP implements CommandExecutor{
    Plugin plugin;
    
    public HP(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        Player player = plugin.getPl().get(args[0]).getPlayer();
        //if(args[2].equals("scale"))
        //    player.setHealthScale(Double.parseDouble(args[1]));
        //else 
            player.setHealth(Double.parseDouble(args[1]));
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "reflectStatus");
        return true;
    }
}