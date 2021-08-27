package Rin.TRPG.Ratami.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import Rin.TRPG.Ratami.PL;
import Rin.TRPG.Ratami.Plugin;

public class KP implements CommandExecutor{
    private Plugin plugin;
    Scoreboard board;
    ScoreboardManager manager;
    Team player;
    Team keeper;
    

    public KP(Plugin plugin){
        this.plugin = plugin;
        player = plugin.getPLTeam();
        keeper = plugin.getKPTeam();
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage("サーバーからの実行は禁止です");
            return true;
        }

        
        String target = sender.getName();
        PL targetPlayer = plugin.getPl().get(target);
        
        //plugin.getPl().get(target).setIsKP(true);
        targetPlayer.getPlayer().addScoreboardTag("KP");
        targetPlayer.getPlayer().setOp(true);

        if(args.length == 0 || !args[0].equals("kpc")){
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "team join KP "+target);
            sender.sendMessage("KPになりました");
        }else if(sender instanceof Player){
            sender.sendMessage("KPCになりました");
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "team join PL "+target);
        }
        return true;
    }
}