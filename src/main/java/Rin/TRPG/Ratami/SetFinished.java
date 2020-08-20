package Rin.TRPG.Ratami;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

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
        for(String value :senderPL.getMainStatus().keySet()){
            if(senderPL.getMainStatus().get(value) == -1){
                sender.sendMessage(value+"が設定されていません");
                return true;
            }
        }
        senderPL.getPlayer().getInventory().remove(senderPL.getPlayer().getInventory().getItemInMainHand());
        senderPL.giveBook(sender);
        return true;
    }
}