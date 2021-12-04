// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.block;

import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.Listener;

public class BlockPlace implements Listener
{
    @EventHandler
    public void onPlace(final BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();
        if (player.getLevel().getName().equals(Server.getInstance().getDefaultLevel().getName())) {
            if (!player.isOp()) {
                event.setCancelled(true);
            }
        }
        else if (player.getLevel().getName().equals(Utils.map)) {
            Utils.blocks.add(block.getLocation());
        }
    }
}
