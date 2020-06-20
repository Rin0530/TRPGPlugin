package Rin.TRPG.Ratami;

import org.bukkit.scoreboard.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Status implements CommandExecutor{
    private final Plugin plugin;
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private Objective objective;

    public Status(Plugin plugin){
        this.plugin = plugin;
        manager = plugin.getServer().getScoreboardManager();
        scoreboard = manager.getMainScoreboard();
        objective = scoreboard.getObjective("Status");
        if(objective == null){
            objective = scoreboard.registerNewObjective("Status", "dummy","Player's Status");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        /*
        サーバーからのコマンドは受け付けない
        */
        if(!(sender instanceof Player))
            return false;

        /*
        全プレイヤーのステータスを反映
         */
        for(Player p :plugin.getServer().getOnlinePlayers()){
            int health = (int)p.getHealth();
            objective.getScore(p.getName()+"'s HP").setScore(health);
            objective.getScore(p.getName()+"'s MP").setScore(p.getFoodLevel());
            objective.getScore(p.getName()+"'s SAN").setScore(p.getLevel());
        }
        return true;
    }
    
}