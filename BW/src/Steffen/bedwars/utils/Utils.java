// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.utils;

import java.util.HashMap;
import cn.nukkit.level.Location;
import java.util.ArrayList;

public class Utils
{
    public static ArrayList<String> teams;
    public static ArrayList<String> bronzeSpawners;
    public static ArrayList<String> ironSpawners;
    public static ArrayList<String> goldSpawners;
    public static Integer players_per_team;
    public static Integer min_players_for_start;
    public static String fallback_server;
    public static int bronzeDelay;
    public static int ironDelay;
    public static int goldDelay;
    public static String map;
    public static ArrayList<Location> blocks;
    public static ArrayList<String> PINK;
    public static ArrayList<String> MAGENTA;
    public static ArrayList<String> BLACK;
    public static ArrayList<String> YELLOW;
    public static ArrayList<String> RED;
    public static ArrayList<String> GREEN;
    public static ArrayList<String> ORANGE;
    public static ArrayList<String> BLUE;
    public static HashMap<String, Boolean> use;
    public static HashMap<String, Boolean> bed_destroyed;
    public static Boolean STATUS_LOBBY;
    public static Boolean STATUS_INGAME;
    public static Boolean STATUS_END;
    public static Integer game_time;
    public static Integer lobby_time;
    public static Integer end_time;
    
    static {
        Utils.teams = new ArrayList<String>();
        Utils.bronzeSpawners = new ArrayList<String>();
        Utils.ironSpawners = new ArrayList<String>();
        Utils.goldSpawners = new ArrayList<String>();
        Utils.blocks = new ArrayList<Location>();
        Utils.PINK = new ArrayList<String>();
        Utils.MAGENTA = new ArrayList<String>();
        Utils.BLACK = new ArrayList<String>();
        Utils.YELLOW = new ArrayList<String>();
        Utils.RED = new ArrayList<String>();
        Utils.GREEN = new ArrayList<String>();
        Utils.ORANGE = new ArrayList<String>();
        Utils.BLUE = new ArrayList<String>();
        Utils.use = new HashMap<String, Boolean>();
        Utils.bed_destroyed = new HashMap<String, Boolean>();
        Utils.STATUS_LOBBY = true;
        Utils.STATUS_INGAME = false;
        Utils.STATUS_END = false;
        Utils.game_time = 3600;
        Utils.lobby_time = 30;
        Utils.end_time = 15;
    }
}
