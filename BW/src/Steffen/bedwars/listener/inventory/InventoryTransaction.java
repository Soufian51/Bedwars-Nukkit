// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.inventory;

import cn.nukkit.event.EventHandler;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.Player;
import cn.nukkit.event.inventory.InventoryTransactionEvent;
import cn.nukkit.event.Listener;

public class InventoryTransaction implements Listener
{
    @EventHandler
    public void onInvMove(final InventoryTransactionEvent event) {
        final Player player = event.getTransaction().getSource().getPlayer();
        if (Utils.STATUS_LOBBY && !player.isOp()) {
            event.setCancelled(true);
        }
    }
}
