package Rin.TRPG.Ratami;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.*;

public class change implements CommandExecutor{
    private Plugin plugin;

    public change(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        if(args.length != 3)
            return false;
        int change = Integer.parseInt(args[2]);
        PL pl = plugin.getPl().get(args[0]);
        int before = 0;
        int after = 0;
            try {
                switch(args[1]){
                    case "HP":
                        change *= 2;
                        before = (int)pl.getHP();
                        change += before;
                        if(change <= 0){
                            pl.setHP(0, false);
                            after = 0;
                            break;
                        }
                        if(change > pl.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()){
                            change = (int)pl.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
                        }
                        pl.setHP((double)change, false);
                        after = (int)pl.getHP();
                        before /= 2;
                        after /= 2;
                        break;
                    case "MP":
                        before = pl.getMP();
                        change += before;
                        if(change <= 0){
                            pl.setMP(0);
                            break;
                        }
                        pl.setMP(change);
                        after = pl.getMP();
                        break;
                    case "SAN":
                    case "SAN値":
                        before = pl.getSAN();
                        change += before;
                        if(change <= 0){
                            pl.setSAN(0);
                            after = 0;
                            break;
                        }
                        pl.setSAN(change);
                        after = pl.getSAN();
                        break;
                    default:
                        return false;
                }
            }catch(Exception e) {
                sender.sendMessage(e.toString());
                return false;
            }

        plugin.getServer().broadcastMessage(plugin.getPl().get(args[0]).getName()+ " " +args[1]+ ":" +before+ "→" +after);
        return true;
    }
}