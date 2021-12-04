// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.tasks;

import java.util.Iterator;

import Steffen.bedwars.utils.Utils;
import cn.nukkit.item.Item;
import cn.nukkit.math.Vector3;
import cn.nukkit.Server;
import cn.nukkit.scheduler.Task;

public class Spawner extends Task
{
    private int bronzeDelay;
    private int ironDelay;
    private int goldDelay;
    
    public Spawner(final int bronzeDelay, final int ironDelay, final int goldDelay) {
        this.bronzeDelay = bronzeDelay;
        this.ironDelay = ironDelay;
        this.goldDelay = goldDelay;
    }
    
    public void onRun(final int i) {
        if (Utils.STATUS_INGAME) {
            --this.bronzeDelay;
            --this.ironDelay;
            --this.goldDelay;
            if (this.bronzeDelay == -1) {
                for (final String spawns : Utils.bronzeSpawners) {
                    this.bronzeDelay = 1;
                    final String[] ex = spawns.split(":");
                    Server.getInstance().getLevelByName(Utils.map).dropItem(new Vector3(Double.parseDouble(ex[1]), Double.parseDouble(ex[2]), Double.parseDouble(ex[3])), Item.get(336, Integer.valueOf(0), 1));
                }
            }
            if (this.ironDelay == -1) {
                this.ironDelay = 15;
                for (final String spawns : Utils.ironSpawners) {
                    final String[] ex = spawns.split(":");
                    Server.getInstance().getLevelByName(Utils.map).dropItem(new Vector3(Double.parseDouble(ex[1]), Double.parseDouble(ex[2]), Double.parseDouble(ex[3])), Item.get(265, Integer.valueOf(0), 1));
                }
            }
            if (this.goldDelay == -1) {
                this.goldDelay = 30;
                for (final String spawns : Utils.goldSpawners) {
                    final String[] ex = spawns.split(":");
                    Server.getInstance().getLevelByName(Utils.map).dropItem(new Vector3(Double.parseDouble(ex[1]), Double.parseDouble(ex[2]), Double.parseDouble(ex[3])), Item.get(266, Integer.valueOf(0), 1));
                }
            }
        }
    }
}
