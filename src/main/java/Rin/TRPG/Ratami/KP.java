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

    public KP(Plugin plugin){
        this.plugin = plugin;
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),"team add KP");
        manager = plugin.getServer().getScoreboardManager();
        board = manager.getNewScoreboard();
        team = board.getTeam("KP");
        if(team == null){
            team = board.registerNewTeam("KP");
            team.setDisplayName("KP");
            team.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        ((Player)sender).setScoreboard(board);

        String target = sender.getName();
        if(args.length == 1)
            target = args[0];
        plugin.getServer().dispatchCommand(sender, "team join KP "+target);

        PL pl = plugin.getPl().get(sender.getName());
        plugin.getServer().dispatchCommand(sender,pl.getGiveBook());

        return true;
    }
        
}