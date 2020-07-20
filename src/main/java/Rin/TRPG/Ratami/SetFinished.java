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
        senderPL.getPlayer().getInventory().remove(senderPL.getPlayer().getInventory().getItemInMainHand());
        PL pl = plugin.getPl().get(sender.getName());
        pl.giveBook(sender);
        return true;
    }
}