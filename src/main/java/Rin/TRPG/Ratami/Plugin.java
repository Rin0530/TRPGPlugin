package Rin.TRPG.Ratami;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin ;


/**
 * Hello world!
 *
 */
public class Plugin extends JavaPlugin implements Listener{
    private HashMap<String,PL> pl;
    private boolean isMagic;
    private boolean canDamaged;
    

    @Override
    public void onEnable() {

        /* コマンド有効化*/  
        getCommand("roll").setExecutor(new roll(this));
        getCommand("book").setExecutor(new StatusBook(this));
        getCommand("statusSet").setExecutor(new StatusSet(this));
        getCommand("kp").setExecutor(new KP(this));
        getCommand("pl").setExecutor(new GiveBook(this));
        getCommand("change").setExecutor(new change(this));
        getCommand("removeBook").setExecutor(new SetFinished(this));
        getCommand("enablepvp").setExecutor(new EnablePVP(this));
        getCommand("reflectStatus").setExecutor(new Status(this));
        getCommand("displayname").setExecutor(new Name(this));
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
        

        isMagic = false;
        canDamaged = false;
        getServer().getWorld("world").setPVP(canDamaged);

        pl = new HashMap<>();
    }
    
    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
        getServer().dispatchCommand(getServer().getConsoleSender(), "scoreboard objectives remove Status");
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent e){
        e.getPlayer().sendMessage("TRPG鯖へようこそ！！");
        /*プレイヤーのオブジェクトを生成 */
        pl.put(e.getPlayer().getName(), new PL(e.getPlayer(), this));
        e.getPlayer().setOp(true);
    }

    @EventHandler
    public void onInteract(PlayerDeathEvent e){
        HumanEntity entity = e.getEntity();
        entity.setGameMode(GameMode.SPECTATOR);
    }

    @EventHandler
    public void onInteract(FoodLevelChangeEvent e){
         if(isMagic){
            isMagic = false;
        }else
            e.setCancelled(true);
            getServer().dispatchCommand(getServer().getConsoleSender(), "reflectstatus");
    }

    @EventHandler
    public void onInteract(ItemDespawnEvent e){
        e.setCancelled(true);
    }

    /**
     * 引数の名前を持つオンラインプレイヤーのPLクラスのオブジェクトを返す
     * @return
     */
    public HashMap<String,PL> getPl(){
        return pl;     
    }

    public void setIsMagic(boolean isMagic){
        this.isMagic = isMagic;
    }

    public void setCanDamaged(boolean canDamaged){
        this.canDamaged = canDamaged;
    }

}
