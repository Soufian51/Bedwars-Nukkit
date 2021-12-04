// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import cn.nukkit.inventory.PlayerInventory;
import Steffen.bedwars.utils.BWPlayer;
import Steffen.bedwars.utils.BWTeam;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.Server;
import cn.nukkit.event.player.PlayerRespawnEvent;
import cn.nukkit.event.Listener;

public class PlayerRespawn implements Listener
{
    @EventHandler
    public void onRespawn(final PlayerRespawnEvent event) {
        final Player player = event.getPlayer();
        final PlayerInventory inv = player.getInventory();
        if (new BWPlayer(player).getTeam() != null) {
            event.setRespawnPosition(new BWTeam(new BWPlayer(player).getTeam()).getSpawn());
        }
        else {
            event.setRespawnPosition(Server.getInstance().getDefaultLevel().getSafeSpawn());
            if (Utils.STATUS_INGAME) {
                inv.clearAll();
                inv.setItem(8, Item.get(341).setCustomName("§cLeave game"));
            }
        }
    }
}
