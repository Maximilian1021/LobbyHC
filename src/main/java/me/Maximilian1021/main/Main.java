package me.Maximilian1021.main;

import me.Maximilian1021.commands.*;
import me.Maximilian1021.events.goldpwsign;
import me.Maximilian1021.util.filemanager;

import me.Maximilian1021.util.tabcomplete;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Maximilian1021.events.Events;


public final class Main extends JavaPlugin{



	
	public void onEnable() {

		World world = Bukkit.getWorld("Spawn");

		Bukkit.getConsoleSender().sendMessage("----------------");
		Bukkit.getConsoleSender().sendMessage("§aName: " + getDescription().getName());
		Bukkit.getConsoleSender().sendMessage("§aVersion:" + getDescription().getVersion());
		Bukkit.getConsoleSender().sendMessage("§aAuthor: " + getDescription().getAuthors());
		Bukkit.getConsoleSender().sendMessage("§aWebsite: " + getDescription().getWebsite());

		filemanager.createLanguageFile();
		
		registerEvents();
		registerCommands();
		this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");







		Bukkit.getConsoleSender().sendMessage("§6KnotenLobby §2erfolgreich §6geladen");

		Bukkit.getConsoleSender().sendMessage("----------------");

		
	}
	
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage("§6Knotenlobby §2erfolgreich §6entladen");

	}
	
	public void registerCommands() {
		getCommand("Spawn").setExecutor(new cmdSpawn());
		getCommand("Help").setExecutor(new cmdHelp());
		getCommand("GM").setExecutor(new cmdGM());
		getCommand("pw").setExecutor(new cmdpw());
		getCommand("gold").setExecutor(new cmdGold());
		getCommand("fly").setExecutor(new cmdFly());
		getCommand("build").setExecutor(new cmdBuild());
		getCommand("Butils").setExecutor(new cmdButils());
		getCommand("Butils").setTabCompleter(new tabcomplete());
		getCommand("Laufzeit").setExecutor(new cmdLaufzeit());

	}
	
	
	public void registerEvents()
	{
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		
		pm.registerEvents(new Events(), this);
		pm.registerEvents(new goldpwsign(), this);

	
	}


}
