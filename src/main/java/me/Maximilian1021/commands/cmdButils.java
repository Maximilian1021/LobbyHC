package me.Maximilian1021.commands;

import me.Maximilian1021.util.LPAPI;
import me.Maximilian1021.util.filemanager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.time.Duration;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class cmdButils implements CommandExecutor {


    private File file = filemanager.getLangFile();
    private FileConfiguration lang = loadConfiguration(file);
    private String language = lang.getString("Language");

    private String prefix = lang.getString(language + ".Prefix");

    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("Lobby.BUtils")) {
                if (args.length == 1) {
                    //target Player
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    long dur = 31 * 24 * 60 * 60;
                    // LPAPI.addPermTime("BUtils.use", target.getName(), Duration.ofDays(10));

                    //ALERT! NEVER AGAIN FUCKER!
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + target.getName() + " permission settemp BUtils.use true 21d");

                    target.sendMessage(prefix + "§bDu hast nun §c21 Tage §r§bZugriff auf die BUtils Servereinstellungen!!");
                    player.sendMessage(prefix + "§bDu hast §a" + target.getName() + "§r§b erfolgreich 21 Tage BUtils Rechte gegeben.!");
                } else {
                    sender.sendMessage(prefix + "§cArgumenten Fehler! USAGE: /BUtils <Playername>");
                }
            } else {
                player.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                return false; //If the code does if statement does not pass, alway return false.
            }
            return false;
        } else {
            sender.sendMessage(prefix + "§cDieser Command kann nur von einem Spieler ausgeführt werden!");
        }

        return false;
    }
}








