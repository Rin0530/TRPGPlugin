package Rin.TRPG.Ratami;

import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin ;


/**
 * Hello world!
 *
 */
public class Plugin extends JavaPlugin implements Listener{
    private HashMap<String,PL> pl;
    private boolean canDamaged;
    private boolean isSession;
    

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
        

        canDamaged = false;
        isSession = false;
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
        if(!pl.containsKey(e.getPlayer().getName()))
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
            getServer().dispatchCommand(getServer().getConsoleSender(), "reflectstatus");
    }

    /**
     * 引数の名前を持つオンラインプレイヤーのPLクラスのオブジェクトを返す
     * @return
     */
    public HashMap<String,PL> getPl(){
        return pl;
    }


    public void setCanDamaged(boolean canDamaged){
        this.canDamaged = canDamaged;
    }

    public void setIsSession(boolean isSession){
        this.isSession = isSession;
    }

    public boolean getIsSession(){
        return isSession;
    }

}
