package me.Maximilian1021.commands;

import me.Maximilian1021.util.LPAPI;
import me.Maximilian1021.util.filemanager;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class cmdBuild implements CommandExecutor {

    public ArrayList<Player> build = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        File file = filemanager.getLangFile();
        FileConfiguration lang = loadConfiguration(file);
        String language = lang.getString("Language");

        String prefix = lang.getString(language + ".Prefix");

        if (p.hasPermission("Lobby.Build")) {
            if (args.length == 0) {
                if (build.contains(p)) {
                    build.remove(p);
                    p.setGameMode(GameMode.ADVENTURE);
                    LPAPI.remPerm("Lobby.AS", p.getName());
                    LPAPI.remPerm("Lobby.Build.Break", p.getName());
                    LPAPI.remPerm("Lobby.Build.Place", p.getName());
                    p.sendMessage(prefix + "§bDu hast den Bau-Modus verlassen");
                } else {
                    build.add(p);
                    p.setGameMode(GameMode.CREATIVE);
                    LPAPI.addPerm("Lobby.AS", p.getName());
                    LPAPI.addPerm("Lobby.Build.Break", p.getName());
                    LPAPI.addPerm("Lobby.Build.Place", p.getName());
                    p.sendMessage(prefix + "§b Du hast den Bau-Modus aktiviert.");
                }
            }
        } else {
            p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
        }
        return false;
    }
}
