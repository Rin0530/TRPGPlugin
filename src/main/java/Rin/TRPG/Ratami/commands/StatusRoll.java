package Rin.TRPG.Ratami.commands;


import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Rin.TRPG.Ratami.Plugin;

public class StatusRoll implements CommandExecutor{
    private Plugin plugin;

    public StatusRoll(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(!(sender instanceof Player)){
            plugin.getServer().getLogger().info("サーバーからの実行は禁止です");
        }
        Player player = (Player)sender;
        ItemStack[] items = {new ItemStack(Material.RED_WOOL), new ItemStack(Material.BLUE_WOOL), new ItemStack(Material.GREEN_WOOL), new ItemStack(Material.YELLOW_WOOL), new ItemStack(Material.WHITE_WOOL)};
        Inventory inv = plugin.getServer().createInventory(null, 9,"倍率選択");

        for(int i = 0;i < items.length;i++){
            ItemMeta itemmeta = items[i].getItemMeta();
            itemmeta.setDisplayName(args[0]+"＊"+String.valueOf(i+1));
            itemmeta.setLore(Arrays.asList(args[0]+"*"+String.valueOf(i+1)));
            items[i].setItemMeta(itemmeta);
            inv.setItem(i*2, items[i]);
        }
        player.openInventory(inv);
        return true;
    }
}
