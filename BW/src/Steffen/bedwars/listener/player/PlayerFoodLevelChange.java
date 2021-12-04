// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerFoodLevelChangeEvent;
import cn.nukkit.event.Listener;

public class PlayerFoodLevelChange implements Listener
{
    @EventHandler
    public void onFoodChange(final PlayerFoodLevelChangeEvent event) {
        event.setCancelled(true);
    }
}
