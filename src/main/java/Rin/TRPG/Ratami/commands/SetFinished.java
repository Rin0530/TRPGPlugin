package Rin.TRPG.Ratami.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import Rin.TRPG.Ratami.PL;
import Rin.TRPG.Ratami.Plugin;

public class SetFinished implements CommandExecutor{
    private Plugin plugin;

    public SetFinished(Plugin plugin){
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
        for(String value :senderPL.getMainStatus()){
            if(!senderPL.getObjective().getScore(value).isScoreSet()){
                sender.sendMessage(value+"が設定されていません");
                return true;
            }
        }
        PlayerInventory inventory = senderPL.getPlayer().getInventory();
        inventory.remove(inventory.getItemInMainHand());
        senderPL.giveBook(sender);
        return true;
    }
}