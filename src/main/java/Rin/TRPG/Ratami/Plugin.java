package Rin.TRPG.Ratami;

import java.util.HashMap;


import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin ;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

import Rin.TRPG.Ratami.commands.EnablePVP;
import Rin.TRPG.Ratami.commands.GiveBook;
import Rin.TRPG.Ratami.commands.KP;
import Rin.TRPG.Ratami.commands.Name;
import Rin.TRPG.Ratami.commands.SetFinished;
import Rin.TRPG.Ratami.commands.StatusBook;
import Rin.TRPG.Ratami.commands.StatusRoll;
import Rin.TRPG.Ratami.commands.StatusSet;
import Rin.TRPG.Ratami.commands.change;
import Rin.TRPG.Ratami.commands.roll;


/**
 * Hello world!
 *
 */
public class Plugin extends JavaPlugin implements Listener{
    private boolean isReflecting;
    private HashMap<String,PL> pl;
    private Scoreboard board_pl;
    private Scoreboard board_kp;
    private Scoreboard board_viewer;
    private ScoreboardManager manager;
    private Team PL;
    private Team KP;
    private Team Viewer;
    

    @Override
    public void onEnable() {

        // Team設定
        manager = getServer().getScoreboardManager();
        board_pl = manager.getMainScoreboard();
        board_kp = manager.getMainScoreboard();
        board_viewer = manager.getMainScoreboard();

        PL = board_pl.getTeam("PL");
        if(PL == null){
            PL = board_pl.registerNewTeam("PL");
            PL.setDisplayName("PL");
            PL.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
            PL.setOption(Option.COLLISION_RULE, OptionStatus.NEVER);
            PL.setCanSeeFriendlyInvisibles(false);
            PL = board_pl.getTeam("PL");
        }

        KP = board_kp.getTeam("KP");
        if(KP == null){
            KP = board_kp.registerNewTeam("KP");
            KP.setDisplayName("KP");
            KP.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
            KP.setOption(Option.COLLISION_RULE, OptionStatus.NEVER);
            KP.setCanSeeFriendlyInvisibles(false);
            KP = board_kp.getTeam("KP");
        }

        Viewer = board_viewer.getTeam("VIEWER");
        if(Viewer == null){
            Viewer = board_viewer.registerNewTeam("VIEWER");
            Viewer.setDisplayName("VIEWER");
            Viewer.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
            Viewer.setOption(Option.COLLISION_RULE, OptionStatus.NEVER);
            Viewer.setCanSeeFriendlyInvisibles(false);
            Viewer = board_viewer.getTeam("VIEWER");
        }

        /* コマンド有効化*/  
        getCommand("roll").setExecutor(new roll(this));
        getCommand("statusroll").setExecutor(new StatusRoll(this));
        getCommand("book").setExecutor(new StatusBook(this));
        getCommand("statusSet").setExecutor(new StatusSet(this));
        getCommand("kp").setExecutor(new KP(this));
        getCommand("pc").setExecutor(new GiveBook(this));
        getCommand("change").setExecutor(new change(this));
        getCommand("removeBook").setExecutor(new SetFinished(this));
        getCommand("enablepvp").setExecutor(new EnablePVP(this));
        getCommand("displayname").setExecutor(new Name(this));
        getServer().getPluginManager().registerEvents(this,this);
        getLogger().info("Hello, TRPG!");

        //ゲームルール設定
        getServer().getWorlds().forEach(world -> {
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        world.setGameRule(GameRule.NATURAL_REGENERATION, false);
        world.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, false);
        world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        world.setGameRule(GameRule.FALL_DAMAGE, false);
        world.setGameRule(GameRule.FIRE_DAMAGE, false);
        world.setPVP(false);
        });

        pl = new HashMap<>();
        isReflecting = false;
    }


    @Override
    public void onDisable() {
        getLogger().info("See you again, TRPG!");
        getServer().dispatchCommand(getServer().getConsoleSender(), "scoreboard objectives remove Status");
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent e){
        e.getPlayer().sendMessage("TRPG鯖へようこそ！！");
        /*プレイヤーのオブジェクトを生成 */
        if(!pl.containsKey(e.getPlayer().getName()))
            pl.put(e.getPlayer().getName(), new PL(e.getPlayer(), this));
    }

    /**
     * プレイヤーが死亡したとき即座にスペクテイターでリスポーン
     * @param e
     */
    @EventHandler
    public void onInteract(PlayerDeathEvent e){
        HumanEntity entity = e.getEntity();
        getServer().dispatchCommand(getServer().getConsoleSender(), "team join VIEWER "+entity.getName());
        Location location = entity.getLocation();
        getServer().dispatchCommand(getServer().getConsoleSender(), "spawnpoint "+entity.getName()+" "+String.valueOf((int)location.getX())+" "+String.valueOf((int)location.getY())+" "+String.valueOf((int)location.getZ()));
        entity.setGameMode(GameMode.SPECTATOR);
    }

    @EventHandler
    public void onInteract(InventoryClickEvent e){
        if(e.getClickedInventory() == null || e.getClickedInventory().getSize() != 9)
            return;

        getServer().dispatchCommand(e.getWhoClicked(), "roll 1D100 "+ e.getCurrentItem().getItemMeta().getLore().get(0));
        e.setCancelled(true);
        e.getWhoClicked().closeInventory();
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(command.getName().equals("reflect")){
            if(!isReflecting){
            new Status(this).runTaskTimer(this, 0, 10);
            isReflecting = true;
            }else
                sender.sendMessage("このコマンドはすでに実行中です");
        }
        return true;
    }

    /**
     * 引数の名前を持つオンラインプレイヤーのPLクラスのオブジェクトを返す
     * @return
     */
    public HashMap<String,PL> getPl(){
        return pl;
    }

    public Team getPLTeam(){
        return PL;
    }

    public Team getKPTeam(){
        return KP;
    }

    public Team getViewerTeam(){
        return Viewer;
    }

}
