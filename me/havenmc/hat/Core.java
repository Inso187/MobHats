package me.havenmc.hat;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.havenmc.hat.utils.Colour;
import me.havenmc.hat.utils.armor.ArmorListener;
import me.havenmc.hat.utils.Colour;
import me.havenmc.listeners.Interact;
import me.havenmc.listeners.WearingHat;

public class Core extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);

		Bukkit.getConsoleSender().sendMessage(Colour.format("&8[&d&nMobHats&8] &a&nEnabled"));
		Bukkit.getConsoleSender().sendMessage(Colour.format("&8[&d&nMobHats&8] &aThanks for buying!"));
		registerConfig();
		this.getServer().getPluginManager().registerEvents(this, this);

		registerListeners();
		registerCMD();

	}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Colour.format("&8[&d&nMobHats&8] &c&nDisabled"));
		PluginDescriptionFile plug = getDescription();
		Logger logger = getLogger();
		logger.info(plug.getName() + " " + plug.getVersion() + " has been unloaded successfully.");
	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public void registerListeners() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Interact(this), this);
		pm.registerEvents(new WearingHat(this), this);
		getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
	}

	public void registerCMD() {

	}

	{

	}
}
