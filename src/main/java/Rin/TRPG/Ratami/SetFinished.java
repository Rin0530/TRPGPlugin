package Rin.TRPG.Ratami;

import org.bukkit.command.*;

public class SetFinished implements CommandExecutor{
    private Plugin plugin;

    public SetFinished(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        plugin.getServer().dispatchCommand(sender, "clear @p minecraft:written_book{display:{Name:'{\"text\":\"ステータス設定\",\"color\":\"red\",\"bold\":true,\"italic\":true}'}} 1");
        PL pl = plugin.getPl().get(sender.getName());
        pl.giveBook(sender);
        return true;
    }
}