package Rin.TRPG.Ratami;

import org.bukkit.command.*;

public class StatusBook implements CommandExecutor{
    private Plugin plugin;

    public StatusBook(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command, String label,
    String[] args){
        String cmd = "";
        if(args[0].equals("main"))
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),"give "+sender.getName()+" minecraft:written_book{display:{Name:'{\"text\":\"数値設定本\"}'},title:\"\",author:\"\",pages:['[{\"text\":\""+args[1]+"の値をクリック\n\"},{\"text\":\"1\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(1)+" 1\"}},{\"text\":\"2\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(2)+" 2\"}},{\"text\":\"3\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(3)+" 3\"}},{\"text\":\"4\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(4)+" 4\"}},{\"text\":\"5\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(5)+" 5\"}},{\"text\":\"6\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(5)+" 6\"}},{\"text\":\"7\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(7)+" 7\"}},{\"text\":\"8\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(8)+" 8\"}},{\"text\":\"9\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(9)+" 9\"}},{\"text\":\"10\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(10)+" 10\"}},{\"text\":\"11\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(11)+" 11\"}},{\"text\":\"12\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(12)+" 12\"}},{\"text\":\"13\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(13)+" 13\"}}]','[{\"text\":\"14\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(14)+" 14\"}},{\"text\":\"15\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(15)+" 15\"}},{\"text\":\"16\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(16)+" 16\"}},{\"text\":\"17\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(17)+" 17\"}},{\"text\":\"18\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(18)+" 18\"}},{\"text\":\"19\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(19)+" 19\"}},{\"text\":\"20\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(20)+" 20\"}},{\"text\":\"21\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset "+args[0]+" "+args[1]+" "+String.valueOf(21)+" 21\"}}]']} 1");
        else{
            cmd ="give "+sender.getName()+" written_book{display:{Name:'{\"text\":\"数値設定本\",\"bold\":true}'},title:\"数値設定本\",author:\"\",pages:['[{\"text\":\""+args[1]+"\n\n\"},{\"text\":\"増加分の値\n\n\",\"color\":\"red\",\"bold\":true,\"italic\":true,\"underlined\":true},{\"text\":\"をクリックしてください\n\n\"},{\"text\":\"値は次のページから\"}]','[";
            for(int i = 1;i <= 100;i++){
            cmd += "{\"text\":\""+String.valueOf(i)+"\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\""+String.valueOf(i)+"\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+"  "+String.valueOf(i)+"\"}}";
                if(i % 14 != 0){
                    cmd += ",";
                }else {
                    cmd += "]','[";
                }
            }
            cmd += "{\"text\":\"振り直し\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"振り直し\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+"  "+String.valueOf(0)+"\"}}";
            cmd += "]']}";
        }
        plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), cmd);

            /*plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(),"give "+sender.getName()+" minecraft:written_book{display:{Name:'{\"text\":\"数値設定本\"}'},title:\"数値設定本\",author:\"\",pages:['[{\"text\":\""+args[1]+"の\"},{\"text\":\"増加分の値だけ\n\",\"color\":\"red\",\"bold\":true,\"italic\":true,\"underlined\":true},{\"text\":\"クリックする\n\",\"color\":\"black\"},{\"text\":\"1\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"1\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" "+String.valueOf(1)+"\"}},{\"text\":\"2\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"2\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" "+String.valueOf(2)+"\"}},{\"text\":\"3\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"3\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" "+String.valueOf(3)+"\"}},{\"text\":\"4\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"4\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" "+String.valueOf(4)+"\"}},{\"text\":\"5\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"5\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" "+String.valueOf(5)+"\"}},{\"text\":\"6\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"6\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" "+String.valueOf(6)+"\"}},{\"text\":\"7\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"7\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" "+String.valueOf(7)+"\"}},{\"text\":\"8\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"8\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" "+String.valueOf(8)+"\"}},{\"text\":\"9\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"9\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 9\"}},{\"text\":\"10\n\",\"color\":\"blue\",\"bold\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 10\"}},{\"text\":\"11\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"11\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 11\"}},{\"text\":\"12\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"12\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 12\"}},{\"text\":\"13\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"13\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 13\"}},{\"text\":\"14\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"14\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 14\"}}]','[{\"text\":\"15\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"15\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 15\"}},{\"text\":\"16\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"16\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 16\"}},{\"text\":\"17\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"17\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 17\"}},{\"text\":\"18\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"18\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 18\"}},{\"text\":\"19\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"19\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 19\"}},{\"text\":\"20\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"20\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 20\"}},{\"text\":\"21\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"21\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 21\"}},{\"text\":\"22\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"22\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 22\"}},{\"text\":\"23\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"23\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 23\"}},{\"text\":\"24\n\",\"color\":\"blue\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"24\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 24\"}},{\"text\":\"25\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"25\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 25\"}},{\"text\":\"26\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"26\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 26\"}},{\"text\":\"27\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"27\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 27\"}},{\"text\":\"28\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"28\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 28\"}},{\"text\":\"29\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"29\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 29\"}},{\"text\":\"30\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"30\"}]},"+
            "\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 30\"}}]','[{\"text\":\"31\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"31\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 31\"}},{\"text\":\"32\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"32\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 32\"}},{\"text\":\"33\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"33\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 33\"}},{\"text\":\"34\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"34\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 34\"}},{\"text\":\"35\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"35\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 35\"}},{\"text\":\"36\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"36\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 36\"}},{\"text\":\"37\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"37\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 37\"}},{\"text\":\"38\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"38\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 38\"}},{\"text\":\"39\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"39\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 39\"}},{\"text\":\"40\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"40\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 40\"}},{\"text\":\"41\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"41\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 41\"}},{\"text\":\"42\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"42\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 42\"}},{\"text\":\"43\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"43\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 43\"}},{\"text\":\"44\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"44\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 44\"}},{\"text\":\"45\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"45\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 45\"}},{\"text\":\"46\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"46\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 46\"}}]','[{\"text\":\"47\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"47\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 47\"}},{\"text\":\"48\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"48\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 48\"}},{\"text\":\"49\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"49\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 49\"}},{\"text\":\"50\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"50\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 50\"}},{\"text\":\"51\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"51\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 51\"}},{\"text\":\"52\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"52\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 52\"}},{\"text\":\"53\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"53\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 53\"}},{\"text\":\"54\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"54\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 54\"}},{\"text\":\"55\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"55\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 55\"}},{\"text\":\"56\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"56\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 56\"}},{\"text\":\"57\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"57\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 57\"}},{\"text\":\"58\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"58\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 58\"}},{\"text\":\"59\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"59\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 59\"}},{\"text\":\"60\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"60\"}]},"+
            "\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 60\"}},{\"text\":\"61\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"61\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 61\"}},{\"text\":\"62\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"62\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 62\"}}]','[{\"text\":\"63\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"63\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 63\"}},{\"text\":\"64\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"64\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 64\"}},{\"text\":\"65\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"65\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 65\"}},{\"text\":\"66\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"66\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 66\"}},{\"text\":\"67\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"67\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 67\"}},{\"text\":\"68\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"68\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 68\"}},{\"text\":\"69\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"69\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 69\"}},{\"text\":\"70\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"70\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 70\"}},{\"text\":\"71\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"71\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 71\"}},{\"text\":\"72\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"72\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 72\"}},{\"text\":\"73\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"73\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 73\"}},{\"text\":\"74\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"74\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 74\"}},{\"text\":\"75\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"75\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 75\"}},{\"text\":\"76\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"76\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 76\"}},{\"text\":\"77\n\",\"color\":\"blue\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"77\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 77\"}},{\"text\":\"78\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"78\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 78\"}}]','[{\"text\":\"79\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"79\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 79\"}},{\"text\":\"80\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"80\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 80\"}},{\"text\":\"81\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"81\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 81\"}},{\"text\":\"82\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"82\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 82\"}},{\"text\":\"83\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"83\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 83\"}},{\"text\":\"84\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"84\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 84\"}},{\"text\":\"85\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"85\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 85\"}},{\"text\":\"86\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"86\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 86\"}},{\"text\":\"87\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"87\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 87\"}},{\"text\":\"88\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"88\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 88\"}},{\"text\":\"89\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"89\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 89\"}},{\"text\":\"90\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"90\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 90\"}},{\"text\":\"91\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"91\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 91\"}},{\"text\":\"92\n\",\"color\":\"blue\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"92\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 92\"}},{\"text\":\"93\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"93\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 93\"}},{\"text\":\"94\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"94\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 94\"}}]','[{\"text\":\"95\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"95\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 95\"}},{\"text\":\"96\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"96\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 96\"}},{\"text\":\"97\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"97\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 97\"}},{\"text\":\"98\n\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"98\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 98\"}},{\"text\":\"99\",\"color\":\"blue\",\"bold\":true,\"hoverEvent\":{\"action\":\"show_text\",\"value\":[{\"text\":\"99\"}]},\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/statusset other "+args[1]+" 99\"}}]']} 1");*/
        return true;
    }
    
}