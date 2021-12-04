// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.block;

import cn.nukkit.event.EventHandler;
import cn.nukkit.block.Block;
import Steffen.bedwars.Bedwars;
import Steffen.bedwars.utils.BWPlayer;
import Steffen.bedwars.utils.BWTeam;
import Steffen.bedwars.utils.Utils;
import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.block.BlockBed;
import cn.nukkit.Server;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.Listener;

public class BlockBreak implements Listener
{
    @EventHandler
    public void onBreak(final BlockBreakEvent event) {
        final Player player = event.getPlayer();
        final Block block = event.getBlock();
        final int id = block.getId();
        if (player.getLevel().getName().equals(Server.getInstance().getDefaultLevel().getName()) && !player.isOp()) {
            event.setCancelled(true);
            return;
        }
        if (block instanceof BlockBed) {
            if (new BWPlayer(player).getTeam().equals(new BWTeam(new BWPlayer(player).getTeam()).getBedColor(((BlockBed)block).getDyeColor().getName()))) {
                player.sendMessage(Bedwars.prefix + "You can't destroy your own bed.");
                event.setCancelled(true);
                return;
            }
            player.sendMessage(Bedwars.prefix + "You destroyed the " + new BWTeam(new BWPlayer(player).getTeam()).getBedColor(((BlockBed)block).getDyeColor().getName()) + " §7Team's bed.");
            Server.getInstance().broadcastMessage(Bedwars.prefix + "§3" + player.getName() + " §7has destroyed the bed of " + new BWTeam(new BWPlayer(player).getTeam()).getBedColor(((BlockBed)block).getDyeColor().getName()) + "§7.");
            System.out.println(((BlockBed)block).getDyeColor().getName());
            Utils.bed_destroyed.put(new BWTeam(new BWPlayer(player).getTeam()).getBedColor(((BlockBed)block).getDyeColor().getName()), true);
            event.setDrops(new Item[0]);
        }
        else if (player.getLevel().getName().equals(Utils.map) && Utils.STATUS_INGAME) {
            if (!Utils.blocks.contains(block.getLocation())) {
                event.setCancelled(true);
            }
            else {
                Utils.blocks.remove(block.getLocation());
            }
        }
    }
}
