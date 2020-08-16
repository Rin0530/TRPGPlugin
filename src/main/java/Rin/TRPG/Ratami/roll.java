package Rin.TRPG.Ratami;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

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
        
        TextComponent component = new TextComponent();

        /*引数に整数以外が与えられた場合の例外処理*/
        try {
            String[] diceRoll = args[0].split("D");
            int parseInt = Integer.parseInt(diceRoll[1]);
            int random = -1;
            //技能値を取得
            HashMap<String,Integer> senderStatus = plugin.getPl().get(sender.getName()).getOtherStatus();

            for(int i = 0;i < Integer.parseInt(diceRoll[0]);i++){
                random = new Random().nextInt(parseInt) + 1;
                
                String skill = "";
                String senderName = plugin.getPl().get(sender.getName()).getName();
                String result = senderName + " " + String.valueOf(random);
                
                if(args.length >= 2){

                    if(!args[1].equals("secret"))
                        skill = args[1];
                    else
                        if(!(args.length == 2))
                            skill = args[2];
                    
                    
                    //コマンドの第3引数に技能のどれか含まれていれば
                    if(senderStatus.containsKey(skill) || plugin.getPl().get(sender.getName()).getsubStatus().containsKey(skill) || skill.indexOf("SAN") >= 0) {
                        
                        //依存能力値を取得
                        if(plugin.getPl().get(sender.getName()).getsubStatus().containsKey(skill)){
                            senderStatus = plugin.getPl().get(sender.getName()).getsubStatus();
                        }
                        result = senderName +" "+ skill+"("+senderStatus.get(skill)+")";
                        if(senderStatus.get(skill) < random){
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
                        sender.spigot().sendMessage(component);
                        //sender.sendMessage(result);
                        plugin.getLogger().info(result);
                        for(String name : plugin.getPl().keySet()){
                            PL p = plugin.getPl().get(name);
                            if(p.getIsKP() && !sender.getName().equals(p.getPlayer().getName())){
                                p.getPlayer().sendMessage("KPに通知");
                                p.getPlayer().spigot().sendMessage(component);
                            }
                        }
                        continue;
                    }
                }

                if(component.getText().equals(""))
                    component.setText(result);

                for(Player player: plugin.getServer().getOnlinePlayers()){
                    player.spigot().sendMessage(component);
                    //player.sendMessage(result);
                }
            }
        } catch (Exception e) {
            plugin.getLogger().info(e.toString()+"\nコマンドのオプションが間違っています");
            return false;
        }
        return true;
        
    }

}