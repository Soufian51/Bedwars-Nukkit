// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.map;

import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.Player;
import java.util.Iterator;

import Steffen.bedwars.Bedwars;

public class MapVote
{
    public static String getResult() {
        int max = 0;
        for (final int i : Bedwars.votes.values()) {
            if (i > max) {
                max = i;
            }
        }
        String map = "";
        for (final String all : Bedwars.votes.keySet()) {
            if (Bedwars.votes.get(all) == max) {
                map = all;
            }
        }
        return map;
    }
    
    public static void openMapVote(final Player player) {
        final FormWindowSimple gui = new FormWindowSimple("Map Voting", " ");
        for (final String maps : Bedwars.arenas) {
            gui.addButton(new ElementButton(maps));
        }
        player.showFormWindow((FormWindow)gui);
    }
}
