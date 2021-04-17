package me.Maximilian1021.commands;


import me.Maximilian1021.util.filemanager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

import static org.bukkit.configuration.file.YamlConfiguration.*;


public class cmdGM implements CommandExecutor {

    private File file = filemanager.getLangFile();
    private FileConfiguration lang = loadConfiguration(file);
    private String language = lang.getString("Language");

    private String prefix = lang.getString(language + ".Prefix");

    private String gm(String gm) {
        return lang.getString(language + ".CHG" + gm);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            int str;
            try {
                str = Integer.parseInt(args[0]);
            } catch (Exception e) {
                p.sendMessage(prefix + " §b/gamemode <GAMEMODE>");
                return false;
            }
            if (args.length == 1) {
                if (p.hasPermission("Gamemode.gm.self")) {
                    switch (str) {
                        case 0:
                            if (p.hasPermission("Gamemode.self.survival")) {
                                p.setGameMode(GameMode.SURVIVAL);
                                p.sendMessage(prefix + " " + gm("Survival"));
                            } else {
                                p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                            }
                            break;
                        case 1:
                            if (p.hasPermission("Gamemode.gm.self.creative")) {
                                p.setGameMode(GameMode.CREATIVE);
                                p.sendMessage(prefix + " " + gm("Creative"));
                            } else {
                                p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                            }
                            break;

                        case 2:
                            if (p.hasPermission("Gamemode.gm.self.adventure")) {
                                p.setGameMode(GameMode.ADVENTURE);
                                p.sendMessage(prefix + " " + gm("Adventure"));
                            } else {
                                p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                            }
                            break;
                        case 3:
                            if (p.hasPermission("Gamemode.gm.self.spectator")) {
                                p.setGameMode(GameMode.SPECTATOR);
                                p.sendMessage(prefix + " " + gm("Spectate"));
                            } else {
                                p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                            }
                            break;
                    }

                } else {
                    p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                    return true;
                }
            } else if (args.length == 2) {
                if (p.hasPermission("Gamemode.gm.other")) {

                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        switch (str) {
                            case 0:
                                if (p.hasPermission("Gamemode.gm.other.Survival")) {
                                    target.setGameMode(GameMode.SURVIVAL);
                                    target.sendMessage(prefix + " " + gm("Survival"));
                                } else {
                                    p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                                }
                                break;
                            case 1:
                                if (p.hasPermission("Gamemode.gm.other.creative")) {
                                    target.setGameMode(GameMode.CREATIVE);
                                    target.sendMessage(prefix + " " + gm("Creative"));
                                } else {
                                    p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                                }
                                break;
                            case 2:
                                if (p.hasPermission("Gamemode.gm.other.adventure")) {
                                    target.setGameMode(GameMode.ADVENTURE);
                                    target.sendMessage(prefix + " " + gm("Adventure"));
                                } else {
                                    p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                                }
                                break;
                            case 3:
                                target.setGameMode(GameMode.SPECTATOR);
                                target.sendMessage(prefix + " " + gm("Spectate"));
                                break;
                        }

                    } else {
                        p.sendMessage(prefix + " " + lang.getString(language + ".NotOn"));
                        return true;
                    }

                } else {
                    p.sendMessage(prefix + lang.getString(language + ".NoPerm"));
                }
                return true;
            } else {
                p.sendMessage(prefix + " §a/gm <GAMEMODE> §boder §a/gm <GAMEMODE> <PLAYER> ");
                return true;
            }
        }
        return true;
    }
}
