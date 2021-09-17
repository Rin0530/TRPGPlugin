package Rin.TRPG.Ratami.commands;

import org.bukkit.World;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import Rin.TRPG.Ratami.Plugin;

public class EnablePVP implements CommandExecutor{
    private Plugin plugin;

    public EnablePVP(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("サーバーからの実行は禁止です");
            return true;
        }
        World world = ((Player)sender).getWorld();
        if(args.length == 0){
            sender.sendMessage("PvPの有効化 "+String.valueOf(world.getPVP()));
            return true;
        }
        if(args[0].equals("true")){
            world.setPVP(true);
        }
        else if(args[0].equals("false")){
        world.setPVP(false);
        }
        else
        sender.sendMessage("オプションにはtrueもしくはfalseを入れてください");
        return true;
    }
}