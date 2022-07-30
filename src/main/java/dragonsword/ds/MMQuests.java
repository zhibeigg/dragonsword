package dragonsword.ds;

import io.github.battlepass.BattlePlugin;
import io.github.battlepass.quests.quests.external.executor.ExternalQuestExecutor;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class MMQuests extends ExternalQuestExecutor {

    public MMQuests(BattlePlugin plugin) {
        super(plugin, "mm");
    }

    @EventHandler(ignoreCancelled = true)
    public void onMobDeath(MythicMobDeathEvent event) {
        if (!(event.getKiller() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getKiller();
        String mobTypeName = event.getMobType().getInternalName();
        this.execute("mob", player, result -> {
            return result.root(mobTypeName);
        });
    }
}