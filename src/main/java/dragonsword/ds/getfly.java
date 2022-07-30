package dragonsword.ds;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.Plugin;

public class getfly implements Listener {
    Plugin plugin = dragonsword.getPlugin(dragonsword.class);
    @EventHandler
    public void onWorld(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        if (player.getAllowFlight()){
         player.setFlying(false);
         String name = player.getDisplayName();
         say("§c玩家"+name+"§c飞行已经取消");
        }
    }
    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
