package Rin.TRPG.Ratami;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class PL {
    private int HP;
    private int MP;
    private int SAN;
    private HashMap otherStatus;

    public PL(Player player){

    }

    public void setHP(int HP){
        this.HP = HP;
    }

    public void setMP(int MP){
        this.MP = MP;
    }

    public void setSAN(int SAN){
        this.SAN = SAN;
    }
}