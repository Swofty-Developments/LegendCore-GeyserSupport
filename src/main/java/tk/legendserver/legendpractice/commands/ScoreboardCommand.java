package tk.legendserver.legendpractice.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.player.BedrockPlayer;
import tk.legendserver.legendpractice.player.LegendPlayer;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
import tk.legendserver.legendpractice.scoreboards.FFAScoreboard;
import tk.legendserver.legendpractice.scoreboards.LobbyScoreboard;
import tk.legendserver.legendpractice.utils.Util;
import tk.legendserver.legendpractice.utils.commandhandler.BaseCommand;

public final class ScoreboardCommand extends BaseCommand
{

    /*
     * In commands, do not expect there to be
     * some or any documentation. These are commands
     * that should be distinguishable via their
     * descriptions.
     */

    public ScoreboardCommand() {
        super("scoreboard", "legend.practice.scoreboard", "Allows you to modify your scoreboard.");
    }

    protected void execute(CommandSender commandSender, String[] args) {

        if(args.length < 1)
        {
            commandSender.sendMessage(ChatColor.RED + "Please provide a valid argument!");

            return;
        }

        if(!(commandSender instanceof Player))
            return;

       ILegendPlayer lPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer( ((Player) commandSender).getPlayer() );
       String scoreboard = lPlayer.getScoreboardType();

       switch(args[0])
       {
           case "off":

               lPlayer.getBukkitPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
               commandSender.sendMessage(Util.colorize("&9[SCOREBOARD DEBUG] &fDisabled your scoreboard"));

               break;

           case "set":

               if(args.length < 2)
               {
                   commandSender.sendMessage(Util.colorize("&9[SCOREBOARD DEBUG] &fPlease provide a valid scoreboard!"));
                   return;
               }

               if(scoreboard.equals(args[1]))
               {
                   commandSender.sendMessage(Util.colorize("&9[SCOREBOARD DEBUG] &fYou already have that scoreboard equipped"));
                   return;
               }

               switch(args[1])
               {
                   case LegendPlayer.LOBBY_SCOREBOARD:
                       lPlayer.setScoreboardType(LegendPlayer.LOBBY_SCOREBOARD);
                       new LobbyScoreboard(lPlayer.getBukkitPlayer());
                       commandSender.sendMessage(Util.colorize("&9[SCOREBOARD DEBUG] &fSuccessfully equipped LOBBY_SCOREBOARD"));
                       break;
                   case LegendPlayer.FFA_SCOREBOARD:
                       lPlayer.setScoreboardType(LegendPlayer.FFA_SCOREBOARD);
                       new FFAScoreboard(lPlayer.getBukkitPlayer());
                       commandSender.sendMessage(Util.colorize("&9[SCOREBOARD DEBUG] &fSuccessfully equipped LOBBY_SCOREBOARD"));
                       break;
               }

               break;
       }

    }
}