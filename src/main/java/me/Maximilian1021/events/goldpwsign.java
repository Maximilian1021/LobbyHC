package me.Maximilian1021.events;

import me.Maximilian1021.commands.cmdpw;
import me.Maximilian1021.util.filemanager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import java.io.File;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class goldpwsign implements Listener {

    private File file = filemanager.getLangFile();
    private FileConfiguration lang = loadConfiguration(file);
    private String language = lang.getString("Language");

    private String prefix = lang.getString(language + ".Prefix");



    @EventHandler
    public void onSign(SignChangeEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("Lobby.pw.sign")) {
            if (e.getLine(0).equalsIgnoreCase("GoldPW")) {

                p.sendMessage(prefix + "§bDu hast erfolgreich das Schild gesetzt");
                e.setLine(0, "Das Passwort für");
                e.setLine(1, "Goldspieler");
                e.setLine(2, "lautet");
                e.setLine(3, "§b" + cmdpw.password);
            }

        } else {
            p.sendMessage(prefix + lang.getString(language + ".NoPerm"));


        }
    }
}
