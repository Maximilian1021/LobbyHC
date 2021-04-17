package me.Maximilian1021.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdGold implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        sender.sendMessage("§7§m                      §C§l Gold Rang §7§m                     ");;
        sender.sendMessage("");


        sender.sendMessage("§bDer §6Gold-Spieler §bbringt dir folgende §nVorteile");
        sender.sendMessage("");
        sender.sendMessage("§5- §bverschiedenste LobbyGadgets");
        sender.sendMessage("§5- §bfarbiger Spieler Rang");
        sender.sendMessage("§5- §bFarbig Schreiben in der Lobby");
        sender.sendMessage("§5- §bFliegen in der Lobby");
        sender.sendMessage("§5- §b/nv Command");

        sender.sendMessage("");
        sender.sendMessage("§bFalls dir noch ein Vorteil einfällt, melde dich bitte bei");
        sender.sendMessage("§9DC: §bMaximilian1021");
        sender.sendMessage("");
        sender.sendMessage("§7§m                      §C§l Gold Rang §7§m                     ");

        return false;
    }
}
