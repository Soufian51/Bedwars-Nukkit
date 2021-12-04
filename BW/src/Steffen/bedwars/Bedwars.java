package Steffen.bedwars;

import cn.nukkit.Server;
import cn.nukkit.form.window.FormWindow;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import java.util.Iterator;

import Steffen.bedwars.commands.SetupCommand;
import Steffen.bedwars.listener.block.BlockBreak;
import Steffen.bedwars.listener.block.BlockPlace;
import Steffen.bedwars.listener.entity.EntityDamage;
import Steffen.bedwars.listener.entity.EntityDamageByEntity;
import Steffen.bedwars.listener.inventory.InventoryTransaction;
import Steffen.bedwars.listener.packet.DataPacketReceive;
import Steffen.bedwars.listener.player.PlayerChat;
import Steffen.bedwars.listener.player.PlayerDeath;
import Steffen.bedwars.listener.player.PlayerDropItem;
import Steffen.bedwars.listener.player.PlayerFoodLevelChange;
import Steffen.bedwars.listener.player.PlayerFormResponded;
import Steffen.bedwars.listener.player.PlayerInteract;
import Steffen.bedwars.listener.player.PlayerJoin;
import Steffen.bedwars.listener.player.PlayerMove;
import Steffen.bedwars.listener.player.PlayerQuit;
import Steffen.bedwars.listener.player.PlayerRespawn;
import Steffen.bedwars.listener.world.WeatherChange;
import Steffen.bedwars.tasks.Arena;
import Steffen.bedwars.tasks.SBoardTask;
import Steffen.bedwars.tasks.Spawner;
import Steffen.bedwars.utils.Utils;

import java.util.Collection;
import java.io.File;
import cn.nukkit.command.Command;
import cn.nukkit.scheduler.Task;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.event.Listener;
import de.theamychan.scoreboard.network.Scoreboard;
import cn.nukkit.Player;
import java.util.ArrayList;
import java.util.HashMap;
import cn.nukkit.plugin.PluginBase;

public class Bedwars extends PluginBase
{
    private static Bedwars instance;
    public static HashMap<String, String> voted;
    public static HashMap<String, Integer> votes;
    public static ArrayList<String> arenas;
    public static String prefix;
    public static HashMap<Player, Scoreboard> scoreboards;
    
    public static Bedwars getInstance() {
        return Bedwars.instance;
    }
    
    public void onEnable() {
        (Bedwars.instance = this).init();
        this.getServer().getLevelByName(this.getServer().getDefaultLevel().getName()).setTime(1000);
        this.getServer().getLevelByName(this.getServer().getDefaultLevel().getName()).stopTime();
        this.getServer().getLevelByName(this.getServer().getDefaultLevel().getName()).setRaining(false);
        this.registerListeners();
        this.registerCommands();
        this.registerTasks();
    }
    
    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents((Listener)new BlockBreak(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new BlockPlace(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new EntityDamage(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new EntityDamageByEntity(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new InventoryTransaction(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new DataPacketReceive(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerDeath(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerDropItem(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerFoodLevelChange(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerFormResponded(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerInteract(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerJoin(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerMove(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerChat(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerQuit(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new PlayerRespawn(), (Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)new WeatherChange(), (Plugin)this);
    }
    
    private void registerTasks() {
        this.getServer().getScheduler().scheduleRepeatingTask((Task)new SBoardTask(), 20);
        this.getServer().getScheduler().scheduleRepeatingTask((Task)new Arena(), 20);
        this.getServer().getScheduler().scheduleRepeatingTask((Task)new Spawner(Utils.bronzeDelay, Utils.ironDelay, Utils.goldDelay), 20);
    }
    
    private void registerCommands() {
        this.getServer().getCommandMap().register("setup", (Command)new SetupCommand(this));
    }
    
    private void init() {
        new File(this.getDataFolder() + "/map/").mkdirs();
        this.saveDefaultConfig();
        Utils.use.put("§dPink", false);
        Utils.use.put("§5Magenta", false);
        Utils.use.put("§0Black", false);
        Utils.use.put("§eYellow", false);
        Utils.use.put("§aGreen", false);
        Utils.use.put("§9Blue", false);
        Utils.use.put("§cRed", false);
        Utils.use.put("§6Orange", false);
        Utils.bed_destroyed.put("§dPink", false);
        Utils.bed_destroyed.put("§5Magenta", false);
        Utils.bed_destroyed.put("§0Black", false);
        Utils.bed_destroyed.put("§eYellow", false);
        Utils.bed_destroyed.put("§aGreen", false);
        Utils.bed_destroyed.put("§9Blue", false);
        Utils.bed_destroyed.put("§cRed", false);
        Utils.bed_destroyed.put("§6Orange", false);
        Bedwars.arenas.addAll(this.getConfig().getStringList("maps"));
        for (final String map : Bedwars.arenas) {
            Bedwars.votes.put(map, 0);
        }
        Utils.teams.addAll(this.getConfig().getStringList("teams"));
        Utils.players_per_team = this.getConfig().getInt("players-per-team");
        Utils.min_players_for_start = this.getConfig().getInt("min-players-for-start");
        Utils.bronzeDelay = this.getConfig().getInt("spawner.bronze");
        Utils.ironDelay = this.getConfig().getInt("spawner.iron");
        Utils.goldDelay = this.getConfig().getInt("spawner.gold");
        Utils.fallback_server = this.getConfig().getString("fallback-server");
        this.getLogger().info("Bedwars Plugin Aktiv");
    }
    
    public static void showTeamsUI(final Player player) {
        final FormWindowSimple gui = new FormWindowSimple("Team selection", " ");
        for (final String teams : Utils.teams) {
            final String[] ex = teams.split(":");
            gui.addButton(new ElementButton(ex[0]));
        }
        player.showFormWindow((FormWindow)gui);
    }
    
    public static String hasWinner() {
        if (Utils.PINK.size() > 0 && Utils.MAGENTA.size() == 0 && Utils.GREEN.size() == 0 && Utils.YELLOW.size() == 0 && Utils.BLUE.size() == 0 && Utils.BLACK.size() == 0 && Utils.RED.size() == 0 && Utils.ORANGE.size() == 0) {
            return "§dPink";
        }
        if (Utils.MAGENTA.size() > 0 && Utils.PINK.size() == 0 && Utils.GREEN.size() == 0 && Utils.YELLOW.size() == 0 && Utils.BLUE.size() == 0 && Utils.BLACK.size() == 0 && Utils.RED.size() == 0 && Utils.ORANGE.size() == 0) {
            return "§5Magenta";
        }
        if (Utils.GREEN.size() > 0 && Utils.PINK.size() == 0 && Utils.MAGENTA.size() == 0 && Utils.YELLOW.size() == 0 && Utils.BLUE.size() == 0 && Utils.BLACK.size() == 0 && Utils.RED.size() == 0 && Utils.ORANGE.size() == 0) {
            return "§aGreen";
        }
        if (Utils.YELLOW.size() > 0 && Utils.PINK.size() == 0 && Utils.GREEN.size() == 0 && Utils.MAGENTA.size() == 0 && Utils.BLUE.size() == 0 && Utils.BLACK.size() == 0 && Utils.RED.size() == 0 && Utils.ORANGE.size() == 0) {
            return "§eYellow";
        }
        if (Utils.BLUE.size() > 0 && Utils.PINK.size() == 0 && Utils.GREEN.size() == 0 && Utils.YELLOW.size() == 0 && Utils.MAGENTA.size() == 0 && Utils.BLACK.size() == 0 && Utils.RED.size() == 0 && Utils.ORANGE.size() == 0) {
            return "§9Blue";
        }
        if (Utils.BLACK.size() > 0 && Utils.PINK.size() == 0 && Utils.GREEN.size() == 0 && Utils.YELLOW.size() == 0 && Utils.BLUE.size() == 0 && Utils.MAGENTA.size() == 0 && Utils.RED.size() == 0 && Utils.ORANGE.size() == 0) {
            return "§0Black";
        }
        if (Utils.RED.size() > 0 && Utils.PINK.size() == 0 && Utils.GREEN.size() == 0 && Utils.YELLOW.size() == 0 && Utils.BLUE.size() == 0 && Utils.BLACK.size() == 0 && Utils.MAGENTA.size() == 0 && Utils.ORANGE.size() == 0) {
            return "§cRed";
        }
        if (Utils.ORANGE.size() > 0 && Utils.PINK.size() == 0 && Utils.GREEN.size() == 0 && Utils.YELLOW.size() == 0 && Utils.BLUE.size() == 0 && Utils.BLACK.size() == 0 && Utils.RED.size() == 0 && Utils.MAGENTA.size() == 0) {
            return "§6Orange";
        }
        return null;
    }
    
    public static void endGame() {
        if (hasWinner() != null) {
            for (final Player player : Server.getInstance().getOnlinePlayers().values()) {
                player.sendMessage(Bedwars.prefix + "Team " + hasWinner() + " §7won the game.");
            }
        }
    }
    
    public static void stop() {
        Server.getInstance().shutdown();
    }
    
    public static void removeFromTeam(final Player player) {
        Utils.PINK.remove(player.getName());
        Utils.MAGENTA.remove(player.getName());
        Utils.BLACK.remove(player.getName());
        Utils.BLUE.remove(player.getName());
        Utils.GREEN.remove(player.getName());
        Utils.ORANGE.remove(player.getName());
        Utils.YELLOW.remove(player.getName());
        Utils.RED.remove(player.getName());
    }
    
    static {
        Bedwars.voted = new HashMap<String, String>();
        Bedwars.votes = new HashMap<String, Integer>();
        Bedwars.arenas = new ArrayList<String>();
        Bedwars.prefix = "§8[§bBW§8] §7";
        Bedwars.scoreboards = new HashMap<Player, Scoreboard>();
    }
}
