package Rin.TRPG.Ratami;

import java.util.HashMap;
import org.bukkit.inventory.*;
import org.bukkit.entity.Player;

public class PL {
    private Player player;
    private HashMap<String, Integer> otherStatus;

    public PL(Player player,Plugin plugin){
        this.player = player;
        otherStatus = new HashMap<>();
    }

    public void setHP(double HP){
        player.setHealth(HP);
    }

    public void setMP(int MP){
        player.setFoodLevel(MP);
    }

    public void setSAN(int SAN){
        player.setLevel(SAN);
    }

    public void setOtherStatus(String statusName, int num){
        otherStatus.put(statusName,num);
    }

    public Player getPlayer(){
        return player;
    }
}