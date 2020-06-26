package Rin.TRPG.Ratami;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scoreboard.*;

public class PL{
    private Plugin plugin;
    private Player player;
    private HashMap<String, Integer> mainStatus;
    private HashMap<String, Integer> otherStatus;
    private boolean isKP;
    private Inventory statusInventory;
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private Team team;
    
    private String[] mains = {
        "STR", "CON", "POW", "DEX", "APP", "SIZ", "INT", "EDU"
        };
    private String[] other = {
            "回避", "キック", "組み付き", "こぶし（パンチ）", "頭突き", "投擲", "マーシャルアーツ", "拳銃", "サブマシンガン", "ショットガン", "マシンガン", "ライフル",
            "応急手当", "鍵開け", "隠す", "隠れる", "聞き耳", "忍び歩き", "写真術", "精神分析", "追跡", "登攀", "図書館", "目星",
            "運転", "機械修理", "重機械操作", "乗馬", "水泳", "製作", "操縦", "跳躍", "電気修理", "ナビゲート", "変装",
            "言いくるめ", "信用", "説得", "値切り", "母国語", 
            "医学", "オカルト", "化学", "クトゥルフ神話", "芸術", "経理", "考古学", "コンピューター", "心理学", "人類学", "生物学", "地質学", "電子工学", "天文学", "博物学", "物理学", "法律", "薬学", "歴史"
        };
    private int[] otherNum = {
            28, 25, 25, 25, 50, 10, 25,1, 20, 15, 30, 15, 25,
            30, 1, 15, 10, 25, 10, 10, 1, 10, 40, 25, 25, 
            20, 20, 1, 5, 25, 5, 1, 25, 10, 10, 1, 
            5, 15, 15, 75, 
            5, 5, 1, 0, 5, 10, 1, 1, 5, 1, 1, 1, 1, 1, 10, 1, 5, 1, 20
        };



    public PL(Player player,Plugin plugin){
        this.plugin = plugin;
        this.player = player;
        mainStatus = new HashMap<>();
        
        otherStatus = new HashMap<>();
        isKP = false;

        //スコアボード設定
        manager = plugin.getServer().getScoreboardManager();
        scoreboard = manager.getNewScoreboard();
        team = scoreboard.getTeam("PL");
        if(team == null){
            team = scoreboard.registerNewTeam("PL");
            team.setDisplayName("PL");
        }
        player.setScoreboard(scoreboard);


        statusInventory = plugin.getServer().createInventory(null, 54, "ステータス設定画面");

        
        for(int i = 0;i < other.length;i++){
            otherStatus.put(other[i], otherNum[i]);
        }
    }


    /**
     * HPのゲッター
     * @param HP
     */
    public void setHP(double HP){
        player.setHealth(HP);
    }
    /**
     * MPのゲッター
     * @param MP
     */
    public void setMP(int MP){
        player.setFoodLevel(MP);
    }

    /**
     * SAN値のゲッター
     * @param SAN
     */
    public void setSAN(int SAN){
        player.setLevel(SAN);
    }

    /**
     * 能力値のセッター
     * @param statusName
     * @param num
     */
    public void setMainStatus(String statusName, int num){
        mainStatus.put(statusName, num);
    }

    /**
     * 技能値のセッター
     * @param statusName
     * @param num
     */
    public void addOtherStatus(String statusName, int num){
        otherStatus.put(statusName,otherStatus.get(statusName)+num);
    }

    /**
     * 能力一覧を返す
     * @return
     */
    public String[] getMain(){
        return mains;
    }

    /**
     * 能力値が格納されたハッシュマップを返す
     * @return
     */
    public HashMap<String,Integer> getMainStatus(){
        return mainStatus;
    }

    /**
     * 技能値が格納されたハッシュマップを返す
     * @return
     */
    public HashMap<String,Integer> getOtherStatus(){
        return otherStatus;
    }

    /**
     * 技能値一覧を返す
     * @return
     */
    public String[] getOther(){
        return other;
    }

    /**
     * Playerオブジェクトのゲッター
     * @return
     */
    public Player getPlayer(){
        return player;
    }

    /**
     * KPかどうかのゲッター(削除予定)
     * @return
     */
    public boolean getIsKP(){
        return isKP;
    }

    /**
     * インベントリのゲッター(削除するかも)
     * @return
     */
    public Inventory getInventory(){
        return statusInventory;
    }

}