package Rin.TRPG.Ratami;

import java.util.HashMap;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.command.*;

public class roll implements CommandExecutor{

    private final Plugin plugin;
    private ScoreboardManager scoreboardManager;
    private Scoreboard scoreboard;
    private Team team;
    
    public roll(Plugin plugin){
        this.plugin = plugin;
        scoreboardManager = plugin.getServer().getScoreboardManager();
        scoreboard = scoreboardManager.getNewScoreboard();
        team = scoreboard.getTeam("PL");
    }

    /**
     * 引数で与えられた数値以下の値でダイスを一回振り、
     * 結果を実行者に表示する
     */
    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){

        /*引数に整数以外が与えられた場合の例外処理*/
        try {
            String[] diceRoll = args[0].split("D");
            int parseInt = Integer.parseInt(diceRoll[1]);
            int random = -1;
            HashMap<String,Integer> senderStatus = plugin.getPl().get(sender.getName()).getOtherStatus();

            for(int i = 0;i < Integer.parseInt(diceRoll[0]);i++){
                random = new Random().nextInt(parseInt) + 1;
                
                String result = String.valueOf(random);
                String senderName = plugin.getPl().get(sender.getName()).getName();
                

                if(args.length == 3){
                
                    //コマンドの第3引数に技能のどれか含まれていれば
                    if(senderStatus.containsKey(args[2]) || plugin.getPl().get(sender.getName()).getsubStatus().containsKey(args[2])) {
                        if(plugin.getPl().get(sender.getName()).getsubStatus().containsKey(args[2]))
                            senderStatus = plugin.getPl().get(sender.getName()).getsubStatus();
                        result = senderName + args[2]+"("+senderStatus.get(args[2])+")";
                        if(senderStatus.get(args[2]) < random){
                            result += " < "+ String.valueOf(random);
                            if(random >= 95){
                                result += " 致命的";
                            }
                            result += "失敗";
                        }
                        else{
                            result += " >= "+ String.valueOf(random);
                            if(random <= 5){
                                result += " 決定的";
                            }
                            result += "成功";
                        }
                    }
                }

                /*オプションがなければ結果は全員に通知*/
                if(args.length == 1 || !args[1].equals("secret")){
                    for(Player player: plugin.getServer().getOnlinePlayers()){
                        player.sendMessage(result);
                        
                    }
                    continue;
                }
                

                /*オプションでsecretが指定されれば自分とKPにのみ通知 */
                if(args.length != 1 && args[1].equals("secret")){
                    sender.sendMessage(String.valueOf(random));
                    for(String names :team.getEntries()){
                        PL p = plugin.getPl().get(names);
                        p.getPlayer().sendMessage(String.valueOf(random));
                    }
                    
                }
            }
            
            

        } catch (Exception e) {
            return false;
        }
        return true;
        
    }
}