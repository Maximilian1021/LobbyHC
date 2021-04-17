package me.Maximilian1021.commands;

import me.Maximilian1021.util.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdNavigation implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (player.getInventory().contains(utils.getNavigator())) {
                    player.getInventory().clear();
                } else {
                    player.getInventory().clear();
                    player.getInventory().addItem(utils.getNavigator());
                }
            }
            return true;
        }
    }

