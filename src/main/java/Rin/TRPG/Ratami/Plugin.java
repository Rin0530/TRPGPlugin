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
    private PL pl;

    @Override
    public void onEnable() {
        getCommand("reflectStatus").setExecutor(new Status(this));
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
        e.getPlayer().setOp(true);
        setInventry(e);
    }

    /**
     * ログイン時に赤い旗をインベントリに追加 
     * ステータスを保存
     */
    public void setInventry(PlayerJoinEvent e){
        ItemStack str = new ItemStack(Material.RED_BANNER);
        e.getPlayer().getInventory().setItem(20, str);
        pl = new PL(e.getPlayer());
        e.getPlayer().updateInventory();
    }
    
    @EventHandler
    public void onInteract(InventoryClickEvent e){
        if(e.isLeftClick() && e.getSlot() == 20 && e.getCurrentItem().getType() == Material.RED_BANNER){
            e.setCancelled(true);
            getLogger().info("アイテムクリックを検知");
        }
    }
}
