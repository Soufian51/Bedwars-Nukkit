// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.commands;

import java.util.Iterator;

import Steffen.bedwars.Bedwars;
import cn.nukkit.utils.Config;
import java.util.ArrayList;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.Command;

public class SetupCommand extends Command
{
    private Bedwars plugin;
    
    public SetupCommand(final Bedwars plugin) {
        super("setup", "Bedwars Setup");
        this.plugin = plugin;
        this.setPermission("bedwars.setup");
    }
    
    public boolean execute(final CommandSender sender, final String s, final String[] args) {
        if (!this.testPermission(sender)) {
            return false;
        }
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length > 0) {
                final ArrayList<String> list = new ArrayList<String>();
                final Config config = new Config(this.plugin.getDataFolder() + "/" + args[0] + ".yml", 2);
                if (args.length > 1) {
                    if (args[1].equalsIgnoreCase("spawner")) {
                        if (args.length > 2) {
                            if (config.exists("spawner")) {
                                for (final String l : config.getStringList("spawner")) {
                                    list.add(l);
                                }
                            }
                            if (args[2].equalsIgnoreCase("bronze")) {
                                list.add("b:" + player.getFloorX() + ":" + player.getFloorY() + ":" + player.getFloorZ());
                                config.set("spawner", (Object)list);
                                player.sendMessage(Bedwars.prefix + "Bronze spawner: " + player.getFloorX() + ":" + player.getFloorY() + ":" + player.getFloorZ());
                            }
                            else if (args[2].equalsIgnoreCase("iron")) {
                                list.add("i:" + player.getFloorX() + ":" + player.getFloorY() + ":" + player.getFloorZ());
                                config.set("spawner", (Object)list);
                                player.sendMessage(Bedwars.prefix + "Iron spawner: " + player.getFloorX() + ":" + player.getFloorY() + ":" + player.getFloorZ());
                            }
                            else if (args[2].equalsIgnoreCase("gold")) {
                                list.add("g:" + player.getFloorX() + ":" + player.getFloorY() + ":" + player.getFloorZ());
                                config.set("spawner", (Object)list);
                                player.sendMessage(Bedwars.prefix + "Gold spawner: " + player.getFloorX() + ":" + player.getFloorY() + ":" + player.getFloorZ());
                            }
                            config.set("spawner", (Object)list);
                            config.save();
                        }
                    }
                    else if (args[1].equalsIgnoreCase("team")) {
                        if (args.length > 2 && args[2].equalsIgnoreCase("add") && args.length > 3) {
                            if (config.exists("teams")) {
                                for (final String l : config.getStringList("teams")) {
                                    list.add(l);
                                }
                            }
                            list.add(args[3] + ":" + player.getFloorX() + ":" + player.getFloorY() + ":" + player.getFloorZ());
                            player.sendMessage(Bedwars.prefix + "Team " + args[3] + " §7added.");
                            config.set("teams", (Object)list);
                            config.save();
                        }
                    }
                    else if (args[1].equalsIgnoreCase("shop") && args.length > 2 && args[2].equalsIgnoreCase("add")) {
                        if (config.exists("shops")) {
                            for (final String l : config.getStringList("shops")) {
                                list.add(l);
                            }
                        }
                        list.add(player.getX() + ":" + player.getY() + ":" + player.getZ());
                        player.sendMessage(Bedwars.prefix + "Shop: " + player.getX() + ":" + player.getY() + ":" + player.getZ());
                        config.set("shops", (Object)list);
                        config.save();
                    }
                }
            }
            else {
                this.sendHelp(player);
            }
        }
        return false;
    }
    
    private void sendHelp(final Player player) {
        player.sendMessage(Bedwars.prefix + "Bedwars Befehls-Liste");
        player.sendMessage(Bedwars.prefix + "/setup <map> team add <team>");
        player.sendMessage(Bedwars.prefix + "/setup <map> shop add");
        player.sendMessage(Bedwars.prefix + "/setup <map> spawner <bronze, iron, gold");
    }
}
