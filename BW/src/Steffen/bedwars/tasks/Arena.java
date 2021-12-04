// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.tasks;

import java.util.Iterator;

import Steffen.bedwars.Bedwars;
import Steffen.bedwars.map.Map;
import Steffen.bedwars.map.MapVote;
import Steffen.bedwars.utils.BWPlayer;
import Steffen.bedwars.utils.BWTeam;
import Steffen.bedwars.utils.Utils;

import java.net.InetSocketAddress;

import cn.nukkit.entity.Entity;
import cn.nukkit.level.Position;
import java.util.Collection;
import cn.nukkit.utils.Config;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.Task;

public class Arena extends Task
{
    public void onRun(final int i) {
        if (Utils.STATUS_LOBBY) {
            if (Server.getInstance().getOnlinePlayers().size() < Utils.min_players_for_start) {
                Utils.lobby_time = 30;
                Server.getInstance().getNetwork().setName("§a§lLOBBY");
                for (final Player player : Server.getInstance().getOnlinePlayers().values()) {
                    player.sendTip("§cWaiting for more players...");
                }
            }
            else {
                if (Utils.lobby_time != 0) {
                    final Integer lobby_time = Utils.lobby_time;
                    --Utils.lobby_time;
                }
                for (final Player player : Server.getInstance().getOnlinePlayers().values()) {
                    player.sendTip("§cThe game starts in " + Utils.lobby_time + " second(s)...");
                }
                if (Utils.lobby_time == 5) {
                    final String map = Utils.map = MapVote.getResult();
                    for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                        player2.sendMessage(Bedwars.prefix + "It is played on the Map §3" + Utils.map + "§7.");
                    }
                    new Map(Utils.map).init();
                    Utils.map = map;
                }
                if (Utils.lobby_time == 0) {
                    Server.getInstance().getNetwork().setName("§6§lINGAME");
                    Utils.STATUS_LOBBY = false;
                    Utils.STATUS_INGAME = true;
                    Utils.teams.clear();
                    final Config config = new Config(Bedwars.getInstance().getDataFolder() + "/" + Utils.map + ".yml", 2);
                    Utils.teams.addAll(config.getStringList("teams"));
                    for (final String list : config.getStringList("shops")) {
                        final String[] ex = list.split(":");
                        final Entity entity = Entity.createEntity("Villager", new Position(Double.parseDouble(ex[0]), Double.parseDouble(ex[1]), Double.parseDouble(ex[2]), Server.getInstance().getLevelByName(Utils.map)), new Object[0]);
                        entity.setNameTag("§c§lSHOP");
                        entity.spawnToAll();
                    }
                    Server.getInstance().broadcastMessage(Bedwars.prefix + "The round has begun.");
                    Server.getInstance().broadcastMessage(Bedwars.prefix + "The game ends in 60 minutes.");
                    for (final String teams : Utils.teams) {
                        final String[] ex = teams.split(":");
                        Utils.use.put(ex[0], true);
                    }
                    for (final Player pl : Server.getInstance().getOnlinePlayers().values()) {
                        final String player3 = pl.getName();
                        pl.getInventory().clearAll();
                        System.out.println(player3);
                        if (Utils.BLUE.size() < Utils.players_per_team && Utils.use.get("§9Blue") && !Utils.BLUE.contains(player3) && !Utils.BLACK.contains(player3) && !Utils.ORANGE.contains(player3) && !Utils.PINK.contains(player3) && !Utils.MAGENTA.contains(player3) && !Utils.GREEN.contains(player3) && !Utils.RED.contains(player3) && !Utils.YELLOW.contains(player3)) {
                            Utils.BLUE.add(player3);
                        }
                        if (Utils.PINK.size() < Utils.players_per_team && Utils.use.get("§dPink") && !Utils.PINK.contains(player3) && !Utils.BLACK.contains(player3) && !Utils.ORANGE.contains(player3) && !Utils.BLUE.contains(player3) && !Utils.MAGENTA.contains(player3) && !Utils.GREEN.contains(player3) && !Utils.RED.contains(player3) && !Utils.YELLOW.contains(player3)) {
                            Utils.PINK.add(player3);
                        }
                        if (Utils.RED.size() < Utils.players_per_team && Utils.use.get("§cRed") && !Utils.RED.contains(player3) && !Utils.BLACK.contains(player3) && !Utils.ORANGE.contains(player3) && !Utils.PINK.contains(player3) && !Utils.MAGENTA.contains(player3) && !Utils.GREEN.contains(player3) && !Utils.BLUE.contains(player3) && !Utils.YELLOW.contains(player3)) {
                            Utils.RED.add(player3);
                        }
                        if (Utils.MAGENTA.size() < Utils.players_per_team && Utils.use.get("§5Magenta") && !Utils.MAGENTA.contains(player3) && !Utils.BLACK.contains(player3) && !Utils.ORANGE.contains(player3) && !Utils.PINK.contains(player3) && !Utils.BLUE.contains(player3) && !Utils.GREEN.contains(player3) && !Utils.RED.contains(player3) && !Utils.YELLOW.contains(player3)) {
                            Utils.MAGENTA.add(player3);
                        }
                        if (Utils.GREEN.size() < Utils.players_per_team && Utils.use.get("§aGreen") && !Utils.GREEN.contains(player3) && !Utils.BLACK.contains(player3) && !Utils.ORANGE.contains(player3) && !Utils.PINK.contains(player3) && !Utils.MAGENTA.contains(player3) && !Utils.BLUE.contains(player3) && !Utils.RED.contains(player3) && !Utils.YELLOW.contains(player3)) {
                            Utils.GREEN.add(player3);
                        }
                        if (Utils.YELLOW.size() < Utils.players_per_team && Utils.use.get("§eYellow") && !Utils.YELLOW.contains(player3) && !Utils.BLACK.contains(player3) && !Utils.ORANGE.contains(player3) && !Utils.PINK.contains(player3) && !Utils.MAGENTA.contains(player3) && !Utils.GREEN.contains(player3) && !Utils.RED.contains(player3) && !Utils.BLUE.contains(player3)) {
                            Utils.YELLOW.add(player3);
                        }
                        if (Utils.BLACK.size() < Utils.players_per_team && Utils.use.get("§0Black") && !Utils.BLACK.contains(player3) && !Utils.BLUE.contains(player3) && !Utils.ORANGE.contains(player3) && !Utils.PINK.contains(player3) && !Utils.MAGENTA.contains(player3) && !Utils.GREEN.contains(player3) && !Utils.RED.contains(player3) && !Utils.YELLOW.contains(player3)) {
                            Utils.BLACK.add(player3);
                        }
                        if (Utils.ORANGE.size() < Utils.players_per_team && Utils.use.get("§6Orange") && !Utils.ORANGE.contains(player3) && !Utils.BLACK.contains(player3) && !Utils.BLUE.contains(player3) && !Utils.PINK.contains(player3) && !Utils.MAGENTA.contains(player3) && !Utils.GREEN.contains(player3) && !Utils.RED.contains(player3) && !Utils.YELLOW.contains(player3)) {
                            Utils.ORANGE.add(player3);
                        }
                    }
                    for (final Player player2 : Server.getInstance().getOnlinePlayers().values()) {
                        player2.setNameTag("§8[" + new BWPlayer(player2).getTeam() + "§8] " + new BWTeam(new BWPlayer(player2).getTeam()).getColorCode() + player2.getName());
                        player2.teleport(new BWTeam(new BWPlayer(player2).getTeam()).getSpawn());
                    }
                }
            }
        }
        if (Utils.STATUS_INGAME) {
            if (Utils.game_time != 0) {
                final Integer game_time = Utils.game_time;
                --Utils.game_time;
            }
            else {
                Server.getInstance().getNetwork().setName("§c§lRESTARTING");
                Server.getInstance().broadcastMessage(Bedwars.prefix + "The round is over.");
                Utils.STATUS_INGAME = false;
                Utils.STATUS_END = true;
                Bedwars.endGame();
            }
            if (Utils.STATUS_INGAME && Bedwars.hasWinner() != null) {
                Utils.STATUS_INGAME = false;
                Utils.STATUS_END = true;
                Bedwars.endGame();
            }
        }
        if (Utils.STATUS_END) {
            if (Utils.end_time != 0) {
                final Integer end_time = Utils.end_time;
                --Utils.end_time;
            }
            for (final Player player : Server.getInstance().getOnlinePlayers().values()) {
                player.sendTip("§cThe server restarts in " + Utils.end_time + " second(s)...");
            }
            if (Utils.end_time == 5) {
                final String[] s = Utils.fallback_server.split(":");
                final InetSocketAddress ip = new InetSocketAddress(s[0], Integer.parseInt(s[1]));
                for (final Player player4 : Server.getInstance().getOnlinePlayers().values()) {
                    player4.transfer(ip);
                }
            }
            if (Utils.end_time == 0) {
                Bedwars.stop();
            }
        }
    }
}
