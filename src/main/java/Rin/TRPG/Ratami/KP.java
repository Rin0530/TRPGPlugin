package Rin.TRPG.Ratami;

import org.bukkit.GameMode;
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
        board = manager.getMainScoreboard();
        team  = board.getTeam("PL");
        if(team == null){
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "say PLチームの取得に失敗");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(team==null){
            sender.sendMessage("PLがnullです");
            team  = board.getTeam("PL");
        }
        String target = sender.getName();
        if(args.length == 1)
            target = args[0];
        for(String names :team.getEntries()){
            PL player = plugin.getPl().get(names);
            player.getPlayer().setGameMode(GameMode.ADVENTURE);
            plugin.getServer().dispatchCommand(sender,"give " + names +player.getGiveBook());
            player.getPlayer().setOp(false);
        }
        
        
        plugin.getServer().dispatchCommand(sender, "team join KP "+target);
        

        return true;
    }
        
}