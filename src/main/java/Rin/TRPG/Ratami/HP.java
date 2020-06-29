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
        Player player = plugin.getPl().get(sender.getName()).getPlayer();
        if(args[1].equals("scale"))
            player.setHealthScale(Double.parseDouble(args[0]));
        else player.setHealth(Double.parseDouble(args[0]));
        return true;
    }
}