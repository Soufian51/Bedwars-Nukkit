// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import Steffen.bedwars.Bedwars;
import Steffen.bedwars.utils.BWPlayer;
import Steffen.bedwars.utils.BWTeam;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.event.Listener;

public class PlayerQuit implements Listener
{
    @EventHandler
    public void onQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        event.setQuitMessage("");
        String team = "";
        if (new BWPlayer(player).getTeam() != null) {
            team = new BWPlayer(player).getTeam();
        }
        Bedwars.removeFromTeam(player);
        if (Utils.STATUS_INGAME && Utils.bed_destroyed.get(team) && new BWTeam(team).getSize() == 0) {
            Server.getInstance().broadcastMessage(Bedwars.prefix + "Team " + team + " §7has been destroyed.");
        }
    }
}
