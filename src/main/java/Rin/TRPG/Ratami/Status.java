package Rin.TRPG.Ratami;

import org.bukkit.scoreboard.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Status implements CommandExecutor{
    private final Plugin plugin;
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private Objective objective;
    private Team team;

    public Status(Plugin plugin){
        this.plugin = plugin;
        manager = plugin.getServer().getScoreboardManager();
        scoreboard = manager.getMainScoreboard();
        objective = scoreboard.getObjective("Status");
        if(objective == null){
            objective = scoreboard.registerNewObjective("Status", "dummy","Player's Status");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective =scoreboard.getObjective("Status");
        }
        team = scoreboard.getTeam("PL");
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
        PLプレイヤーのステータスを反映
         */
        for(String names :team.getEntries()){
            PL p = plugin.getPl().get(names);
            p.getPlayer().setScoreboard(scoreboard);
            int health = (int)p.getHP();
            objective.getScore(p.getName()+"'s HP").setScore((int)(health));
            objective.getScore(p.getName()+"'s MP").setScore(p.getPlayer().getFoodLevel());
            objective.getScore(p.getName()+"'s SAN").setScore(p.getPlayer().getLevel());
        }
        return true;
    }
    
}