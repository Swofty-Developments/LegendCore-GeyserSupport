package tk.legendserver.legendpractice.scoreboards;

import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.player.LegendPlayer;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;

public final class LobbyScoreboard
{

    public LobbyScoreboard(Player player)
    {
        sendScoreboard(player);
    }

    public void sendScoreboard(Player player)
    {
        ILegendPlayer lPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer(player);
        lPlayer.setScoreboardType(LegendPlayer.LOBBY_SCOREBOARD);

        BPlayerBoard board = Netherboard.instance().createBoard(player, LegendPractice.SCOREBOARDTITLE);

        // Declare Variables
        long count = Bukkit.getServer().getOnlinePlayers().size();

        // Set Lines
        board.setAll(
                "―――――――――――",
                ChatColor.GOLD + "Rank: " + ChatColor.WHITE + "[%rank%]",
                ChatColor.GOLD + "Online: " + ChatColor.WHITE + count,
                ChatColor.GOLD + "In-Fights: " + ChatColor.WHITE + "%in-fights%",
                "⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯",
                ChatColor.GRAY + "@LegendServerUS"
        );
    }

    public static void update(Player player)
    {
        BPlayerBoard sb = Netherboard.instance().getBoard(player);

        if(sb == null)
            return;

        // Declare Variables
        long count = Bukkit.getServer().getOnlinePlayers().size();

        sb.set(ChatColor.GOLD + "Online: " + ChatColor.WHITE + count, 4);
    }

}