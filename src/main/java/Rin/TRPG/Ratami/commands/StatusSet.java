package Rin.TRPG.Ratami.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import Rin.TRPG.Ratami.PL;
import Rin.TRPG.Ratami.Plugin;

public class StatusSet implements CommandExecutor{
    private Plugin plugin;

    public StatusSet(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage("サーバーからの実行は禁止です");
            return true;
        }
            
        PL senderPL = plugin.getPl().get(sender.getName());


        if(args[0].equals("main")){
            senderPL.setMainStatus(args[1], Integer.parseInt(args[2]));
            sender.sendMessage(args[1]+"を"+args[2]+"に設定しました");
        }else if(args[0].equals("other")){
            senderPL.addOtherStatus(args[1], Integer.parseInt(args[2]));
            //sender.sendMessage(args[1]+"を"+senderPL.getOtherStatus().get(args[1])+"に設定しました");
            sender.sendMessage(args[1]+"を"+senderPL.getObjective().getScore(args[1]).getScore()+"に設定しました。");
        }
        PlayerInventory inventory = senderPL.getPlayer().getInventory();
        inventory.remove(inventory.getItemInMainHand());
        return true;
    }
}
