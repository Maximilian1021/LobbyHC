package me.Maximilian1021.commands;

import me.Maximilian1021.util.filemanager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class cmdSpawn implements CommandExecutor {

    private final File file = filemanager.getLangFile();
    private final FileConfiguration lang = loadConfiguration(file);
    private final String language = lang.getString("Language");
    private final String prefix = lang.getString(language + ".Prefix");

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        World world = Bukkit.getWorld("world");
        Location loc = new Location(world, 258.5, 204, -62.5);
        if (sender instanceof Player) {
            if (p.hasPermission("Lobby.Spawn")) {

                p.teleport(loc);
                p.sendMessage(prefix + (lang.getString(language + ".TPSpawn")));
            } else {
                p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                return false;
            }
        } else {

            p.sendMessage(prefix + " " + lang.getString(language + ".NoPlayer"));

        }
        return false;
    }

}
