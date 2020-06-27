package Rin.TRPG.Ratami;

import org.bukkit.command.*;

public class add implements CommandExecutor{
    private Plugin plugin;

    public add(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        int now = Integer.parseInt(args[2]);
        //コマンド名がaddなら値を増加
            try {
                switch(args[1]){
                    case "HP":
                        now += plugin.getPl().get(args[0]).getHP();
                        sender.sendMessage(String.valueOf(now));
                        plugin.getPl().get(args[0]).setHP(now);
                        break;
                    case "MP":
                        now += plugin.getPl().get(args[0]).getMP();
                        plugin.getPl().get(args[0]).setMP(now);
                        break;
                    case "SAN":
                    case "SAN値":
                        now += plugin.getPl().get(args[0]).getSAN();
                        plugin.getPl().get(args[0]).setSAN(now);
                        break;
                    default:
                        return false;
                }
            }catch(Exception e) {
                sender.sendMessage(e.toString());
                return false;
            }
        plugin.getServer().dispatchCommand(sender, "reflectStatus");
        return true;
    }
}