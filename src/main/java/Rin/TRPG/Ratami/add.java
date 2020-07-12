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
        if(args.length != 3)
            return false;
        int change = Integer.parseInt(args[2]);
        PL pl = plugin.getPl().get(args[0]);
            try {
                switch(args[1]){
                    case "HP":
                        double hp = pl.getPlayer().getHealth();
                        change += hp;
                        if(change <= 0){
                            pl.setHP(0);
                            break;
                        }
                        sender.sendMessage(String.valueOf(hp));
                        pl.setHP(change);
                        break;
                    case "MP":
                        change += pl.getMP();
                        plugin.setIsMagic(true);
                        pl.setMP(change);
                        break;
                    case "SAN":
                    case "SAN値":
                        plugin.setIsMagic(false);
                        change += pl.getSAN();
                        if(change <= 0){
                            pl.setSAN(0);
                            break;
                        }
                        pl.setSAN(change);
                        break;
                    default:
                        return false;
                }
            }catch(Exception e) {
                return false;
            }
        plugin.getServer().dispatchCommand(sender, "reflectStatus");
        return true;
    }
}