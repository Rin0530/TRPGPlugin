package Rin.TRPG.Ratami;

import java.util.HashMap;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.command.*;

public class roll implements CommandExecutor{

    private final Plugin plugin;
    
    public roll(Plugin plugin){
        this.plugin = plugin;
    }

    /**
     * 引数で与えられた数値以下の値でダイスを一回振り、
     * 結果を実行者に表示する
     */
    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        /*コマンドの引数が櫃１つじゃないとき
        正しい使い方を表示する*/
        if(args.length > 2){
            sender.sendMessage("コマンドのオプションが間違っています");
        return true;
        }

        /*引数に整数以外が与えられた場合の例外処理*/
        try {
            String[] diceRoll = args[0].split("d");
            int parseInt = Integer.parseInt(diceRoll[1]);
            int random = -1;
            for(int i = 0;i < Integer.parseInt(diceRoll[0]);i++){
                random = new Random().nextInt(parseInt) + 1;
            }
            
            /*オプションがなければ結果は全員に通知*/
            if(args.length == 1){
                for(Player player: plugin.getServer().getOnlinePlayers()){
                    player.sendMessage(String.valueOf(random));
                    return true;
                }
            }

            /*オプションでsecretが指定されれば自分とKPにのみ通知 */
            if(args[1].equals("secret")){
                sender.sendMessage(String.valueOf(random));
                for(String name :plugin.getPl().keySet()){
                    if(plugin.getPl().get(name).getIsKP())
                    plugin.getPl().get(name).getPlayer().sendMessage(String.valueOf(random));
                }
                
            }else {
                sender.sendMessage("シークレットダイスはsecretをつけてください");
            }

        } catch (Exception e) {
            sender.sendMessage("コマンドのオプションには1d100のように指定してください");
        }
        return true;
        
    }
}