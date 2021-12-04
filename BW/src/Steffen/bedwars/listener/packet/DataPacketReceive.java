// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.packet;

import cn.nukkit.event.EventHandler;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.SetLocalPlayerAsInitializedPacket;
import cn.nukkit.event.server.DataPacketReceiveEvent;
import cn.nukkit.event.Listener;

public class DataPacketReceive implements Listener
{
    @EventHandler
    public void onDataPacketReceived(final DataPacketReceiveEvent event) {
        if (event.getPacket() instanceof SetLocalPlayerAsInitializedPacket) {
            final Player player = event.getPlayer();
            if (Utils.STATUS_LOBBY) {
                player.setCheckMovement(false);
                player.getInventory().clearAll();
                player.getInventory().setItem(0, Item.get(54, Integer.valueOf(0), 1).setCustomName("§eTeams"));
                player.getInventory().setItem(4, Item.get(339, Integer.valueOf(0), 1).setCustomName("§aMap Voting"));
                player.getInventory().setItem(8, Item.get(341, Integer.valueOf(0), 1).setCustomName("§cLeave game"));
            }
        }
    }
}
