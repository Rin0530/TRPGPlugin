package Rin.TRPG.Ratami;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.*;

public class KP implements CommandExecutor{
    private Plugin plugin;
    Scoreboard board;
    ScoreboardManager manager;
    Team team;
    Team pl;

    public KP(Plugin plugin){
        this.plugin = plugin;
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),"team add KP");
        manager = plugin.getServer().getScoreboardManager();
        board = manager.getNewScoreboard();
        team = board.getTeam("KP");
        pl = board.getTeam("PL");
        if(team == null){
            team = board.registerNewTeam("KP");
            team.setDisplayName("KP");
            team.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
            team = board.getTeam("KP");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        ((Player)sender).setScoreboard(board);

        String target = sender.getName();
        if(args.length == 1)
            target = args[0];
        for(String names :pl.getEntries()){
            PL player = plugin.getPl().get(names);
            plugin.getServer().dispatchCommand(sender,"give " + names + player.getGiveBook());
        }
        
        
        plugin.getServer().dispatchCommand(sender, "team join KP "+target);

        return true;
    }
        
}