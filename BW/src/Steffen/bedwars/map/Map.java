// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.map;

import java.util.Iterator;

import Steffen.bedwars.Bedwars;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.utils.Config;

public class Map
{
    private String map;
    
    public Map(final String map) {
        this.map = map;
    }
    
    public void init() {
        final Config config = new Config(Bedwars.getInstance().getDataFolder() + "/" + this.map + ".yml", 2);
        for (final String list : config.getStringList("spawner")) {
            final String[] ex = list.split(":");
            if (ex[0].equals("b")) {
                Utils.bronzeSpawners.add(list);
            }
            if (ex[0].equals("i")) {
                Utils.ironSpawners.add(list);
            }
            if (ex[0].equals("g")) {
                Utils.goldSpawners.add(list);
            }
        }
        new Reset(this.map);
    }
}
