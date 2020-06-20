package Rin.TRPG.Ratami;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.plugin.java.JavaPlugin ;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.BannerMeta;

/**
 * Hello world!
 *
 */
public class Plugin extends JavaPlugin implements Listener{
    private HashMap<String,PL> pl;
    private Inventory statusSet;
    

    @Override
    public void onEnable() {
        getCommand("reflectStatus").setExecutor(new Status(this));
        getCommand("roll").setExecutor(new roll(this));
        getServer().getPluginManager().registerEvents(this,this);
        getLogger().info("Hello, SpigotMC!");
        statusSet = getServer().createInventory(null, 27, "ステータス設定画面");
        pl = new HashMap<>();
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
        ItemStack statusSet = new ItemStack(Material.RED_BANNER);
        BannerMeta bannerMeta = (BannerMeta)statusSet.getItemMeta();
        bannerMeta.setDisplayName("ステータスを設定");
        e.getPlayer().getInventory().setItem(20, statusSet);
        pl.put(e.getPlayer().getName(), new PL(e.getPlayer(), this));
        e.getPlayer().updateInventory();
    }
    
    /**
     * アイテムクリックを検知
     */
    @EventHandler
    public void onInteract(InventoryClickEvent e){
        /*クリックしたアイテムを検知 */
        if(e.isLeftClick() && e.getSlot() == 20 && e.getCurrentItem().getType() == Material.RED_BANNER){
            e.setCancelled(true);
            getLogger().info("アイテムクリックを検知");
            /*クリックしたプレイヤーを検知 */
            Player player = (Player)e.getInventory().getHolder();
            player.openInventory(statusSet);
        }
    }
}
