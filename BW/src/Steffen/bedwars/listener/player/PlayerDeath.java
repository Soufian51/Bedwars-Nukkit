// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import java.util.Iterator;

import Steffen.bedwars.Bedwars;
import Steffen.bedwars.utils.BWPlayer;
import Steffen.bedwars.utils.BWTeam;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.entity.Entity;
import cn.nukkit.Server;
import cn.nukkit.Player;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.Listener;

public class PlayerDeath implements Listener
{
    @EventHandler
    public void onDeath(final PlayerDeathEvent event) {
        final Player player = event.getEntity();
        final EntityDamageEvent.DamageCause cause = player.getLastDamageCause().getCause();
        if (cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            final Entity killer = player.getKiller();
            if (killer instanceof Player) {
                Server.getInstance().broadcastMessage(Bedwars.prefix + "§b" + player.getName() + " §7was killed by §b" + killer.getName() + "§7.");
            }
        }
        else {
            Server.getInstance().broadcastMessage(Bedwars.prefix + "§b" + player.getName() + " §7died.");
        }
        event.setDeathMessage("");
        if (Utils.bed_destroyed.get(new BWPlayer(player).getTeam())) {
            final String team = new BWPlayer(player).getTeam();
            Bedwars.removeFromTeam(player);
            if (new BWTeam(team).getSize() == 0) {
                for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                    player2.sendMessage(Bedwars.prefix + "Team " + team + " §7has been destroyed.");
                }
            }
        }
    }
}
