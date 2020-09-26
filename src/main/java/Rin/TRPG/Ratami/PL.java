package Rin.TRPG.Ratami;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

@SuppressWarnings("serial") 
public class PL{
    private String name;
    private String giveBook;
    private Plugin plugin;
    private Player player;
    private HashMap<String,Integer> mainStatus;
    private ArrayList<String> other;
    private ScoreboardManager manager;
    private Scoreboard scoreboard;
    private Objective objective;

    private String[] mains = {
        "STR", "CON", "POW", "DEX", "APP", "SIZ", "INT", "EDU"
        };

    private String[] sub = {
        "幸運", "アイデア", "器用", "知識"
        };

    public PL(Player player,Plugin plugin){
        this.plugin = plugin;
        this.player = player;
        name = player.getName();

        String name = player.getPlayerListName();
        //スコアボード設定
        manager = plugin.getServer().getScoreboardManager();
        scoreboard = manager.getMainScoreboard();
        objective = scoreboard.getObjective(name);
        if(objective == null){
            player.sendMessage("スコアボードを生成");
            objective = scoreboard.registerNewObjective(name, "dummy", name);
            objective =scoreboard.getObjective(name);
            
            objective.getScore("回避").setScore(0);
            objective.getScore("キック").setScore(25);
            objective.getScore("組み付き").setScore(25);
            objective.getScore("こぶし（パンチ）").setScore(50);
            objective.getScore("頭突き").setScore(10);
            objective.getScore("投擲").setScore(25);
            objective.getScore("マーシャルアーツ").setScore(1);
            objective.getScore("拳銃").setScore(20);
            objective.getScore("サブマシンガン").setScore(15);
            objective.getScore("ショットガン").setScore(30);
            objective.getScore("マシンガン").setScore(15);
            objective.getScore("ライフル").setScore(25);
            objective.getScore("応急手当").setScore(30);
            objective.getScore("鍵開け").setScore(1);
            objective.getScore("隠す").setScore(15);
            objective.getScore("隠れる").setScore(10);
            objective.getScore("聞き耳").setScore(25);
            objective.getScore("忍び歩き").setScore(10);
            objective.getScore("写真術").setScore(10);
            objective.getScore("精神分析").setScore(1);
            objective.getScore("追跡").setScore(10);
            objective.getScore("登攀").setScore(40);
            objective.getScore("図書館").setScore(25);
            objective.getScore("目星").setScore(25);
            objective.getScore("運転").setScore(20);
            objective.getScore("機械修理").setScore(20);
            objective.getScore("重機械操作").setScore(1);
            objective.getScore("乗馬").setScore(5);
            objective.getScore("水泳").setScore(25);
            objective.getScore("製作").setScore(5);
            objective.getScore("操縦").setScore(1);
            objective.getScore("跳躍").setScore(25);
            objective.getScore("電気修理").setScore(10);
            objective.getScore("ナビゲート").setScore(10);
            objective.getScore("変装").setScore(1);
            objective.getScore("言いくるめ").setScore(5);
            objective.getScore("信用").setScore(15);
            objective.getScore("説得").setScore(15);
            objective.getScore("値切り").setScore(5);
            objective.getScore("母国語").setScore(0);
            objective.getScore("医学").setScore(5);
            objective.getScore("オカルト").setScore(5);
            objective.getScore("化学").setScore(1);
            objective.getScore("クトゥルフ神話").setScore(0);
            objective.getScore("芸術").setScore(5);
            objective.getScore("経理").setScore(10);
            objective.getScore("考古学").setScore(1);
            objective.getScore("コンピューター").setScore(1);
            objective.getScore("心理学").setScore(5);
            objective.getScore("人類学").setScore(1);
            objective.getScore("生物学").setScore(1);
            objective.getScore("地質学").setScore(1);
            objective.getScore("電子工学").setScore(1);
            objective.getScore("天文学").setScore(1);
            objective.getScore("博物学").setScore(10);
            objective.getScore("物理学").setScore(1);
            objective.getScore("法律").setScore(5);
            objective.getScore("薬学").setScore(1);
            objective.getScore("歴史").setScore(20);

        }
        player.setScoreboard(scoreboard);
        
        
        mainStatus = new HashMap<String,Integer>(){{
            put("STR",-1);
            put("CON",-1);
            put("POW",-1);
            put("DEX",-1);
            put("APP",-1);
            put("SIZ",-1);
            put("INT",-1);
            put("EDU",-1);
        }};

        String[] skillList = {
            "回避", "キック", "組み付き", "こぶし（パンチ）", "頭突き", "投擲", "マーシャルアーツ", "拳銃", "サブマシンガン", "ショットガン", "マシンガン", "ライフル",
            "応急手当", "鍵開け", "隠す", "隠れる", "聞き耳", "忍び歩き", "写真術", "精神分析", "追跡", "登攀", "図書館", "目星",
            "運転", "機械修理", "重機械操作", "乗馬", "水泳", "製作", "操縦", "跳躍", "電気修理", "ナビゲート", "変装",
            "言いくるめ", "信用", "説得", "値切り", "母国語",
            "医学", "オカルト", "化学", "クトゥルフ神話", "芸術", "経理", "考古学", "コンピューター", "心理学", "人類学", "生物学", "地質学", "電子工学", "天文学", "博物学", "物理学", "法律", "薬学", "歴史"
        };

        other = new ArrayList<>(Arrays.asList(skillList));

    }



    /**
     * HPのセッター
     * @param HP
     * @param init 初期設定かどうか
     */
    public void setHP(double HP,boolean init){
        //HP1につき最大ハート1つになる
        if(init){
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(Math.floor(HP) * 2);
            player.setHealth(Math.floor(HP) * 2);
        }else
            player.setHealth(Math.round(HP));
    }
    /**
     * MPのセッター
     * @param MP
     */
    public void setMP(int MP){
        objective.getScore("MP").setScore(MP);
        //this.MP = MP;
    }

    /**
     * SAN値のセッター
     * @param SAN
     */
    public void setSAN(int SAN){
        objective.getScore("SAN").setScore(SAN);
        player.setLevel(SAN);
    }

    /**
     * HPのゲッター
     * @return
     */
    public double getHP(){
        return player.getHealth();
    }

    /**
     * MPのセッター
     * @return
     */
    public int getMP(){
        return objective.getScore("MP").getScore();
    }

    /**
     * SAN値のゲッター
     * @return
     */
    public int getSAN(){
        return player.getLevel();
    }


    /**
     * 名前のゲッター
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * 名前のセッター
     * @param name
     */
    public void setName(String name){
        getPlayer().setDisplayName(name);
        this.name = name;
    }

    /**
     * 能力値のセッター
     * @param statusName
     * @param num
     */
    public void setMainStatus(String statusName, int num){
        objective.getScore(statusName).setScore(num);
        objective.getScore(statusName+"*5").setScore(num*5);
        objective.getScore(statusName+"*4").setScore(num*4);
        objective.getScore(statusName+"*3").setScore(num*3);
        objective.getScore(statusName+"*2").setScore(num*2);
        objective.getScore(statusName+"*1").setScore(num*1);


        if(statusName.equals("POW")){
            setSAN(num * 5);
            setMP(num);

            objective.getScore("SAN").setScore(num * 5);
            objective.getScore("幸運").setScore(num * 5);
        }
        else if(statusName.equals("INT")){

            objective.getScore("アイデア").setScore(num * 5);
        }
        else if(statusName.equals("EDU")){


            objective.getScore("知識").setScore(num * 5);
            objective.getScore("母国語").setScore(num * 5);
        }
        else if(statusName.equals("DEX")){


            objective.getScore("回避").setScore(num * 2);
            objective.getScore("器用").setScore(num * 5);
        }
        else if(statusName.equals("CON") || statusName.equals("SIZ")){
            if(objective.getScoreboard().getEntries().contains("CON") && objective.getScoreboard().getEntries().contains("SIZ")){
                double HP = ( objective.getScore("CON").getScore()+objective.getScore("SIZ").getScore() ) /2.0;
                if(HP % 2 != 0)
                    HP += 0.5;
                player.sendMessage(String.valueOf(HP));
                setHP(HP,true);
            }
        }
    }

    /**
     * 技能値のセッター
     * @param statusName
     * @param num
     */
    public void addOtherStatus(String statusName, int num){
        if(!objective.getScoreboard().getEntries().contains(statusName))
            other.add(statusName);
        objective.getScore(statusName).setScore(num);
        
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
     * PL用本の配布用コマンド
     * @return
     */
    public String getGiveBook(){
        return giveBook;
    }


    /**
     * Playerオブジェクトのゲッター
     * @return
     */
    public Player getPlayer(){
        return player;
    }

    /**
     * ステータスのスコアボードを返す
     * @param sender
     */
    public Objective getObjective(){
        return objective;
    }

    public void giveBook(CommandSender sender){

        //能力値書き込み
        giveBook = " minecraft:written_book{display:{Name:'{\"text\":\"ステータス一覧\"}'},title:\"\",author:\"\",pages:['[{\"text\":\"ステータスの一覧です\n1D100でダイスを振り\n成否を表示します\n\"}";
        for(String str : getMain())
            giveBook += ",{\"text\":\""+str+": "+String.valueOf(objective.getScore(str).getScore())+"\n\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\""+str+"\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusroll "+str+"\"}}";
        giveBook += "]','[";
        giveBook += "{\"text\":\"SAN: "+String.valueOf(objective.getScore("SAN").getScore())+"\n\n\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/roll 1D100 SAN\"}},";
        
        for(String str : sub){
            giveBook += "{\"text\":\""+str+": "+String.valueOf(objective.getScore(str).getScore())+"\n\n\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/roll 1D100 "+str+"\"}}";
            if(!(str.equals("知識"))){
                giveBook += ",";
            }
        }

        giveBook += "]','[";
        //技能値書き込み
        int line = 0;
        for(int i = 0;i < other.size(); i++){
            line++;
            giveBook += "{\"text\":\""+other.get(i)+": "+String.valueOf(objective.getScore(other.get(i)).getScore())+"\n\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\""+other.get(i)+"\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/roll 1D100 "+other.get(i)+"\"}}";
            if(other.get(i).equals("ライフル") || other.get(i).equals("目星") || other.get(i).equals("変装") || other.get(i).equals("母国語") || other.get(i).equals("コンピューター") || line == 12){
                giveBook += "]','[";
                line = 0;
                continue;
            }else if(!(i+1 == other.size()))
                giveBook += ",";
        }
        giveBook += "]']}";
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),"give " + getPlayer().getName() + giveBook);
    }
}