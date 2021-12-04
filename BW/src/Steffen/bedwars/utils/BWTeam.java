// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.utils;

import java.util.Iterator;
import cn.nukkit.Server;
import cn.nukkit.level.Position;

public class BWTeam
{
    private String team;
    
    public BWTeam(final String team) {
        this.team = team;
    }
    
    public Integer getSize() {
        final String team = this.team;
        switch (team) {
            case "§dPink": {
                return Utils.PINK.size();
            }
            case "§5Magenta": {
                return Utils.MAGENTA.size();
            }
            case "§0Black": {
                return Utils.BLACK.size();
            }
            case "§aGreen": {
                return Utils.GREEN.size();
            }
            case "§cRed": {
                return Utils.RED.size();
            }
            case "§9Blue": {
                return Utils.BLUE.size();
            }
            case "§6Orange": {
                return Utils.ORANGE.size();
            }
            case "§eYellow": {
                return Utils.YELLOW.size();
            }
            default: {
                return null;
            }
        }
    }
    
    public Position getSpawn() {
        for (final String teams : Utils.teams) {
            final String[] ex = teams.split(":");
            if (ex[0].equals(this.team)) {
                return new Position(Double.parseDouble(ex[1]), Double.parseDouble(ex[2]), Double.parseDouble(ex[3]), Server.getInstance().getLevelByName(Utils.map));
            }
        }
        return null;
    }
    
    public String getBedColor(final String color) {
        if (color.equals("Pink")) {
            return "§dPink";
        }
        if (color.equals("Magenta")) {
            return "§5Magenta";
        }
        if (color.equals("Black")) {
            return "§0Black";
        }
        if (color.equals("Yellow")) {
            return "§eYellow";
        }
        if (color.equals("Red")) {
            return "§cRed";
        }
        if (color.equals("Green")) {
            return "§aGreen";
        }
        if (color.equals("Orange")) {
            return "§6Orange";
        }
        if (color.equals("Blue")) {
            return "§9Blue";
        }
        return null;
    }
    
    public String getColorCode() {
        if (this.team.equals("§dPink")) {
            return "§d";
        }
        if (this.team.equals("§5Magenta")) {
            return "§5";
        }
        if (this.team.equals("§0Black")) {
            return "§0";
        }
        if (this.team.equals("§eYellow")) {
            return "§e";
        }
        if (this.team.equals("§cRed")) {
            return "§c";
        }
        if (this.team.equals("§aGreen")) {
            return "§a";
        }
        if (this.team.equals("§6Orange")) {
            return "§6";
        }
        if (this.team.equals("§9Blue")) {
            return "§9";
        }
        return null;
    }
}
