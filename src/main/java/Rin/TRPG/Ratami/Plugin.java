package Rin.TRPG.Ratami;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.GameRule;
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
        getCommand("change").setExecutor(new add(this));
        getCommand("removeBook").setExecutor(new SetFinished(this));
        getCommand("EnablePVP").setExecutor(new EnablePVP(this));
        getCommand("hp").setExecutor(new HP(this));
        getServer().getPluginManager().registerEvents(this,this);
        getLogger().info("Hello, SpigotMC!");

        //ゲームルール設定
        getServer().getWorld("world").setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        getServer().getWorld("world").setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        getServer().getWorld("world").setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        getServer().getWorld("world").setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        getServer().getWorld("world").setGameRule(GameRule.DO_MOB_SPAWNING, false);
        getServer().getWorld("world").setGameRule(GameRule.NATURAL_REGENERATION, false);
        getServer().getWorld("world").setGameRule(GameRule.SEND_COMMAND_FEEDBACK, false);
        getServer().getWorld("world").setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        getServer().getWorld("world").setGameRule(GameRule.FALL_DAMAGE, false);
        getServer().getWorld("world").setGameRule(GameRule.FIRE_DAMAGE, false);
        getServer().getWorld("world").setPVP(false);
        pl = new HashMap<>();
    }
    
    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent e){
        e.getPlayer().sendMessage("TRPG鯖へようこそ！！");
        /*プレイヤーのオブジェクトを生成 */
        pl.put(e.getPlayer().getName(), new PL(e.getPlayer(), this));

        getCommand("reflectStatus").setExecutor(new Status(this));
        
    }

    @EventHandler
    public void onInteract(PlayerDeathEvent e){
        e.setDeathMessage(e.getEntity().getName() + " キャラロスト");
        HumanEntity entity = e.getEntity();
        entity.setGameMode(GameMode.SPECTATOR);
    }
    

    /**
     * 引数の名前を持つオンラインプレイヤーのPLクラスのオブジェクトを返す
     * @return
     */
    public HashMap<String,PL> getPl(){
        return pl;     
    }
}
