package Rin.TRPG.Ratami;

import org.bukkit.scoreboard.*;
import org.bukkit.command.*;

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
            objective =scoreboard.getObjective("Status");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(!plugin.getIsSession()){
            return true;
        }
        /*
        オンラインのプレイヤー全員にスコアボードをセット
        */
        for(String names :plugin.getPl().keySet()){
            PL p = plugin.getPl().get(names);
            p.getPlayer().setScoreboard(scoreboard);
            
            if(p.getName().equals(null))
                break;
            int health = (int)p.getHP();
            objective.getScore(p.getName()+"'s HP").setScore((int)(health));
            objective.getScore(p.getName()+"'s MP").setScore(p.getMP());
            objective.getScore(p.getName()+"'s SAN").setScore(p.getPlayer().getLevel());
        }
        return true;
    }

}