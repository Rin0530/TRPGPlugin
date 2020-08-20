package Rin.TRPG.Ratami;

import org.bukkit.command.*;
import org.bukkit.scoreboard.*;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Status implements CommandExecutor{
    private Plugin plugin;
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private Team team;
    private Objective objective;

    public Status(Plugin plugin){
        this.plugin = plugin;
        manager = plugin.getServer().getScoreboardManager();
        scoreboard = manager.getMainScoreboard();
        team = plugin.getPLTeam();
        
    }

    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(objective != null) 
            objective.unregister();
            
        objective = scoreboard.getObjective("Status");
        if(objective == null){
            objective = scoreboard.registerNewObjective("Status", "dummy","Player's Status");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective =scoreboard.getObjective("Status");
        }
        int num = -1;
        /*
        オンラインのプレイヤー全員にスコアボードをセット
        */
        for(String names :plugin.getPl().keySet()){
            PL p = plugin.getPl().get(names);
            p.getPlayer().setScoreboard(scoreboard);
            
            //plugin.getServer().getLogger().info(names);
            if(team.getEntries().contains(names)){
                int health = (int)p.getHP();
                objective.getScore(p.getName()+"'s HP "+String.valueOf(health)).setScore(num--);
                objective.getScore(p.getName()+"'s MP "+String.valueOf(p.getMP())).setScore(num--);
                objective.getScore(p.getName()+"'s SAN "+String.valueOf(p.getSAN())).setScore(num--);

                // アクションバーにMPを表示
                String displayMP = "MP " + String.valueOf(p.getMP());
                TextComponent component = new TextComponent();
                component.setText(displayMP);
                p.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
            }
        
        }
        //num = -1;
        return true;
    }

}