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
        if(args.length == 0){
            sender.sendMessage("PvPの有効化 "+String.valueOf(plugin.getServer().getWorld("world").getPVP()));
            return true;
        }
        if(args[0].equals("true")){
            plugin.getServer().getWorld("world").setPVP(true);
        }
        else if(args[0].equals("false")){
        plugin.getServer().getWorld("world").setPVP(false);
        }
        else
        sender.sendMessage("オプションにはtrueもしくはfalseを入れてください");
        return true;
    }
}