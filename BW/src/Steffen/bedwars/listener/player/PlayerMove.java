// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import Steffen.bedwars.utils.Utils;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.event.Listener;

public class PlayerMove implements Listener
{
    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        if (Utils.STATUS_END) {
            event.setCancelled(true);
        }
    }
}
