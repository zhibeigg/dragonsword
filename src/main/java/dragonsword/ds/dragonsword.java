package dragonsword.ds;

import io.github.battlepass.BattlePlugin;
import io.github.battlepass.registry.quest.QuestRegistry;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class dragonsword extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        say("§c插件开启 作者zhi_bei QQ:785740487");
        say("§6//////////////////////////");
        getServer().getPluginManager().registerEvents(new getsword(),this);
        say("§a成长型武器系列加载成功");
        say("§6//////////////////////////");
        getServer().getPluginManager().registerEvents(new getlevel(),this);
        say("§a世界掉级加载成功");
        say("§6//////////////////////////");
        getServer().getPluginManager().registerEvents(new getfly(),this);
        say("§a关闭国家飞行加载成功");
        say("§6//////////////////////////");
        QuestRegistry questRegistry = BattlePlugin.getApi().getQuestRegistry();
        questRegistry.hook("MythicMobs", MMQuests::new);
        say("§a注入mm战令任务成功");
        say("§6//////////////////////////");
        say("§b      ┏┛ ┻━━━━━━┛ ┻┓ §c作");
        say("§b      ┃　　　　　　┃ §c者");
        say("§b      ┃　　　━━　 ┃ §c纸");
        say("§b      ┃　┳┛　  ┗┳　┃ §c杯");
        say("§b      ┃　　　　　　┃");
        say("§b      ┃　　　┻　　┃");
        say("§b      ┃　　　　　　┃");
        say("§b      ┗━┓　　　┏━━━┛");
        say("§b        ┃　　　┃   §c神兽保佑");
        say("§b        ┃　　　┃   §c代码无BUG！");
        say("§b        ┃　　　┗━━━━━━━━━┓");
        say("§b        ┃　　　　　　　  ┣┓");
        say("§b        ┃　　　　       ┏┛");
        say("§b        ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛");
        say("§b          ┃ ┫ ┫   ┃ ┫ ┫");
        say("§b          ┗━┻━┛   ┗━┻━┛");
        say("§6//////////////////////////");
    }
    @Override
    public void onDisable() {
        say("§6//////////////////////////");
        say("§b插件卸载成功 作者zhi_bei");
        say("§6//////////////////////////");
    }
    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args[0]==null){
            Player p = (Player)sender;
            p.sendMessage("§c作者纸杯");
            return true;
        }
        else if (label.equalsIgnoreCase("dragonsword") && Objects.equals(args[0], "reload"))
        {
            Player p = (Player)sender;
            if (p != null) {
                if (p.hasPermission("dragonsword.reload")) {
                    this.reloadConfig();
                    say("§a重载成功");
                } else {
                    p.sendMessage("§4滚");
                }
            } else {
                this.reloadConfig();
                say("§a重载成功");
            }
            return true;
        }else{
            return false;
        }
    }
}
