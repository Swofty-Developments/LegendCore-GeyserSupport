package tk.legendserver.legendpractice.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tk.legendserver.legendpractice.player.LegendPlayer;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
import tk.legendserver.legendpractice.scoreboards.FFAScoreboard;
import tk.legendserver.legendpractice.scoreboards.LobbyScoreboard;

public final class ScoreboardUpdateTask extends BukkitRunnable
{

    @Override
    public void run()
    {

        for(Player player : Bukkit.getOnlinePlayers())
        {
            if(player == null)
                return;

            ILegendPlayer lPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer(player);
            if(lPlayer.getScoreboardType() == null)
            {
                return;
            }

            switch(lPlayer.getScoreboardType())
            {
                case LegendPlayer.LOBBY_SCOREBOARD:
                    LobbyScoreboard.update(player);
                    break;
                case LegendPlayer.FFA_SCOREBOARD:
                    FFAScoreboard.update(player);
                    break;
            }
        }

    }
}