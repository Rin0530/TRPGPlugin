package Rin.TRPG.Ratami;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.plugin.java.JavaPlugin ;
import org.bukkit.inventory.*;

/**
 * Hello world!
 *
 */
public class Plugin extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        getCommand("setStatus").setExecutor(new Status(this));
        getCommand("roll").setExecutor(new roll(this));
        getServer().getPluginManager().registerEvents(this,this);
        getLogger().info("Hello, SpigotMC!");
    }
    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }
    @EventHandler
    public void onLogin(PlayerJoinEvent e){
        e.getPlayer().sendMessage("TRPG鯖へようこそ！！");
        setInventry(e);
    }

    /**ログイン時に赤い旗をインベントリに追加 */
    public void setInventry(PlayerJoinEvent e){
        ItemStack str = new ItemStack(Material.RED_BANNER);
        e.getPlayer().getInventory().setItem(20, str);

        e.getPlayer().updateInventory();
    }
    
    @EventHandler
    public void onInteract(InventoryClickEvent e){
        if(e.isLeftClick() && e.getSlot() == 20 && e.getCurrentItem().getType() == Material.RED_BANNER)
            e.setCancelled(true);
        getLogger().info("アイテムクリックを検知");
    }
}
