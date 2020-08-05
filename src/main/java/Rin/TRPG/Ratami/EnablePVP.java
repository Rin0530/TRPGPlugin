package Rin.TRPG.Ratami;

import org.bukkit.command.*;

public class EnablePVP implements CommandExecutor{
    private Plugin plugin;

    public EnablePVP(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(args[0].equals("true") || args[0].equals("enable") ){
            plugin.getServer().getWorld("world").setPVP(true);
        }
            else if(args[0].equals("disable") || args[0].equals("false")){
            plugin.getServer().getWorld("world").setPVP(false);
            }
            else
            sender.sendMessage("オプションにはenable(true)もしくはdisable(false)を入れてください");
        return true;
    }
}