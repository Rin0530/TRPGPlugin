package Rin.TRPG.Ratami;

import org.bukkit.command.*;
import org.bukkit.scoreboard.*;
import org.bukkit.entity.Player;

public class KP implements CommandExecutor{
    private Plugin plugin;
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private Team team;

    public KP(Plugin plugin){
        this.plugin = plugin;
        manager = plugin.getServer().getScoreboardManager();
        scoreboard = manager.getNewScoreboard();
        team = scoreboard.getTeam("KP");
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        //team.addEntry(sender.getName());
        PL pl = plugin.getPl().get(sender.getName());

        String giveBook = "give @p minecraft:written_book{display:{Name:'{\"text\":\"ステータス一覧\"}'},title:\"\",author:\"\",pages:['[{\"text\":\"ステータスの一覧です\nカーソルを重ねると\n値が見えます\nまたクリックすると\n1D100でダイスを振り\n成否を表示します\n\"}";
        for(String str : pl.getMain())
            giveBook += ",{\"text\":\""+str+": "+String.valueOf(pl.getMainStatus().get(str))+"\n\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/roll 1D100\"}}";
        giveBook += "]']} 1";
        for(Player player :plugin.getServer().getOnlinePlayers()){
            plugin.getServer().dispatchCommand(player,giveBook);
        }
        return true;
    }
        
}