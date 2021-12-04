// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import cn.nukkit.item.Item;
import cn.nukkit.Player;

import java.net.InetSocketAddress;

import Steffen.bedwars.Bedwars;
import Steffen.bedwars.map.MapVote;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.Listener;

public class PlayerInteract implements Listener
{
    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        final Item item = event.getItem();
        if (Utils.STATUS_LOBBY && item != null) {
            if (item.getCustomName().equals("§cLeave game")) {
                final String[] s = Utils.fallback_server.split(":");
                final InetSocketAddress ip = new InetSocketAddress(s[0], Integer.parseInt(s[1]));
                player.transfer(ip);
            }
            else if (item.getCustomName().equals("§eTeams")) {
                Bedwars.showTeamsUI(player);
            }
            else if (item.getCustomName().equals("§aMap Voting")) {
                MapVote.openMapVote(player);
            }
        }
    }
}
