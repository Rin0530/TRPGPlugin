package Rin.TRPG.Ratami;

import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

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
            return true;
        }

        plugin.setIsSession(true);
        String target = sender.getName();

        for(String names :team.getEntries()){
            PL player = plugin.getPl().get(names);
            player.getPlayer().setOp(false);
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),"give " + names +player.getGiveBook());
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "kill @e[type=item]");
            player.getPlayer().setGameMode(GameMode.ADVENTURE);
            }
        
        if(sender instanceof Player)
            sender.sendMessage("KPになりました");
        
        plugin.getPl().get(target).setIsKP(true);
        plugin.getPl().get(target).getPlayer().setOp(true);

        if(args.length == 0 || !args[0].equals("npc")){
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "team join KP "+target);
        }
        
        return true;
    }
}