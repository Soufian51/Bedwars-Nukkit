// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.Listener;

public class PlayerJoin implements Listener
{
    @EventHandler
    public void onJoin(final PlayerJoinEvent event) {
        event.setJoinMessage("");
    }
}
