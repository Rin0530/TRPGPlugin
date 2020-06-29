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
        int change = Integer.parseInt(args[2]);
        PL pl = plugin.getPl().get(args[0]);
        //コマンド名がaddなら値を増加
            try {
                switch(args[1]){
                    case "HP":
                        double hp = pl.getPlayer().getHealth();
                        if(change >= 0)
                            change += hp;
                        else
                            change -= hp;
                        double afterSclale = pl.getPlayer().getHealthScale() / 20;
                        if(change > afterSclale * pl.getPlayer().getMaxHealth())
                            pl.setHP(afterSclale * 20);
                        else 
                        pl.setHP(afterSclale * change);
                        break;
                    case "MP":
                        change += pl.getMP();
                        pl.setMP(change);
                        break;
                    case "SAN":
                    case "SAN値":
                        if(change > pl.getSAN()){
                        pl.setSAN(0);

                        }
                        change += pl.getSAN();
                        pl.setSAN(change);
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