package me.Maximilian1021.commands;

import me.Maximilian1021.util.LPAPI;
import me.Maximilian1021.util.filemanager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class cmdpw implements CommandExecutor {

    public static String password = "<GEHEIM>";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


         File file = filemanager.getLangFile();
         FileConfiguration lang = loadConfiguration(file);
         String language = lang.getString("Language");

        String prefix = lang.getString(language + ".Prefix");

        final Player p = (Player)sender;


        if (p.hasPermission("LobbyHC.Gold")) {
            p.sendMessage(prefix + "§cDu bist bereits Gold-Spieler oder höher.");
        }
        if (!p.hasPermission("LobbyHC.Gold")) {
            if (args.length == 0) {
                p.sendMessage(prefix + "§c/pw <Passwort>");
                p.sendMessage(prefix + "§9Das Passwort ist in der Lobby versteckt. Finde es!");
            }
            if (args.length == 1) {
                if (args[0].equals(password)) {
                    p.sendMessage(prefix + "§aGlückwunsch, du bist jetzt Gold-Spieler.");
                    p.sendMessage(prefix + "§bAchtung - Testphase bitte bei nicht erhalten der Rolle bei Maximilian1021 melden!");
                    LPAPI.setGroup("Gold", p.getName());
                   // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ("lp user " + p.getName() + " parent set Gold"));
                    p.setPlayerListName("§6 Spieler §8| §b" + p.getName());
                }
                if (!args[0].equals(password)) {
                    p.kickPlayer(prefix +  "\n \n §7Du wurdest gekickt.\n\n§4§lFalsches Passwort! \n§cSuche in der Lobby danach!.");
                }
            }
        }


        return false;
    }
}
