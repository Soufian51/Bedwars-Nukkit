// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.listener.player;

import cn.nukkit.event.EventHandler;
import Steffen.bedwars.utils.BWPlayer;
import Steffen.bedwars.utils.BWTeam;
import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.Listener;

public class PlayerChat implements Listener
{
    @EventHandler
    public void onChat(final PlayerChatEvent event) {
        final Player player = event.getPlayer();
        final String message = event.getMessage();
        if (new BWPlayer(player).getTeam() != null) {
            event.setFormat("§8[" + new BWPlayer(player).getTeam() + "§8] " + new BWTeam(new BWPlayer(player).getTeam()).getColorCode() + player.getName() + " §8» §f" + message);
        }
        else {
            event.setFormat("§7" + player.getName() + " §8» §7" + message);
        }
    }
}
