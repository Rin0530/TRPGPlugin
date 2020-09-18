package Rin.TRPG.Ratami;

import java.security.SecureRandom;
//import java.util.HashMap;
import java.util.Set;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public class roll implements CommandExecutor{

    private final Plugin plugin;
    private Objective objective;
    
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
        
        if(!(sender instanceof Player)){
            return serverRoll(args);
        }

        objective = plugin.getPl().get(sender.getName()).getObjective();


        TextComponent component = new TextComponent();

        /*引数に整数以外が与えられた場合の例外処理*/
        try {
            String[] diceRoll = args[0].split("D");
            int parseInt = Integer.parseInt(diceRoll[1]);
            
            int random = -1;

            String skill = "";
            String senderName = plugin.getPl().get(sender.getName()).getName();
            SecureRandom seed = SecureRandom.getInstance("SHA1PRNG");

            //技能値を取得
            //HashMap<String,Integer> senderStatus = plugin.getPl().get(sender.getName()).getOtherStatus();
            Set<String> senderStatus = objective.getScoreboard().getEntries();

            for(int i = 0;i < Integer.parseInt(diceRoll[0]);i++){
                if(parseInt == 100)
                    random = (int)(Math.random()*99) + 1;
                else
                    random = seed.nextInt(parseInt) + 1;
                String result = senderName + " " + String.valueOf(random);
                
                
                if(args.length >= 2){

                    if(!args[1].equals("secret"))
                        skill = args[1];
                    else
                        if(!(args.length == 2))
                            skill = args[2];
                    
                    //sender.sendMessage(objective.getScore(skill).getEntry());

                    //コマンドの第3引数に技能のどれか含まれていれば
                    //if(senderStatus.containsKey(skill) || plugin.getPl().get(sender.getName()).getsubStatus().containsKey(skill) || skill.indexOf("SAN") >= 0) {
                    if(senderStatus.contains(objective.getScore(skill).getEntry()) || skill.indexOf("SAN") >= 0) {
                        
                        //依存能力値を取得
                        /*if(plugin.getPl().get(sender.getName()).getsubStatus().containsKey(skill)){
                            senderStatus = plugin.getPl().get(sender.getName()).getsubStatus();
                        }*/
                        result = senderName +" "+ skill+"("+objective.getScore(skill).getScore()+")";
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

                    component.setText(result);
                    
                    /*オプションでsecretが指定されれば自分とKPにのみ通知 */
                    if(args[1].equals("secret")){
                        //sender.sendMessage(result);
                        plugin.getLogger().info(result);
                        for(String name : plugin.getPl().keySet()){
                            PL p = plugin.getPl().get(name);
                            if(p.getPlayer().getScoreboardTags().contains("KP") && !sender.getName().equals(p.getPlayer().getName())){
                                p.getPlayer().sendMessage("KPに通知");
                                p.getPlayer().spigot().sendMessage(component);
                            }
                        }
                        continue;
                    }
                }

                if(component.getText().equals(""))
                    component.setText(result);
                    
                plugin.getServer().spigot().broadcast(component);
            }
        } catch (Exception e) {
            plugin.getLogger().info(e.toString()+"\nコマンドのオプションが間違っています");
            return false;
        }
        return true;
        
    }

    private boolean serverRoll(String[] args){
        /*引数に整数以外が与えられた場合の例外処理*/
        try {
            String[] diceRoll = args[0].split("D");
            int parseInt = Integer.parseInt(diceRoll[1]);
            
            int random = -1;

            SecureRandom seed = SecureRandom.getInstance("SHA1PRNG");

            TextComponent component = new TextComponent();

            for(int i = 0;i < Integer.parseInt(diceRoll[0]);i++){
                if(parseInt == 100)
                    random = (int)(Math.random()*99) + 1;
                else
                    random = seed.nextInt(parseInt) + 1;
                
                String result = String.valueOf(random);
                
                component.setText(result);

                if(args.length >= 2){

                    /*オプションでsecretが指定されれば自分とKPにのみ通知 */
                    if(args[1].equals("secret")){
                        //sender.sendMessage(result);
                        plugin.getLogger().info(result);
                        for(String name : plugin.getPl().keySet()){
                            PL p = plugin.getPl().get(name);
                            if(p.getPlayer().getScoreboardTags().contains("KP")){
                                p.getPlayer().sendMessage("KPに通知");
                                p.getPlayer().spigot().sendMessage(component);
                            }
                        }
                        continue;
                    }
                    return true;
                }
                
                if(component.getText().equals(""))
                    component.setText(result);
                plugin.getServer().spigot().broadcast(component);
            }
        } catch(Exception e){
            plugin.getLogger().info(e.toString()+"\nコマンドのオプションが間違っています");
            return false;
        }
        return true;
    }

}