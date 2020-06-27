package Rin.TRPG.Ratami;

import java.util.HashMap;


import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.entity.HumanEntity;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin ;


/**
 * Hello world!
 *
 */
public class Plugin extends JavaPlugin implements Listener{
    private HashMap<String,PL> pl;
    

    @Override
    public void onEnable() {

        /* コマンド有効化*/  
        getCommand("roll").setExecutor(new roll(this));
        getCommand("book").setExecutor(new StatusBook(this));
        getCommand("statusSet").setExecutor(new StatusSet(this));
        getCommand("KP").setExecutor(new KP(this));
        getCommand("PL").setExecutor(new GiveBook(this));
        getCommand("add").setExecutor(new add(this));
        getCommand("removeBook").setExecutor(new SetFinished(this));
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

        getCommand("reflectStatus").setExecutor(new Status(this));
        
    }
    
    /**
     * ダメージキャンセル
     */
    @EventHandler
    public void onInteract(EntityDamageEvent e){
        if(e.getCause() == DamageCause.FALL){
            e.setCancelled(true);
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
