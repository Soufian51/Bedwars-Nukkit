// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerDropItemEvent;
import cn.nukkit.event.Listener;

public class PlayerDropItem implements Listener
{
    @EventHandler
    public void onDrop(final PlayerDropItemEvent event) {
        final Player player = event.getPlayer();
        if (Utils.STATUS_LOBBY && !player.isOp()) {
            event.setCancelled(true);
        }
    }
}
