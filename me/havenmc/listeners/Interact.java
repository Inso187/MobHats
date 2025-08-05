package me.havenmc.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.havenmc.hat.Core;
import me.havenmc.hat.utils.Colour;
import net.minecraft.server.v1_8_R3.Item;

public class Interact implements Listener {

	Core plugin;

	public Interact(Core instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void PlayerInteract(PlayerInteractEvent e) {

		if (!(e.hasBlock())) {
			return;
		}

		if (e.getClickedBlock().getType() == Material.CAULDRON) {
			Player p = e.getPlayer();
			openGMGui(p);
			e.setCancelled(true);
			
		}
		

	}

	private void openGMGui(Player p) {
		FileConfiguration config = this.plugin.getConfig();
		Inventory inv = Bukkit.createInventory(null, 36, Colour.format(config.getString("HeadCauldronGUI")));

		// red glass
		ItemStack rglass = new ItemStack(Material.valueOf(config.getString("GlassPaneItem.material")), 1,
				DyeColor.valueOf(config.getString("GlassPaneItem.dyecolor")).getData());
		ItemMeta rglassMeta = rglass.getItemMeta();

		rglassMeta.setDisplayName(Colour.format(config.getString("GlassPaneItem.displayname")));
		ArrayList<String> rglassLore = new ArrayList<String>();

		for (String s : config.getStringList("GlassPaneItem.lore")) {
			rglassLore.add(Colour.format(s));
		}

		rglassMeta.setLore(rglassLore);
		rglass.setItemMeta(rglassMeta);

		inv.setItem(0, rglass);
		inv.setItem(1, rglass);
		inv.setItem(7, rglass);
		inv.setItem(8, rglass);
		inv.setItem(9, rglass);
		inv.setItem(17, rglass);
		inv.setItem(28, rglass);
		inv.setItem(18, rglass);
		inv.setItem(25, rglass);
		inv.setItem(26, rglass);
		inv.setItem(27, rglass);
		inv.setItem(29, rglass);
		inv.setItem(30, rglass);
		inv.setItem(31, rglass);
		inv.setItem(32, rglass);
		inv.setItem(33, rglass);
		inv.setItem(34, rglass);
		inv.setItem(35, rglass);
		inv.setItem(2, rglass);
		inv.setItem(3, rglass);
		inv.setItem(5, rglass);
		inv.setItem(23, rglass);
		inv.setItem(4, rglass);
		inv.setItem(6, rglass);
		inv.setItem(12, rglass);
		inv.setItem(21, rglass);
		inv.setItem(22, rglass);
		inv.setItem(24, rglass);

		// ender of eye

//		ItemStack spacer = new ItemStack(Material.valueOf(config.getString("Spacer.material")), 1,
//				DyeColor.valueOf(config.getString("Spacer.dyecolor")).getData());
//		ItemMeta spacerMeta = spacer.getItemMeta();
//
//		spacerMeta.setDisplayName(Colour.format(config.getString("Spacer.displayname")));
//		ArrayList<String> spacerLore = new ArrayList<String>();
//
//		for (String s : config.getStringList("Spacer.lore")) {
//			spacerLore.add(Colour.format(s));
//		}
//
//		rglassMeta.setLore(spacerLore);
//		spacer.setItemMeta(spacerMeta);//
//
//		inv.setItem(2, spacer);
//		inv.setItem(4, spacer);
//		inv.setItem(6, spacer);
//		inv.setItem(12, spacer);
//		inv.setItem(21, spacer);
//		inv.setItem(22, spacer);
//		inv.setItem(24, spacer);

		// Nether star

//		ItemStack netherstar = new ItemStack(Material.valueOf(config.getString("NetherStar.material")), 1,
//				DyeColor.valueOf(config.getString("NetherStar.dyecolor")).getData());
//		ItemMeta netherstarMeta = netherstar.getItemMeta();
//
//		netherstarMeta.setDisplayName(Colour.format(config.getString("NetherStar.displayname")));
//		ArrayList<String> netherstarLore = new ArrayList<String>();
//
//		for (String s : config.getStringList("NetherStar.lore")) {
//			netherstarLore.add(Colour.format(s));
//		}
//
//		netherstarMeta.setLore(netherstarLore);  
//		netherstar.setItemMeta(netherstarMeta);
//
//		inv.setItem(3, netherstar);
//		inv.setItem(5, netherstar);
//		inv.setItem(23, netherstar);

		// IRON Golem

		ItemStack ig = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta igMeta = (SkullMeta) ig.getItemMeta();
		igMeta.setOwner("MHF_Golem");

		igMeta.setDisplayName(Colour.format(config.getString("IGC.displayname")));

		ArrayList<String> igLore = new ArrayList<String>();

		for (String s : config.getStringList("IGC.lore")) {
			igLore.add(Colour.format(s));
		}

		igMeta.setLore(igLore);
		ig.setItemMeta(igMeta);

		inv.setItem(11, ig);

		// Chicken

		ItemStack chicken = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta chickenMeta = (SkullMeta) chicken.getItemMeta();
		chickenMeta.setOwner("MHF_Chicken");

		chickenMeta.setDisplayName(Colour.format(config.getString("ChickenC.displayname")));

		ArrayList<String> chickenLore = new ArrayList<String>();

		for (String s : config.getStringList("ChickenC.lore")) {
			chickenLore.add(Colour.format(s));
		}

		chickenMeta.setLore(chickenLore);
		chicken.setItemMeta(chickenMeta);
		inv.setItem(13, chicken);

		// Ocelot

		ItemStack ocelot = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta ocelotMeta = (SkullMeta) ocelot.getItemMeta();
		ocelotMeta.setOwner("MHF_Ocelot");

		ocelotMeta.setDisplayName(Colour.format(config.getString("OcelotC.displayname")));

		ArrayList<String> ocelotLore = new ArrayList<String>();

		for (String s : config.getStringList("OcelotC.lore")) {
			ocelotLore.add(Colour.format(s));
		}

		ocelotMeta.setLore(ocelotLore);
		ocelot.setItemMeta(ocelotMeta);

		inv.setItem(15, ocelot);

		p.openInventory(inv);

		// Zombie

		ItemStack zombie = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta zombieMeta = (SkullMeta) zombie.getItemMeta();
		zombieMeta.setOwner("MHF_Zombie");

		zombieMeta.setDisplayName(Colour.format(config.getString("ZombieC.displayname")));

		ArrayList<String> zombieLore = new ArrayList<String>();

		for (String s : config.getStringList("ZombieC.lore")) {
			zombieLore.add(Colour.format(s));
		}

		zombieMeta.setLore(zombieLore);
		zombie.setItemMeta(zombieMeta);

		inv.setItem(12, zombie);

		p.openInventory(inv);

		// Squid

		ItemStack squid = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta squidMeta = (SkullMeta) squid.getItemMeta();
		squidMeta.setOwner("MHF_Squid");

		squidMeta.setDisplayName(Colour.format(config.getString("SquidC.displayname")));

		ArrayList<String> squidLore = new ArrayList<String>();

		for (String s : config.getStringList("SquidC.lore")) {
			squidLore.add(Colour.format(s));
		}

		squidMeta.setLore(squidLore);
		squid.setItemMeta(squidMeta);

		inv.setItem(14, squid);

		p.openInventory(inv);

		// Rabbit

		ItemStack rabbit = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta rabbitMeta = (SkullMeta) rabbit.getItemMeta();
		rabbitMeta.setOwner("MHF_Rabbit");

		rabbitMeta.setDisplayName(Colour.format(config.getString("RabbitC.displayname")));

		ArrayList<String> rabbitLore = new ArrayList<String>();

		for (String s : config.getStringList("RabbitC.lore")) {
			rabbitLore.add(Colour.format(s));
		}

		rabbitMeta.setLore(rabbitLore);
		rabbit.setItemMeta(rabbitMeta);

		inv.setItem(16, rabbit);

		p.openInventory(inv);

		// Wither Skeleton

		ItemStack witherskeleton = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta witherskeletonMeta = (SkullMeta) witherskeleton.getItemMeta();
		witherskeletonMeta.setOwner("MHF_WSkeleton");

		witherskeletonMeta.setDisplayName(Colour.format(config.getString("WitherSkeletonC.displayname")));

		ArrayList<String> witherskeletonLore = new ArrayList<String>();

		for (String s : config.getStringList("WitherSkeletonC.lore")) {
			witherskeletonLore.add(Colour.format(s));
		}

		witherskeletonMeta.setLore(witherskeletonLore);
		witherskeleton.setItemMeta(witherskeletonMeta);

		inv.setItem(10, witherskeleton);

		// Blaze

		ItemStack blaze = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta blazeMeta = (SkullMeta) blaze.getItemMeta();
		blazeMeta.setOwner("MHF_Blaze");

		blazeMeta.setDisplayName(Colour.format(config.getString("BlazeC.displayname")));

		ArrayList<String> blazeLore = new ArrayList<String>();

		for (String s : config.getStringList("BlazeC.lore")) {
			blazeLore.add(Colour.format(s));
		}

		blazeMeta.setLore(blazeLore);
		blaze.setItemMeta(blazeMeta);

		inv.setItem(20, blaze);

		// Wolf

		ItemStack wolf = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta wolfMeta = (SkullMeta) blaze.getItemMeta();
		wolfMeta.setOwner("MHF_Wolf");

		wolfMeta.setDisplayName(Colour.format(config.getString("WolfC.displayname")));

		ArrayList<String> wolfLore = new ArrayList<String>();

		for (String s : config.getStringList("WolfC.lore")) {
			wolfLore.add(Colour.format(s));
		}

		wolfMeta.setLore(wolfLore);
		wolf.setItemMeta(wolfMeta);

		inv.setItem(19, wolf);

	}

	@EventHandler
	public void onInventoryCLICK(InventoryClickEvent e) {
		FileConfiguration config = this.plugin.getConfig();

		if (e.getInventory().getName().equalsIgnoreCase(Colour.format(config.getString("HeadCauldronGUI")))) {

			Player p = (Player) e.getWhoClicked();

			e.setCancelled(true);

			if (e.getCurrentItem() == null) {
				return;
			}

			switch (e.getCurrentItem().getType()) {
			case SKULL_ITEM:

				p.closeInventory();
				openinvNetherStar(p);

				break;
			case AIR:
				return;
			default:
				return;
			}
			return;
		} else {
			return;
		}

	}

	@EventHandler
	public void onInventoryCLICK2(InventoryClickEvent e) {
		FileConfiguration config = this.plugin.getConfig();

		if (e.getInventory().getName().equalsIgnoreCase(Colour.format(config.getString("DepositHeadsGUI")))) {
			Player p = (Player) e.getWhoClicked();

			if (e.getCurrentItem() == null) {
				return;
			}

			switch (e.getCurrentItem().getType()) {
			case STAINED_GLASS_PANE:

				e.setCancelled(true);

				if (e.getCurrentItem().getItemMeta().getDisplayName()
						.equalsIgnoreCase(Colour.format(config.getString("HeadDepositConfirm.displayname")))) {
					
					// chicken
					ItemStack chicken = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta chickenMeta = (SkullMeta) chicken.getItemMeta();
					chickenMeta.setOwner("MHF_Chicken");

					chicken.setItemMeta(chickenMeta);

					// ig
					ItemStack ig = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta igMeta = (SkullMeta) ig.getItemMeta();
					igMeta.setOwner("MHF_Golem");
					ig.setItemMeta(igMeta);

					// ocelot

					ItemStack ocelot = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta ocelotMeta = (SkullMeta) ocelot.getItemMeta();
					ocelotMeta.setOwner("MHF_Ocelot");

					ocelot.setItemMeta(ocelotMeta);

					// zombie

					ItemStack zombie = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta zombieMeta = (SkullMeta) zombie.getItemMeta();
					zombieMeta.setOwner("MHF_Zombie");

					zombie.setItemMeta(zombieMeta);

					// squid

					ItemStack squid = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta squidMeta = (SkullMeta) squid.getItemMeta();
					squidMeta.setOwner("MHF_Squid");

					squid.setItemMeta(squidMeta);

					// rabbit

					ItemStack rabbit = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta rabbitMeta = (SkullMeta) rabbit.getItemMeta();
					rabbitMeta.setOwner("MHF_Rabbit");

					rabbit.setItemMeta(rabbitMeta);

					// wither skeleton

					ItemStack witherskeleton = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta witherskeletonMeta = (SkullMeta) witherskeleton.getItemMeta();
					witherskeletonMeta.setOwner("MHF_WSkeleton");

					witherskeleton.setItemMeta(witherskeletonMeta);

					// blaze

					ItemStack blaze = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta blazeMeta = (SkullMeta) blaze.getItemMeta();
					blazeMeta.setOwner("MHF_Blaze");

					blaze.setItemMeta(blazeMeta);

					// wolf

					ItemStack wolf = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
					SkullMeta wolfMeta = (SkullMeta) wolf.getItemMeta();
					wolfMeta.setOwner("MHF_Wolf");

					wolf.setItemMeta(wolfMeta);

					if (e.getInventory().getItem(3) == null) {
						for (ItemStack i : e.getInventory().getContents()) {
							if (i != null) {
								if (i.getType() != Material.STAINED_GLASS_PANE) {
									p.getWorld().dropItemNaturally(p.getLocation(), i);

								}

							}
						}
						p.closeInventory();
						p.sendMessage(Colour.format(config.getString("NotItemOrNotEnough")));
						return;
					}

					if (!(e.getInventory().getItem(3).hasItemMeta())) {
						for (ItemStack i : e.getInventory().getContents()) {
							if (i != null) {
								if (i.getType() != Material.STAINED_GLASS_PANE) {
									p.getWorld().dropItemNaturally(p.getLocation(), i);
								}

							}
						}
						p.closeInventory();
						p.sendMessage(Colour.format(config.getString("NotItemOrNotEnough")));
						return;

					}

					if ((e.getInventory().getItem(3).getItemMeta().getDisplayName()
							.equalsIgnoreCase(Colour.format(config.getString("ChickenHead")))
							&& e.getInventory().contains(Material.SKULL_ITEM, 1000)

							|| (e.getInventory().getItem(3).getItemMeta().getDisplayName()
									.equalsIgnoreCase(Colour.format(config.getString("IronGolemHead")))
									&& e.getInventory().contains(Material.SKULL_ITEM, 1000))

							|| (e.getInventory().getItem(3).getItemMeta().getDisplayName()
									.equalsIgnoreCase(Colour.format(config.getString("OcelotHead")))
									&& e.getInventory().contains(Material.SKULL_ITEM, 1000)))

							|| (e.getInventory().getItem(3).getItemMeta().getDisplayName()
									.equalsIgnoreCase(Colour.format(config.getString("ZombieHead")))
									&& e.getInventory().contains(Material.SKULL_ITEM, 1000))

							|| (e.getInventory().getItem(3).getItemMeta().getDisplayName()
									.equalsIgnoreCase(Colour.format(config.getString("SquidHead")))
									&& e.getInventory().contains(Material.SKULL_ITEM, 1000))

							|| (e.getInventory().getItem(3).getItemMeta().getDisplayName()
									.equalsIgnoreCase(Colour.format(config.getString("RabbitHead")))
									&& e.getInventory().contains(Material.SKULL_ITEM, 1000))

							|| (e.getInventory().getItem(3).getItemMeta().getDisplayName()
									.equalsIgnoreCase(Colour.format(config.getString("WitherSkeletonHead")))
									&& e.getInventory().contains(Material.SKULL_ITEM, 1000))

							|| (e.getInventory().getItem(3).getItemMeta().getDisplayName()
									.equalsIgnoreCase(Colour.format(config.getString("BlazeHead")))
									&& e.getInventory().contains(Material.SKULL_ITEM, 1000))
							|| (e.getInventory().getItem(3).getItemMeta().getDisplayName()
									.equalsIgnoreCase(Colour.format(config.getString("WolfHead")))
									&& e.getInventory().contains(Material.SKULL_ITEM, 1000))) {

						String msg = config.getString("GiveHat");

						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("ChickenHead")))) {
							p.closeInventory();

							msg = msg.replaceAll("%head%", "chicken");

							p.sendMessage(Colour.format(msg));

							chicken = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							chickenMeta = (SkullMeta) chicken.getItemMeta();
							chickenMeta.setOwner("MHF_Chicken");

							chickenMeta.setDisplayName(Colour.format(config.getString("Chicken.displayname")));

							ArrayList<String> chickenLore = new ArrayList<String>();

							for (String s : config.getStringList("Chicken.lore")) {
								chickenLore.add(Colour.format(s));
							}

							chickenMeta.setLore(chickenLore);
							chicken.setItemMeta(chickenMeta);

							p.getInventory().addItem(chicken);

							return;
						}

						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("IronGolemHead")))) {
							p.closeInventory();

							msg = msg.replaceAll("%head%", "iron golem");

							p.sendMessage(Colour.format(msg));

							ig = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							igMeta = (SkullMeta) ig.getItemMeta();
							igMeta.setOwner("MHF_Golem");

							igMeta.setDisplayName(Colour.format(config.getString("IG.displayname")));

							ArrayList<String> igLore = new ArrayList<String>();

							for (String s : config.getStringList("IG.lore")) {
								igLore.add(Colour.format(s));
							}

							igMeta.setLore(igLore);
							ig.setItemMeta(igMeta);

							p.getInventory().addItem(ig);

							return;
						}

						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("OcelotHead")))) {

							p.closeInventory();

							msg = msg.replaceAll("%head%", "ocelot");
							p.sendMessage(Colour.format(msg));

							ocelot = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							ocelotMeta = (SkullMeta) ocelot.getItemMeta();
							ocelotMeta.setOwner("MHF_Ocelot");

							ocelotMeta.setDisplayName(Colour.format(config.getString("Ocelot.displayname")));

							ArrayList<String> ocelotLore = new ArrayList<String>();

							for (String s : config.getStringList("Ocelot.lore")) {
								ocelotLore.add(Colour.format(s));
							}

							ocelotMeta.setLore(ocelotLore);
							ocelot.setItemMeta(ocelotMeta);

							p.getInventory().addItem(ocelot);

							return;

						}

						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("ZombieHead")))) {

							p.closeInventory();

							msg = msg.replaceAll("%head%", "zombie");
							p.sendMessage(Colour.format(msg));

							zombie = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							zombieMeta = (SkullMeta) zombie.getItemMeta();
							zombieMeta.setOwner("MHF_Zombie");

							zombieMeta.setDisplayName(Colour.format(config.getString("Zombie.displayname")));

							ArrayList<String> zombieLore = new ArrayList<String>();

							for (String s : config.getStringList("Zombie.lore")) {
								zombieLore.add(Colour.format(s));
							}

							zombieMeta.setLore(zombieLore);
							zombie.setItemMeta(zombieMeta);

							p.getInventory().addItem(zombie);

						}

						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("SquidHead")))) {

							p.closeInventory();

							msg = msg.replaceAll("%head%", "squid");
							p.sendMessage(Colour.format(msg));

							squid = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							squidMeta = (SkullMeta) squid.getItemMeta();
							squidMeta.setOwner("MHF_Squid");

							squidMeta.setDisplayName(Colour.format(config.getString("Squid.displayname")));

							ArrayList<String> squidLore = new ArrayList<String>();

							for (String s : config.getStringList("Squid.lore")) {
								squidLore.add(Colour.format(s));
							}

							squidMeta.setLore(squidLore);
							squid.setItemMeta(squidMeta);

							p.getInventory().addItem(squid);

						}

						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("RabbitHead")))) {

							p.closeInventory();

							msg = msg.replaceAll("%head%", "rabbit");
							p.sendMessage(Colour.format(msg));

							rabbit = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							rabbitMeta = (SkullMeta) rabbit.getItemMeta();
							rabbitMeta.setOwner("MHF_Rabbit");

							rabbitMeta.setDisplayName(Colour.format(config.getString("Rabbit.displayname")));

							ArrayList<String> rabbitLore = new ArrayList<String>();

							for (String s : config.getStringList("Rabbit.lore")) {
								rabbitLore.add(Colour.format(s));
							}

							rabbitMeta.setLore(rabbitLore);
							rabbit.setItemMeta(rabbitMeta);

							p.getInventory().addItem(rabbit);

						}

						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("WitherSkeletonHead")))) {

							p.closeInventory();

							msg = msg.replaceAll("%head%", "wither skeleton");
							p.sendMessage(Colour.format(msg));

							witherskeleton = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							witherskeletonMeta = (SkullMeta) witherskeleton.getItemMeta();
							witherskeletonMeta.setOwner("MHF_WSkeleton");

							witherskeletonMeta
									.setDisplayName(Colour.format(config.getString("WitherSkeleton.displayname")));

							ArrayList<String> witherskeletonLore = new ArrayList<String>();

							for (String s : config.getStringList("WitherSkeleton.lore")) {
								witherskeletonLore.add(Colour.format(s));
							}

							witherskeletonMeta.setLore(witherskeletonLore);
							witherskeleton.setItemMeta(witherskeletonMeta);

							p.getInventory().addItem(witherskeleton);

						}

						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("BlazeHead")))) {

							p.closeInventory();

							msg = msg.replaceAll("%head%", "blaze");
							p.sendMessage(Colour.format(msg));

							blaze = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							blazeMeta = (SkullMeta) blaze.getItemMeta();
							blazeMeta.setOwner("MHF_Blaze");

							blazeMeta.setDisplayName(Colour.format(config.getString("Blaze.displayname")));

							ArrayList<String> blazeLore = new ArrayList<String>();

							for (String s : config.getStringList("Blaze.lore")) {
								blazeLore.add(Colour.format(s));
							}

							blazeMeta.setLore(blazeLore);
							blaze.setItemMeta(blazeMeta);

							p.getInventory().addItem(blaze);

						}
						
						if (e.getInventory().getItem(3).getItemMeta().getDisplayName()
								.equalsIgnoreCase(Colour.format(config.getString("WolfHead")))) {

							p.closeInventory();

							msg = msg.replaceAll("%head%", "wolf");
							p.sendMessage(Colour.format(msg));

							wolf = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
							wolfMeta = (SkullMeta) wolf.getItemMeta();
							wolfMeta.setOwner("MHF_Wolf");

							wolfMeta.setDisplayName(Colour.format(config.getString("Wolf.displayname")));

							ArrayList<String> wolfLore = new ArrayList<String>();

							for (String s : config.getStringList("Wolf.lore")) {
								wolfLore.add(Colour.format(s));
							}

							wolfMeta.setLore(wolfLore);
							wolf.setItemMeta(wolfMeta);

							p.getInventory().addItem(wolf);

							return;

						}

					}
				} else {

					for (ItemStack i : e.getInventory().getContents()) {
						if (i != null) {
							if (i.getType() != Material.STAINED_GLASS_PANE) {
								p.getWorld().dropItemNaturally(p.getLocation(), i);
							}

						}
						p.closeInventory();
						p.sendMessage(Colour.format(config.getString("NotItemOrNotEnough")));
					}

				}

				break;
			default:
				break;
			}
		} else {
			return;
		}

	}

	public void openinvNetherStar(Player p) {

		FileConfiguration config = this.plugin.getConfig();
		Inventory inv = Bukkit.createInventory(null, 18, Colour.format(config.getString("DepositHeadsGUI")));

		// red glass

		ItemStack rglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.RED.getData());
		ItemMeta rglassMeta = rglass.getItemMeta();

		rglassMeta.setDisplayName(Colour.format(config.getString("Note.displayname")));
		ArrayList<String> rglassLore = new ArrayList<String>();

		for (String s : config.getStringList("Note.lore")) {
			rglassLore.add(Colour.format(s));
		}

		rglassMeta.setLore(rglassLore);
		rglass.setItemMeta(rglassMeta);

		inv.setItem(0, rglass);

		// green

		// red glass

		ItemStack gglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.LIME.getData());
		ItemMeta gglassMeta = gglass.getItemMeta();

		gglassMeta.setDisplayName(Colour.format(config.getString("HeadDepositConfirm.displayname")));
		gglass.setItemMeta(gglassMeta);

		ArrayList<String> HeadDepositConfirmLore = new ArrayList<String>();

		for (String s : config.getStringList("HeadDepositConfirm.lore")) {
			HeadDepositConfirmLore.add(Colour.format(s));
		
		gglassMeta.setLore(HeadDepositConfirmLore);
		gglass.setItemMeta(gglassMeta);
		
		inv.setItem(9, gglass);

		p.openInventory(inv);
	}

}
}
