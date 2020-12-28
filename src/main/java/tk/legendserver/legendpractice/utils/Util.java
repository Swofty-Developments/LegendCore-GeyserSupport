package tk.legendserver.legendpractice.utils;

import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.LegendPractice;

public class Util
{

    // Util:
    // Contains useful static methods to be used in the plugin.

    // castMessage(Player player, String message)
    // Sends a message to a player with the plugin prefix already attached.
    public static void castMessage(Player player, String message)
    {
        if(player == null)
            return;

        if(message == null)
            return;

        String finalMessage = LegendPractice.HEADER + " " + message;
        player.sendMessage(finalMessage);
    }

    public static String colorize(String message)
    {
        return message.replace("&", "§");
    }


}