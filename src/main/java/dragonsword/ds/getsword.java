package dragonsword.ds;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class getsword implements Listener {
        Plugin plugin = dragonsword.getPlugin(dragonsword.class);
        @EventHandler
        public void weapon(EntityDamageByEntityEvent attack) {
            if (attack.getDamager().getType() == EntityType.PLAYER) {
                String player = attack.getDamager().getName();
                PlayerInventory inv = Bukkit.getPlayer(player).getInventory();
                int level = Bukkit.getPlayer(player).getLevel();
                if (inv.getItemInMainHand().getType() != Material.AIR){
                    String yl = inv.getItemInMainHand().getItemMeta().getDisplayName();
                    if (Objects.equals(yl, plugin.getConfig().getString("成长型武器名"))) {
                        double damage = attack.getFinalDamage();
                        attack.setDamage(level + damage);
                        say("§6纸杯龙剑：§a" + player + "§b使用成长型武器对§c" + attack.getEntity().getName() + "§b造成了§4" + attack.getFinalDamage() + "§4伤害");
                    }
                }
            }
        }
    public void say(String s) {
        CommandSender sender = Bukkit.getConsoleSender();
        sender.sendMessage(s);
    }
}
