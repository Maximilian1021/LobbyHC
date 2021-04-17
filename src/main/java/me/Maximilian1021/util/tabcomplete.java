package me.Maximilian1021.util;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class tabcomplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("butils")){
            if(args.length == 1){
                List<String> tabComplete = new ArrayList<>();
                for (Player p : Bukkit.getOnlinePlayers()) {
                    String name = p.getName();

                    if(args[0].toLowerCase().equalsIgnoreCase("")){
                        tabComplete.add(name);

                    }else if (name.startsWith(args[0])) {
                        tabComplete.add(name);
                    }
                }
            }
        }
        return null;
    }
}
