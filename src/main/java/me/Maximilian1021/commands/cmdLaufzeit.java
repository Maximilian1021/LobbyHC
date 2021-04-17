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
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class cmdLaufzeit implements CommandExecutor {

    private File file = filemanager.getLangFile();
    private FileConfiguration lang = loadConfiguration(file);
    private String language = lang.getString("Language");

    private String prefix = lang.getString(language + ".Prefix");


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player))
            return false;
        Player p = (Player) sender;

        Timestamp endTime = LPAPI.getTimeEnd("BUtils.use", p.getName());

        if (endTime == null)
            return false;

        Duration dur = Duration.between(Instant.now(), endTime.toInstant());

        float seconds = dur.toMillis() / 1000;

        int days = 0;
        int hours = 0;
        int minutes;


        while (seconds > 60 * 60 * 24) {
            days++;
            seconds -= 60 * 60 * 24;
        }

        while (seconds > 60 * 60) {
            hours++;
            seconds -= 60 * 60;
        }

        minutes = (int) (seconds / 60);

        String difference = days + " days : " + hours + " hours " + minutes + " minutes";
        String difference1 = days + " Tage und " + hours + " Stunden";


        p.sendMessage(prefix + "§b Du kannst BUtils noch §c§n" + difference1 + "§r §bTage verwenden");

        return false;
    }
}