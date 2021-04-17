package me.Maximilian1021.commands;

import me.Maximilian1021.util.filemanager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class cmdFly implements CommandExecutor {

    private File file = filemanager.getLangFile();
    private FileConfiguration lang = loadConfiguration(file);
    private String language = lang.getString("Language");

    private String prefix = lang.getString(language + ".Prefix");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (p.hasPermission("Lobby.fly.self")) {
                    if (!p.getAllowFlight()) {

                        p.setAllowFlight(true);
                        p.sendMessage(prefix + " " + lang.getString(language + ".FlyOn"));
                    } else {
                        p.setAllowFlight(false);
                        p.sendMessage(prefix + " " + lang.getString(language + ".FlyOff"));
                    }
                } else {
                    p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                }
                return true;

            } else if (args.length == 1) {
                if (p.hasPermission("Lobby.fly.others")) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        if (!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            p.sendMessage(prefix + " " + lang.getString(language + ".FlyOn"));
                            return true;
                        } else {

                            target.setAllowFlight(false);
                            p.sendMessage(prefix + " " + lang.getString(language + ".FlyOff"));
                            return true;
                        }
                    } else {
                        p.sendMessage(prefix + " " + lang.getString(language + ".NotOn"));
                        return true;
                    }
                } else {
                    p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                    return true;
                }
            } else {
                p.sendMessage("USAGE /FLY <Player>");
                return true;
            }
        } else {
            sender.sendMessage(prefix + lang.getString(language + ".NoPlayer"));
            return true;
        }


    }
}

