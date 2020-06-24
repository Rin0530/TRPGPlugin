package Rin.TRPG.Ratami;

import org.bukkit.command.*;

public class KP implements CommandExecutor{
    private Plugin plugin;

    public KP(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        plugin.getServer().dispatchCommand(sender, "give @p minecraft:written_book{display:{Name:'{\"text\":\"ステータス設定本\",\"color\":\"red\",\"bold\":true,\"italic\":true,\"underlined\":true}'},title:\"\",author:\"\",pages:['[{\"text\":\"ステータス設定\n\n\",\"bold\":true,\"italic\":true},{\"text\":\"設定したい能力値や技能ポイントをクリックしてください。\n\",\"bold\":false,\"italic\":false},{\"text\":\"クリックするとそれに対応した新しい本が手に入ります。\n\",\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false},{\"text\":\"\n\n能力値一覧、および\n技能一覧は次のページから\",\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false}]','[{\"text\":\"\nSTR\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book STR\"}},{\"text\":\"\n\nCON\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book CON\"}},{\"text\":\"\n\nPOW\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book POW\"}},{\"text\":\"\n\nDEX\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book DEX\"}},{\"text\":\"\n\nAPP\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book APP\"}},{\"text\":\"\n\nSIZ\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book SIZ\"}},{\"text\":\"\n\nINT\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book INT\"}},{\"text\":\"\n\nEDU\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/book EDU\"}}]']} 1");
        return true;
    }
}