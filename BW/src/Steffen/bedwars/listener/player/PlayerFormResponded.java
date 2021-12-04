// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import Steffen.bedwars.Bedwars;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.Player;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.Listener;

public class PlayerFormResponded implements Listener
{
    @EventHandler
    public void onFormResponse(final PlayerFormRespondedEvent e) {
        final Player p = e.getPlayer();
        if (e.getWindow() instanceof FormWindowSimple) {
            if (e.getResponse() == null) {
                return;
            }
            final FormWindowSimple gui = (FormWindowSimple)e.getWindow();
            final String responseName = gui.getResponse().getClickedButton().getText();
            if (gui.getTitle().equals("Map Voting")) {
                if (Bedwars.voted.get(p.getName()) == null) {
                    Bedwars.votes.put(responseName, Bedwars.votes.get(responseName) + 1);
                }
                else {
                    Bedwars.votes.put(Bedwars.voted.get(p.getName()), Bedwars.votes.get(Bedwars.voted.get(p.getName())) - 1);
                    Bedwars.votes.put(responseName, Bedwars.votes.get(responseName) + 1);
                }
                Bedwars.voted.put(p.getName(), responseName);
                p.sendMessage(Bedwars.prefix + "You voted for the map §3" + responseName + "§7.");
            }
            else if (responseName.equals("§dPink")) {
                if (Utils.PINK.size() != Utils.players_per_team) {
                    if (!Utils.PINK.contains(p.getName())) {
                        Utils.PINK.add(p.getName());
                        checkAndRemoveFromTeam(p, responseName);
                        p.sendMessage(Bedwars.prefix + "You've joined the " + responseName + "§7 team.");
                    }
                    else {
                        p.sendMessage(Bedwars.prefix + "You're already on this team.");
                    }
                }
                else {
                    p.sendMessage(Bedwars.prefix + "This team is full.");
                }
            }
            else if (responseName.equals("§5Magenta")) {
                if (Utils.MAGENTA.size() != Utils.players_per_team) {
                    if (!Utils.MAGENTA.contains(p.getName())) {
                        Utils.MAGENTA.add(p.getName());
                        checkAndRemoveFromTeam(p, responseName);
                        p.sendMessage(Bedwars.prefix + "You've joined the " + responseName + "§7 team.");
                    }
                    else {
                        p.sendMessage(Bedwars.prefix + "You're already on this team.");
                    }
                }
                else {
                    p.sendMessage(Bedwars.prefix + "This team is full.");
                }
            }
            else if (responseName.equals("§0Black")) {
                if (Utils.BLACK.size() != Utils.players_per_team) {
                    if (!Utils.BLACK.contains(p.getName())) {
                        Utils.BLACK.add(p.getName());
                        checkAndRemoveFromTeam(p, responseName);
                        p.sendMessage(Bedwars.prefix + "You've joined the " + responseName + "§7 team.");
                    }
                    else {
                        p.sendMessage(Bedwars.prefix + "You're already on this team.");
                    }
                }
                else {
                    p.sendMessage(Bedwars.prefix + "This team is full.");
                }
            }
            else if (responseName.equals("§eYellow")) {
                if (Utils.YELLOW.size() != Utils.players_per_team) {
                    if (!Utils.YELLOW.contains(p.getName())) {
                        Utils.YELLOW.add(p.getName());
                        checkAndRemoveFromTeam(p, responseName);
                        p.sendMessage(Bedwars.prefix + "You've joined the " + responseName + "§7 team.");
                    }
                    else {
                        p.sendMessage(Bedwars.prefix + "You're already on this team.");
                    }
                }
                else {
                    p.sendMessage(Bedwars.prefix + "This team is full.");
                }
            }
            else if (responseName.equals("§cRed")) {
                if (Utils.RED.size() != Utils.players_per_team) {
                    if (!Utils.RED.contains(p.getName())) {
                        Utils.RED.add(p.getName());
                        checkAndRemoveFromTeam(p, responseName);
                        p.sendMessage(Bedwars.prefix + "You've joined the " + responseName + "§7 team.");
                    }
                    else {
                        p.sendMessage(Bedwars.prefix + "You're already on this team.");
                    }
                }
                else {
                    p.sendMessage(Bedwars.prefix + "This team is full.");
                }
            }
            else if (responseName.equals("§aGreen")) {
                if (Utils.GREEN.size() != Utils.players_per_team) {
                    if (!Utils.GREEN.contains(p.getName())) {
                        Utils.GREEN.add(p.getName());
                        checkAndRemoveFromTeam(p, responseName);
                        p.sendMessage(Bedwars.prefix + "You've joined the " + responseName + "§7 team.");
                    }
                    else {
                        p.sendMessage(Bedwars.prefix + "You're already on this team.");
                    }
                }
                else {
                    p.sendMessage(Bedwars.prefix + "This team is full.");
                }
            }
            else if (responseName.equals("§6Orange")) {
                if (Utils.ORANGE.size() != Utils.players_per_team) {
                    if (!Utils.ORANGE.contains(p.getName())) {
                        Utils.ORANGE.add(p.getName());
                        checkAndRemoveFromTeam(p, responseName);
                        p.sendMessage(Bedwars.prefix + "You've joined the " + responseName + "§7 team.");
                    }
                    else {
                        p.sendMessage(Bedwars.prefix + "You're already on this team.");
                    }
                }
                else {
                    p.sendMessage(Bedwars.prefix + "This team is full.");
                }
            }
            else if (responseName.equals("§9Blue")) {
                if (Utils.BLUE.size() != Utils.players_per_team) {
                    if (!Utils.BLUE.contains(p.getName())) {
                        Utils.BLUE.add(p.getName());
                        checkAndRemoveFromTeam(p, responseName);
                        p.sendMessage(Bedwars.prefix + "You've joined the " + responseName + "§7 team.");
                    }
                    else {
                        p.sendMessage(Bedwars.prefix + "You're already on this team.");
                    }
                }
                else {
                    p.sendMessage(Bedwars.prefix + "This team is full.");
                }
            }
        }
    }
    
    private static void checkAndRemoveFromTeam(final Player player, final String team) {
        if (team.equals("§dPink")) {
            Utils.MAGENTA.remove(player.getName());
            Utils.BLACK.remove(player.getName());
            Utils.GREEN.remove(player.getName());
            Utils.YELLOW.remove(player.getName());
            Utils.RED.remove(player.getName());
            Utils.BLUE.remove(player.getName());
            Utils.ORANGE.remove(player.getName());
        }
        else if (team.equals("§5Magenta")) {
            Utils.PINK.remove(player.getName());
            Utils.BLACK.remove(player.getName());
            Utils.GREEN.remove(player.getName());
            Utils.YELLOW.remove(player.getName());
            Utils.RED.remove(player.getName());
            Utils.BLUE.remove(player.getName());
            Utils.ORANGE.remove(player.getName());
        }
        else if (team.equals("§0Black")) {
            Utils.PINK.remove(player.getName());
            Utils.MAGENTA.remove(player.getName());
            Utils.GREEN.remove(player.getName());
            Utils.YELLOW.remove(player.getName());
            Utils.RED.remove(player.getName());
            Utils.BLUE.remove(player.getName());
            Utils.ORANGE.remove(player.getName());
        }
        else if (team.equals("§aGreen")) {
            Utils.PINK.remove(player.getName());
            Utils.MAGENTA.remove(player.getName());
            Utils.BLACK.remove(player.getName());
            Utils.YELLOW.remove(player.getName());
            Utils.RED.remove(player.getName());
            Utils.BLUE.remove(player.getName());
            Utils.ORANGE.remove(player.getName());
        }
        else if (team.equals("§eYellow")) {
            Utils.PINK.remove(player.getName());
            Utils.MAGENTA.remove(player.getName());
            Utils.BLACK.remove(player.getName());
            Utils.GREEN.remove(player.getName());
            Utils.RED.remove(player.getName());
            Utils.BLUE.remove(player.getName());
            Utils.ORANGE.remove(player.getName());
        }
        else if (team.equals("§cRed")) {
            Utils.PINK.remove(player.getName());
            Utils.MAGENTA.remove(player.getName());
            Utils.BLACK.remove(player.getName());
            Utils.GREEN.remove(player.getName());
            Utils.YELLOW.remove(player.getName());
            Utils.BLUE.remove(player.getName());
            Utils.ORANGE.remove(player.getName());
        }
        else if (team.equals("§9Blue")) {
            Utils.PINK.remove(player.getName());
            Utils.MAGENTA.remove(player.getName());
            Utils.BLACK.remove(player.getName());
            Utils.GREEN.remove(player.getName());
            Utils.YELLOW.remove(player.getName());
            Utils.RED.remove(player.getName());
            Utils.ORANGE.remove(player.getName());
        }
        else if (team.equals("§6Orange")) {
            Utils.PINK.remove(player.getName());
            Utils.MAGENTA.remove(player.getName());
            Utils.BLACK.remove(player.getName());
            Utils.GREEN.remove(player.getName());
            Utils.YELLOW.remove(player.getName());
            Utils.RED.remove(player.getName());
            Utils.BLUE.remove(player.getName());
        }
    }
}
