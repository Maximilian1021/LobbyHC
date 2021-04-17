package me.Maximilian1021.commands;

import me.Maximilian1021.util.filemanager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class cmdHelp implements CommandExecutor {
    private File file = filemanager.getLangFile();
    private FileConfiguration lang = loadConfiguration(file);
    private String language = lang.getString("Language");

    private String prefix = lang.getString(language + ".Prefix");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(sender instanceof Player) {
            if(p.hasPermission("Lobby.HELP")) {
                p.sendMessage("§b§m--------------§6HILFE§b§m-------------");
                p.sendMessage("§a/spawn §7--> §6Teleportiert dich zum spawn");
                p.sendMessage("§a/Laufzeit §7--> §6Gibt dir aus wie lange du BUTils Rechte hast.");
                p.sendMessage("§a/Gold §7--> §6Informier dich über Goldspieler");
                p.sendMessage("§b§m--------------§6HILFE§b§m-------------");

            } else {
                p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
            }
        } else {
            p.sendMessage(prefix + " " + lang.getString(language + ".NoPlayer"));
        }


return false;
    }
}
