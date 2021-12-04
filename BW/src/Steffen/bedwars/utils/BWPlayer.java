// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.utils;

import cn.nukkit.Player;

public class BWPlayer
{
    private Player player;
    
    public BWPlayer(final Player player) {
        this.player = player;
    }
    
    public String getTeam() {
        if (Utils.PINK.contains(this.player.getName())) {
            return "§dPink";
        }
        if (Utils.MAGENTA.contains(this.player.getName())) {
            return "§5Magenta";
        }
        if (Utils.BLACK.contains(this.player.getName())) {
            return "§0Black";
        }
        if (Utils.BLUE.contains(this.player.getName())) {
            return "§9Blue";
        }
        if (Utils.GREEN.contains(this.player.getName())) {
            return "§aGreen";
        }
        if (Utils.ORANGE.contains(this.player.getName())) {
            return "§6Orange";
        }
        if (Utils.YELLOW.contains(this.player.getName())) {
            return "§eYellow";
        }
        if (Utils.RED.contains(this.player.getName())) {
            return "§cRed";
        }
        return null;
    }
}
