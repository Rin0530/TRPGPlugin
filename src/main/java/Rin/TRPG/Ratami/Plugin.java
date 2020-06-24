package Rin.TRPG.Ratami;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.plugin.java.JavaPlugin ;


/**
 * Hello world!
 *
 */
public class Plugin extends JavaPlugin implements Listener{
    private HashMap<String,PL> pl;
    

    @Override
    public void onEnable() {
        getCommand("reflectStatus").setExecutor(new Status(this));
        getCommand("roll").setExecutor(new roll(this));
        getCommand("book").setExecutor(new StatusBook(this));
        getCommand("statusSet").setExecutor(new StatusSet(this));
        getCommand("KP").setExecutor(new KP(this));
        getServer().getPluginManager().registerEvents(this,this);
        getLogger().info("Hello, SpigotMC!");
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
        /*プレイヤーのオブジェクトを生成 */
        pl.put(e.getPlayer().getName(), new PL(e.getPlayer(), this));
        
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
            player.openInventory(pl.get(player.getName()).getInventory());
        }
    }

    /**
     * 引数の名前を持つオンラインプレイヤーのPLクラスのオブジェクトを返す
     * @return
     */
    public HashMap<String,PL> getPl(){
        return pl;     
    }
}
