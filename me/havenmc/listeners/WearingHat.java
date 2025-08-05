package me.havenmc.listeners;

import java.util.HashMap;

import org.apache.logging.log4j.core.net.Protocol;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import me.havenmc.hat.Core;
import me.havenmc.hat.utils.Colour;
import me.havenmc.hat.utils.armor.ArmorEquipEvent;

public class WearingHat implements Listener {

	Core plugin;

	public WearingHat(Core instance) {
		this.plugin = instance;
	}

	public static HashMap<String, Boolean> ReduceFD = new HashMap<String, Boolean>();

	@EventHandler
	public void onWear(ArmorEquipEvent e) {
		FileConfiguration config = this.plugin.getConfig();
		if (e.getNewArmorPiece() != null && e.getNewArmorPiece().hasItemMeta()) {
			Player p = e.getPlayer();
			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Chicken.displayname")))) {
				ReduceFD.put(p.getName(), true);

			}

			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Ocelot.displayname")))) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 0));
			}

			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("IG.displayname")))) {
				p.setMaxHealth(23.0D);

			}
			
			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Zombie.displayname")))) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000000, 0));

			}
			
			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Squid.displayname")))) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1000000000, 0));

			}
			
			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Rabbit.displayname")))) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000000, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 0));

			}
			
			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("WitherSkeleton.displayname")))) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000000, 1));

			}
			
			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Blaze.displayname")))) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000000, 1));

			}
			
			if (e.getNewArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Wolf.displayname")))) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000000, 1));
/*				if( e.getDamager() instanceof Player ) {
					Player attacker = (Player)e.getDamager();
					attacker.removePotionEffect(PotionEffectType.REGENERATION);
*/				
				}

			}
		

		if (e.getOldArmorPiece() != null && e.getOldArmorPiece().hasItemMeta()) {
			Player p = e.getPlayer();
			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Chicken.displayname")))) {
				ReduceFD.put(p.getName(), false);
				ReduceFD.remove(p.getName());
			}

			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Ocelot.displayname")))) {
				p.removePotionEffect(PotionEffectType.SPEED);
			}

			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("IG.displayname")))) {
				p.setMaxHealth(20.0D);

			}
			
			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Zombie.displayname")))) {
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);

			}
			
			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Squid.displayname")))) {
				p.removePotionEffect(PotionEffectType.WATER_BREATHING);

			}
			
			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Rabbit.displayname")))) {
				p.removePotionEffect(PotionEffectType.JUMP);
				p.removePotionEffect(PotionEffectType.SPEED);

			}
			
			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("WitherSkeleton.displayname")))) {
				p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);

			}
			
			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Blaze.displayname")))) {
				p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);

			}
			
			if (e.getOldArmorPiece().getItemMeta().getDisplayName().equalsIgnoreCase(Colour.format(config.getString("Wolf.displayname")))) {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);

			}

		}
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if (ReduceFD.get(p.getName()) == Boolean.TRUE) {

				e.setDamage(e.getDamage() / 2);

			}
		}

		return;
	}
	
	@EventHandler
	public void onPlayerDamage1(EntityDamageEvent ed) {
		if (ed.getEntity() instanceof Player) {
			Player p = (Player) ed.getEntity();
			if (ReduceFD.get(p.getName()) == Boolean.TRUE) {

				ed.setDamage(ed.getDamage() / 2);

			}
		}

		return;

}
}
