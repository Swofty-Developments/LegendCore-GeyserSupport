package tk.legendserver.legendpractice.scoreboards;

import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.player.LegendPlayer;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;

public final class FFAScoreboard
{

    public FFAScoreboard(Player player)
    {
        sendScoreboard(player);
    }

    public void sendScoreboard(Player player)
    {
        ILegendPlayer lPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer(player);
        lPlayer.setScoreboardType(LegendPlayer.FFA_SCOREBOARD);

        BPlayerBoard board = Netherboard.instance().createBoard(player, LegendPractice.SCOREBOARDTITLE);

        // Declare Variables
        long ping = 0; // TODO: Find ping.

        // Set Lines
        board.setAll(
                "―――――――――――",
                ChatColor.GOLD + "Arena: " + ChatColor.WHITE + "%arena%",
                " ",
                ChatColor.GOLD + "Ping: " + ChatColor.WHITE + ping,
                ChatColor.GOLD + "Streak: " + ChatColor.WHITE + "%streak%",
                " ",
                ChatColor.GOLD + "Kills: " + ChatColor.WHITE + "%kills%",
                ChatColor.GOLD + "Deaths: " + ChatColor.WHITE + "%deaths%",
                "⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯",
                ChatColor.YELLOW + "@LegendServerUS"
        );
    }

    public static void update(Player player)
    {
        BPlayerBoard sb = Netherboard.instance().getBoard(player);

        if(sb == null)
            return;

        // Declare Variables
        long ping = 0; // TODO: Find ping.

        sb.set(ChatColor.GOLD + "Ping: " + ChatColor.WHITE + ping, 7);
    }

}