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
    Team player;
    Team keeper;
    

    public KP(Plugin plugin){
        this.plugin = plugin;
        /*manager = plugin.getServer().getScoreboardManager();
        board = manager.getMainScoreboard();
        team  = board.getTeam("PL");
        if(team == null){
            team = board.registerNewTeam("PL");
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "say PLチームの取得に失敗");
            team  = board.getTeam("PL");
        }*/
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

        boolean haveKP = false;

        for(String name: plugin.getPl().keySet()){
            //haveKP = plugin.getPl().get(name).getIsKP();
            haveKP = plugin.getPl().get(name).getPlayer().getScoreboardTags().contains("KP");
            if(haveKP)
                break;
        }

        if(!haveKP){
            for(String names :player.getEntries()){
                PL player = plugin.getPl().get(names);
                if(player == null){
                    //sender.sendMessage(names);
                    continue;
                }
                player.getPlayer().setOp(false);
                player.getPlayer().setGameMode(GameMode.ADVENTURE);
                }
        }
        
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