// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.world;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.level.WeatherChangeEvent;
import cn.nukkit.event.Listener;

public class WeatherChange implements Listener
{
    @EventHandler
    public void onChange(final WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
