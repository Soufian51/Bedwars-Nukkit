// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.entity;

import cn.nukkit.event.EventHandler;
import cn.nukkit.Server;
import cn.nukkit.Player;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.Listener;

public class EntityDamage implements Listener
{
    @EventHandler
    public void onDamage(final EntityDamageEvent event) {
        if (event.getEntity() instanceof Player && event.getEntity().getLevel().getName().equalsIgnoreCase(Server.getInstance().getDefaultLevel().getName())) {
            event.setCancelled(true);
        }
    }
}
