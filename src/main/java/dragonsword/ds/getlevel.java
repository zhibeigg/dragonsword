package dragonsword.ds;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class getlevel implements Listener {
    Plugin plugin = dragonsword.getPlugin(dragonsword.class);
    @EventHandler
    public void ondeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        float c = this.plugin.getConfig().getInt("LeveL");
        float a = player.getTotalExperience();
        String b = player.getWorld().getName();
        String name = player.getDisplayName();
        say("§c玩家"+name+"死在了"+b);
        for (int i = 0; i < this.plugin.getConfig().getStringList("world").size(); i++) {
            if (Objects.equals(b, this.plugin.getConfig().getStringList("world").get(i))) {
                player.sendMessage(this.plugin.getConfig().getString("message"));
            }
        }
    }
    public void onlevelup(PlayerChangedWorldEvent w){
        Player player = w.getPlayer();
        if (plugin.getConfig().getw.getPlayer().getWorld().getName());
    }
    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
