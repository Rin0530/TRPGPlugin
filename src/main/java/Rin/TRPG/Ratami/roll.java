package Rin.TRPG.Ratami;

import java.util.Random;

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
        if(args.length != 1){
            sender.sendMessage("コマンドのオプションに整数を1つ指定してください");
        return true;
        }

        /*引数に整数以外が与えられた場合の例外処理*/
        try {
            int parseInt = Integer.parseInt(args[0]);
            int random = new Random().nextInt(parseInt) + 1;
            sender.sendMessage(String.valueOf(random));
        } catch (Exception e) {
            //TODO: handle exception
            sender.sendMessage("コマンドのオプションには整数を指定してください");
        }
        return true;
        
    }
}