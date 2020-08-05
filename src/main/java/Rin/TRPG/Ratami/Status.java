package Rin.TRPG.Ratami;

import org.bukkit.command.*;
import org.bukkit.scoreboard.*;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Status implements CommandExecutor{
    private Plugin plugin;
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

    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        /*
        オンラインのプレイヤー全員にスコアボードをセット
        */
        for(String names :plugin.getPl().keySet()){
            PL p = plugin.getPl().get(names);
            p.getPlayer().setScoreboard(scoreboard);
            
            if(!(p.getName().equals(null))){
            int health = (int)p.getHP();
            objective.getScore(p.getName()+"'s HP").setScore((int)health);
            objective.getScore(p.getName()+"'s MP").setScore(p.getMP());
            objective.getScore(p.getName()+"'s SAN").setScore(p.getPlayer().getLevel());

            // アクションバーにMPを表示
            String displayMP = "MP " + String.valueOf(p.getMP());
            TextComponent component = new TextComponent();
            component.setText(displayMP);
            p.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
            }
        
        }
        return true;
    }

}