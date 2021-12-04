// 
// Decompiled by Procyon v0.5.36
// 

package Steffen.bedwars.tasks;

import de.theamychan.scoreboard.network.ScoreboardDisplay;
import java.util.Iterator;

import Steffen.bedwars.Bedwars;
import Steffen.bedwars.utils.BWTeam;
import Steffen.bedwars.utils.Utils;
import de.theamychan.scoreboard.network.Scoreboard;
import de.theamychan.scoreboard.network.DisplaySlot;
import de.theamychan.scoreboard.api.ScoreboardAPI;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.scheduler.Task;

public class SBoardTask extends Task
{
    public void onRun(final int i) {
        for (final Player player : Server.getInstance().getOnlinePlayers().values()) {
            final Scoreboard scoreboard = ScoreboardAPI.createScoreboard();
            final ScoreboardDisplay scoreboardDisplay = scoreboard.addDisplay(DisplaySlot.SIDEBAR, "dumy", " §4§lBedwars ");
            try {
                Bedwars.scoreboards.get(player).hideFor(player);
            }
            catch (Exception ex2) {}
            if (Utils.STATUS_INGAME || Utils.STATUS_END) {
                scoreboard.hideFor(player);
                scoreboardDisplay.addLine("          §r", 1);
                int score = 2;
                for (final String list : Utils.teams) {
                    final String[] ex = list.split(":");
                    if (new BWTeam(ex[0]).getSize() > 0) {
                        scoreboardDisplay.addLine(ex[0] + "           ", score);
                    }
                    ++score;
                }
                scoreboard.showFor(player);
                Bedwars.scoreboards.put(player, scoreboard);
            }
        }
    }
}
