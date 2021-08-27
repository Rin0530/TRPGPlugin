package Rin.TRPG.Ratami.commands;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
//import java.util.HashMap;
import java.util.Set;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import Rin.TRPG.Ratami.PL;
import Rin.TRPG.Ratami.Plugin;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

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
        String[] diceRoll;
        int parseInt;
        
        int diceCount = 0;
        SecureRandom seed;
        try {
            seed = SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception e) {
            plugin.getLogger().warning("乱数生成器の作成に失敗");
            return false;
        }

        //objective = plugin.getPl().get(sender.getName()).getObjective();

        List<TextComponent> components = new ArrayList<>();

        /*引数に整数以外が与えられた場合の例外処理*/
        try {
            diceRoll = args[0].toUpperCase().split("D");
            diceCount = Integer.parseInt(diceRoll[0]);
            parseInt = Integer.parseInt(diceRoll[1]);
        } catch (Exception e) {
            plugin.getLogger().info(e.toString()+"\nコマンドのオプションが間違っています");
            return false;
        }

        for(int i = 0;i < diceCount;i++){
            TextComponent component = new TextComponent();
            int random = -1;
            if(parseInt == 100)
                random = (int)(Math.random()*99) + 1;
            else
                random = seed.nextInt(parseInt) + 1;

            if(sender instanceof Player)
                component = clientRoll(sender, args, random, component);
            else
                component = serverRoll(args, random, component);
            components.add(component);
        }
        boolean isSecret = args.length >= 2 && args[1].equals("secret");
        components.forEach(c -> sendResult(c, isSecret));
        return true;
    }

    private TextComponent clientRoll(CommandSender sender,String[] args,int random,TextComponent component){
        Objective objective = plugin.getPl().get(sender.getName()).getObjective();
        String senderName = plugin.getPl().get(sender.getName()).getName();
        String result = senderName + " " + String.valueOf(random);
        //技能値を取得
        Set<String> senderStatus = objective.getScoreboard().getEntries();
        String skill = "";
        
            if(args.length >= 2){

                if(!args[1].equals("secret"))
                    skill = args[1];
                else if(!(args.length == 2))
                        skill = args[2];

                //コマンドの第3引数に技能のどれか含まれていれば
                if(senderStatus.contains(objective.getScore(skill).getEntry()) || skill.indexOf("SAN") >= 0) {
                    //依存能力値を取得
                    result = senderName +" "+ skill+"("+objective.getScore(skill).getScore()+")";
                    //成否を判定
                    if(objective.getScore(skill).getScore() < random){
                        result += " < "+ String.valueOf(random);
                        if(random >= 95){
                            result += " 致命的";
                        }
                        result += "失敗";
                        component.setColor(ChatColor.RED);
                    }
                    else{
                        result += " >= "+ String.valueOf(random);
                        if(random <= 5){
                            result += " 決定的";
                            //component.setColor(ChatColor.BLUE);
                        }
                        result += "成功";
                        component.setColor(ChatColor.AQUA);
                    }
                }
            }
        component.setText(result);
        return component;
    }

    private TextComponent serverRoll(String[] args,int random,TextComponent component){
        String result = String.valueOf(random);
        component.setText(result);
        return component;
    }

    private void sendResult(TextComponent component, boolean isSecret){
        if(isSecret){
            plugin.getLogger().info(component.getText());
            for(String name : plugin.getPl().keySet()){
                PL p = plugin.getPl().get(name);
                if(p.getPlayer().getScoreboardTags().contains("KP")){
                    p.getPlayer().sendMessage("KPに通知");
                    p.getPlayer().spigot().sendMessage(component);
                }
            }
        }else
            plugin.getServer().spigot().broadcast(component);
    }

}