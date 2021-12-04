// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.entity;

import cn.nukkit.event.EventHandler;
import cn.nukkit.entity.Entity;
import Steffen.bedwars.utils.BWPlayer;
import cn.nukkit.Player;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.Listener;

public class EntityDamageByEntity implements Listener
{
    @EventHandler
    public void onDamageBy(final EntityDamageByEntityEvent event) {
        final Entity entity = event.getEntity();
        final Entity damager = event.getDamager();
        if (entity instanceof Player && damager instanceof Player && new BWPlayer((Player)entity).getTeam().equals(new BWPlayer((Player)damager).getTeam())) {
            event.setCancelled(true);
        }
    }
}
