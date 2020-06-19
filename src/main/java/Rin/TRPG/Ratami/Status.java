package Rin.TRPG.Ratami;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.*;
import org.bukkit.Server;
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
            objective = scoreboard.registerNewObjective("Status", "health","Player's Status");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        sender.sendMessage("ステータスをセットしたい");
        return true;
    }
    
}