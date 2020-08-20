package Rin.TRPG.Ratami;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;


public class PL{
    private String name;
    private String giveBook;
    private int MP;
    //private Plugin plugin;
    private Player player;
    private HashMap<String,Integer> mainStatus;
    private HashMap<String,Integer> subStatus;
    private HashMap<String,Integer> otherStatus;
    private HashMap<String,Integer> otherDef;
    private ArrayList<String> other;
    private ScoreboardManager manager;
    private Scoreboard scoreboard1;
    private boolean isKP;

    private String[] mains = {
        "STR", "CON", "POW", "DEX", "APP", "SIZ", "INT", "EDU"
        };

    private String[] sub = {
        "幸運", "アイデア", "器用", "知識"
        };

    public PL(Player player,Plugin plugin){
       //this.plugin = plugin;
        this.player = player;
        
        isKP = false;
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
        otherStatus = new HashMap<String,Integer>(){{
            put("回避",0);
            put("キック",25);
            put("組み付き",25);
            put("こぶし（パンチ）",50);
            put("頭突き",10);
            put("投擲",25);
            put("マーシャルアーツ",1);
            put("拳銃",20);
            put("サブマシンガン",15);
            put("ショットガン",30);
            put("マシンガン",15);
            put("ライフル",25);
            put("応急手当",30);
            put("鍵開け",1);
            put("隠す",15);
            put("隠れる",10);
            put("聞き耳",25);
            put("忍び歩き",10);
            put("写真術",10);
            put("精神分析",1);
            put("追跡",10);
            put("登攀",40);
            put("図書館",25);
            put("目星",25);
            put("運転",20);
            put("機械修理",20);
            put("重機械操作",1);
            put("乗馬",5);
            put("水泳",25);
            put("製作",5);
            put("操縦",1);
            put("跳躍",25);
            put("電気修理",10);
            put("ナビゲート",10);
            put("変装",1);
            put("言いくるめ",5);
            put("信用",15);
            put("説得",15);
            put("値切り",5);
            put("母国語",0);
            put("医学",5);
            put("オカルト",5);
            put("化学",1);
            put("クトゥルフ神話",0);
            put("芸術",5);
            put("経理",10);
            put("考古学",1);
            put("コンピューター",1);
            put("心理学",5);
            put("人類学",1);
            put("生物学",1);
            put("地質学",1);
            put("電子工学",1);
            put("天文学",1);
            put("博物学",10);
            put("物理学",1);
            put("法律",5);
            put("薬学",1);
            put("歴史",20);
        }};
        subStatus = new HashMap<>();

        //スコアボード設定
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),"team add PL");
        manager = plugin.getServer().getScoreboardManager();
        scoreboard1 = manager.getNewScoreboard();
        /*
        team1 = scoreboard1.getTeam("PL");
        if(team1 == null){
            team1 = scoreboard1.registerNewTeam("PL");
            team1.setDisplayName("PL");
            team1.setOption(Option.NAME_TAG_VISIBILITY, OptionStatus.NEVER);
            team1.setCanSeeFriendlyInvisibles(false);
            team1 = scoreboard1.getTeam("PL");
        }
        team1 = scoreboard1.getTeam("PL");
        */
        player.setScoreboard(scoreboard1);
        otherDef = new HashMap<>(otherStatus);
    }



    /**
     * HPのセッター
     * @param HP
     */
    public void setHP(double HP,boolean init){
        //HP1につき最大ハート1つになる
        if(init)
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(Math.round(HP));
        player.setHealth(Math.round(HP));
    }
    /**
     * MPのセッター
     * @param MP
     */
    public void setMP(int MP){
        this.MP = MP;
    }

    /**
     * SAN値のセッター
     * @param SAN
     */
    public void setSAN(int SAN){
        subStatus.put("SAN",SAN);
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
        return MP;
    }

    /**
     * SAN値のゲッター
     * @return
     */
    public int getSAN(){
        return player.getLevel();
    }

    /**
     * KPかどうかのセッター
     * @param isKP
     */
    public void setIsKP(boolean isKP){
        this.isKP = isKP;
    }

    /**
     * KPかどうかのゲッター
     * @return
     */
    public boolean getIsKP(){
        return isKP;
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
        mainStatus.put(statusName, num);
        /*if(statusName.equals("HP"))
            setHP(num);
        else */
        if(statusName.equals("POW")){
            setSAN(num * 5);
            setMP(num);
            subStatus.put("幸運", num * 5);
        }
        else if(statusName.equals("INT")){
            subStatus.put("アイデア", num * 5);
        }
        else if(statusName.equals("EDU")){
            subStatus.put("知識", num * 5);
            otherStatus.put("母国語", num * 5);
            otherDef.put("母国語", num * 5);
        }
        else if(statusName.equals("DEX")){
            otherStatus.put("回避", num * 2);
            otherDef.put("回避", num * 2);
            subStatus.put("器用", num * 5);
        }
        else if(statusName.equals("CON") || statusName.equals("SIZ")){
            if(mainStatus.containsKey("CON") && mainStatus.containsKey("SIZ")){
                double HP = (double)(mainStatus.get("CON")+mainStatus.get("SIZ")) /2.0;
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
        if(num == 0){
            otherStatus.put(statusName,otherDef.get(statusName));
            getPlayer().sendMessage("リセット");
        }else{
            if(!otherStatus.containsKey(statusName))
                other.add(statusName);
            otherStatus.put(statusName,num);
        }
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
     * 依存能力値が格納されたハッシュマップを返す
     * @return
     */
    public HashMap<String,Integer> getsubStatus(){
        return subStatus;
    }


    /**
     * 技能値が格納されたハッシュマップを返す
     * @return
     */
    public HashMap<String,Integer> getOtherStatus(){
        return otherStatus;
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

    public void giveBook(CommandSender sender){

        //能力値書き込み
        giveBook = " minecraft:written_book{display:{Name:'{\"text\":\"ステータス一覧\"}'},title:\"\",author:\"\",pages:['[{\"text\":\"ステータスの一覧です\n1D100でダイスを振り\n成否を表示します\n\"}";
        for(String str : getMain())
            giveBook += ",{\"text\":\""+str+": "+String.valueOf(getMainStatus().get(str))+"\n\"}";
        giveBook += "]','[";
        giveBook += "{\"text\":\"SAN: "+String.valueOf(getsubStatus().get("SAN"))+"\n\n\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/roll 1D100 SAN\"}},";
        for(String str : sub){
            giveBook += "{\"text\":\""+str+": "+String.valueOf(getsubStatus().get(str))+"\n\n\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/roll 1D100 "+str+"\"}}";
            if(!(str.equals("知識"))){
                giveBook += ",";
            }
        }
        giveBook += "]','[";
        //技能値書き込み
        int line = 0;
        for(int i = 0;i < other.size(); i++){
            line++;
            giveBook += "{\"text\":\""+other.get(i)+": "+String.valueOf(getOtherStatus().get(other.get(i)))+"\n\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/roll 1D100 "+other.get(i)+"\"}}";
            if(other.get(i).equals("ライフル") || other.get(i).equals("目星") || other.get(i).equals("変装") || other.get(i).equals("母国語") || other.get(i).equals("コンピューター") || line == 12){
                giveBook += "]','[";
                line = 0;
                continue;
            }else if(!(i+1 == other.size()))
                giveBook += ",";
        }
        giveBook += "]']}";
    }
}