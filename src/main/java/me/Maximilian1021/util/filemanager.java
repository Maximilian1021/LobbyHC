package me.Maximilian1021.util;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class filemanager {
    public static void createLanguageFile() {
        File file = new File("plugins/Lobby", "LobbyLang.yml");
        YamlConfiguration lang = YamlConfiguration.loadConfiguration((File) file);
        if (!file.exists()) {
            lang.set("Language", "German");

            lang.set("German.Prefix","§f[§bLobby§f] ");
            lang.set("German.NoPerm", "§c Du hast nicht genügend Rechte dafür!");
            lang.set("German.NoPlayer", "§c Du musst ein Spieler sein um den Command auszuführen");
            lang.set("German.NotOn", "§c Dieser Speieler ist nicht online!");
            lang.set("German.TPSpawn", "§b Du wurdest zum Spawn teleportiert");
            lang.set("German.CHGCreative", "§a Dein Gamemode wurde auf §bCreative §agesetzt!");
            lang.set("German.CHGSurvival", "§a Dein Gamemode wurde auf §bSurvival §agesetzt!");
            lang.set("German.CHGAdventure", "§a Dein Gamemode wurde auf §bAdventure §agesetzt!");
            lang.set("German.CHGSpectate", "§a Dein Gamemode wurde auf §bSpectator §agesetzt!");
            lang.set("German.FlyOn", "§bFlugmodus wurde§a aktiviert");
            lang.set("German.FlyOff", "§bFlugmodus wurde§c deaktivert");

            lang.set("English.Prefix", "§f[§bLobby§f] ");
            lang.set("English.NoPerm", "§c You don't have the permission to do this!");
            lang.set("English.NoPlayer", "§c You have to be a player to use this command!");
            lang.set("English.NotOn", "§c The selected Player isn´t online!");
            lang.set("English.TPSpawn", "&bYou have been teleported to the spawn");
            lang.set("English.CHGCreative", "§a Your Gamemode has been updated to §bCreative");
            lang.set("English.CHGSurvival", "§a Your Gamemode has been updated to §bSurvival");
            lang.set("English.CHGAdventure", "§a Your Gamemode has been updated to §bAdventure");
            lang.set("English.CHGSpectate", "§a Your Gamemode has been updated to §bSpectator");
            lang.set("English.FlyOn", "§bFlymode was §aactivated");
            lang.set("English.FlyOff", "§bFlymode was §bdeactivated");


        }
        try {
            lang.save(file);
        } catch (IOException e) {
            System.out.println("Fehler in der Configuration");
            e.printStackTrace();
        }
    }

    public static File getLangFile() {
        return new File("plugins/Lobby", "LobbyLang.yml");
    }
}
