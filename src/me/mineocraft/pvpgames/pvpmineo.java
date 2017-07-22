package me.mineocraft.pvpgames;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class pvpmineo extends JavaPlugin{
	public void onEnable() {
		getLogger().info("ThePvPGames has been enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public void onDisable() {
		getLogger().info("ThePvPGames has been disabled!");
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		String noPermission = ("You do not have permission or required rank.");
		if (cmd.getName().equalsIgnoreCase("pg")) {
			if (args.length == 0) {
				sender
						.sendMessage(ChatColor.GREEN
								+ "ThePvPGames DEV0.3 by MineOCraftMC. Please report bugs if any!");
				return true;
			} else if (args[1] == "config") {
				if (!(sender instanceof Player)) {
					sender
							.sendMessage(ChatColor.RED
									+ "This command cannot be executed in the console!");
				} else {
					Player player = (Player) sender;
					player
							.sendMessage(ChatColor.AQUA
									+ "You may choose to configure from in-game. Usage: /pg ocnfig <class name> <Helmet, Chestplate, etc.> <Item ID, Amount, etc.> <value>");
				}
			}
		}

		else if (cmd.getName().equalsIgnoreCase("SetWizard")) {
			Player player = (Player) sender;
			if (player.hasPermission("pg.setwizard")) {
				if (args.length == 0) {
					if (!(sender instanceof Player)) {
						sender
								.sendMessage(ChatColor.RED
										+ "This command cannot be executed in the console!");
						return true;
					} else {
						player.playSound(player.getLocation(), Sound.LEVEL_UP,
								1, 1);
						ItemStack stick = new ItemStack(getConfig().getInt(
								"Wizard.Mainweapon.ID"), getConfig().getInt(
								"Wizard.Mainweapon.Amount"),
								(short) getConfig().getInt(
										"Wizard.Mainweapon.Extraint"));
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Mainweapon.Enchantmentid")),
								getConfig().getInt(
										"Wizard.Mainweapon.Enchantlevel"));
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Mainweapon.Enchantmentid2")),
								getConfig().getInt(
										"Wizard.Mainweapon.Enchantlevel2"));
						ItemStack enchant = new ItemStack(getConfig().getInt(
								"Wizard.Helmet.ID"), getConfig().getInt(
								"Wizard.Helmet.Amount"), (short) getConfig()
								.getInt("Wizard.Helmet.Extraint"));
						enchant.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Helmet.Enchantmentid")),
								getConfig()
										.getInt("Wizard.Helmet.Enchantlevel"));
						ItemStack wibody = new ItemStack(getConfig().getInt(
								"Wizard.Chestplate.ID"), getConfig().getInt(
								"Wizard.Chestplate.Amount"),
								(short) getConfig().getInt(
										"Wizard.Chestplate.Extraint"));
						wibody.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
						wibody.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Chestplate.Enchantmentid")),
								getConfig().getInt(
										"Wizard.Chestplate.Enchantlevel"));
						ItemStack wileg = new ItemStack(getConfig().getInt(
								"Wizard.Leggings.ID"), getConfig().getInt(
								"Wizard.Leggings.Amount"), (short) getConfig()
								.getInt("Wizard.Leggings.Extraint"));
						wileg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wileg.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Leggings.Enchantmentid")),
								getConfig().getInt(
										"Wizard.Leggings.Enchantlevel"));
						ItemStack wiboot = new ItemStack(getConfig().getInt(
								"Wizard.Boots.ID"), getConfig().getInt(
								"Wizard.Boots.Amount"), (short) getConfig()
								.getInt("Wizard.Boots.Extraint"));
						wiboot
								.addUnsafeEnchantment(Enchantment
										.getById(getConfig().getInt(
												"Wizard.Boots.Enchantmentid")),
										getConfig().getInt(
												"Wizard.Boots.Enchantlevel"));
						wiboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						ItemStack special = new ItemStack(Material.POTION, 50);
						ItemStack heal = new ItemStack(getConfig().getInt(
								"Wizard.Heal.ID"), getConfig().getInt(
								"Wizard.Heal.Amount"), (short) getConfig()
								.getInt("Wizard.Heal.Extraint"));
						ItemStack food = new ItemStack(getConfig().getInt(
								"Wizard.Food.ID"), getConfig().getInt(
								"Wizard.Food.Amount"));
						Potion pot = new Potion(1);
						pot.setType(PotionType.INSTANT_DAMAGE);
						pot.setSplash(true);
						pot.apply(special);
						ItemStack et1 = new ItemStack(getConfig().getInt(
								"Wizard.Extraitem1.ID"), getConfig().getInt(
								"Wizard.Extraitem1.Amount"),
								(short) getConfig().getInt(
										"Wizard.Extraitem1.Extraint"));
						ItemStack et2 = new ItemStack(getConfig().getInt(
								"Wizard.Extraitem2.ID"), getConfig().getInt(
								"Wizard.Extraitem2.Amount"),
								(short) getConfig().getInt(
										"Wizard.Extraitem1.Extraint"));
						ItemStack et3 = new ItemStack(getConfig().getInt(
								"Wizard.Extraitem3.ID"), getConfig().getInt(
								"Wizard.Extraitem3.Amount"),
								(short) getConfig().getInt(
										"Wizard.Extraitem1.Extraint"));
						PlayerInventory pi = player.getInventory();
						pi.clear();
						pi.addItem(stick);
						pi.addItem(heal);
						pi.addItem(special);
						pi.addItem(food);
						pi.addItem(et1);
						pi.addItem(et2);
						pi.addItem(et3);
						pi.setHelmet(enchant);
						pi.setChestplate(wibody);
						pi.setLeggings(wileg);
						pi.setBoots(wiboot);
						player
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						player
								.removePotionEffect(PotionEffectType.REGENERATION);
						player
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						player
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						player.removePotionEffect(PotionEffectType.SPEED);
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer().broadcastMessage(
									ChatColor.LIGHT_PURPLE + player.getName()
											+ " has chosen wizard class!");
						}
						player.sendMessage(ChatColor.BOLD
								+ "You have chosen wizard class!");
						return true;
					}
				} else if (args.length == 1) {
					if (player.hasPermission("pg.setwizard.setother")) {
						Player targetPlayer = getServer().getPlayer(args[0]);
						targetPlayer.playSound(player.getLocation(),
								Sound.LEVEL_UP, 1, 1);
						ItemStack stick = new ItemStack(getConfig().getInt(
								"Wizard.Mainweapon.ID"), getConfig().getInt(
								"Wizard.Mainweapon.Amount"),
								(short) getConfig().getInt(
										"Wizard.Mainweapon.ExtraInt"));
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Mainweapon.Enchantmentid")),
								getConfig().getInt(
										"Wizard.Mainweapon.Enchantlevel"));
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Mainweapon.Enchantmentid2")),
								getConfig().getInt(
										"Wizard.Mainweapon.Enchantlevel2"));
						ItemStack enchant = new ItemStack(getConfig().getInt(
								"Wizard.Helmet.ID"), getConfig().getInt(
								"Wizard.Helmet.Amount"), (short) getConfig()
								.getInt("Wizard.Helmet.Extraint"));
						enchant.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Helmet.Enchantmentid")),
								getConfig()
										.getInt("Wizard.Helmet.Enchantlevel"));
						ItemStack wibody = new ItemStack(getConfig().getInt(
								"Wizard.Chestplate.ID"), getConfig().getInt(
								"Wizard.Chestplate.Amount"),
								(short) getConfig().getInt(
										"Wizard.Chestplate.Extraint"));
						wibody.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
						wibody.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Chestplate.Enchantmentid")),
								getConfig().getInt(
										"Wizard.Chestplate.Enchantlevel"));
						ItemStack wileg = new ItemStack(getConfig().getInt(
								"Wizard.Leggings.ID"), getConfig().getInt(
								"Wizard.Leggings.Amount"), (short) getConfig()
								.getInt("Wizard.Leggings.Extraint"));
						wileg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wileg.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Wizard.Leggings.Enchantmentid")),
								getConfig().getInt(
										"Wizard.Leggings.Enchantlevel"));
						ItemStack wiboot = new ItemStack(getConfig().getInt(
								"Wizard.Boots.ID"), getConfig().getInt(
								"Wizard.Boots.Amount"), (short) getConfig()
								.getInt("Wizard.Boots.Extraint"));
						wiboot
								.addUnsafeEnchantment(Enchantment
										.getById(getConfig().getInt(
												"Wizard.Boots.Enchantmentid")),
										getConfig().getInt(
												"Wizard.Boots.Enchantlevel"));
						wiboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						ItemStack special = new ItemStack(Material.POTION, 50);
						ItemStack heal = new ItemStack(getConfig().getInt(
								"Wizard.Heal.ID"), getConfig().getInt(
								"Wizard.Heal.Amount"), (short) getConfig()
								.getInt("Wizard.Heal.Extraint"));
						ItemStack food = new ItemStack(getConfig().getInt(
								"Wizard.Food.ID"), getConfig().getInt(
								"Wizard.Food.Amount"));
						Potion pot = new Potion(1);
						pot.setType(PotionType.INSTANT_DAMAGE);
						pot.setSplash(true);
						pot.apply(special);
						ItemStack et1 = new ItemStack(getConfig().getInt(
								"Wizard.Extraitem1.ID"), getConfig().getInt(
								"Wizard.Extraitem1.Amount"),
								(short) getConfig().getInt(
										"Wizard.Extraitem1.Extraint"));
						ItemStack et2 = new ItemStack(getConfig().getInt(
								"Wizard.Extraitem2.ID"), getConfig().getInt(
								"Wizard.Extraitem2.Amount"),
								(short) getConfig().getInt(
										"Wizard.Extraitem1.Extraint"));
						ItemStack et3 = new ItemStack(getConfig().getInt(
								"Wizard.Extraitem3.ID"), getConfig().getInt(
								"Wizard.Extraitem3.Amount"),
								(short) getConfig().getInt(
										"Wizard.Extraitem1.Extraint"));
						PlayerInventory pi = targetPlayer.getInventory();
						pi.clear();
						pi.addItem(stick);
						pi.addItem(heal);
						pi.addItem(special);
						pi.addItem(food);
						pi.addItem(et1);
						pi.addItem(et2);
						pi.addItem(et3);
						pi.setHelmet(enchant);
						pi.setChestplate(wibody);
						pi.setLeggings(wileg);
						pi.setBoots(wiboot);
						targetPlayer
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						targetPlayer
								.removePotionEffect(PotionEffectType.REGENERATION);
						targetPlayer
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						targetPlayer
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						targetPlayer.removePotionEffect(PotionEffectType.SPEED);
						player
								.sendMessage(ChatColor.BOLD
										+ "You have chosen "
										+ targetPlayer.getName()
										+ " for wizard class.");
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer()
									.broadcastMessage(
											ChatColor.LIGHT_PURPLE
													+ player.getName()
													+ " has been chosen for wizard class!");
						}
						targetPlayer
								.sendMessage(ChatColor.BOLD
										+ "You have been chosen to be in wizard class!");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + noPermission);
						return true;
					}
				}
			} else {
				sender.sendMessage(ChatColor.RED + noPermission);
				return true;
			}
		} else if (cmd.getName().equalsIgnoreCase("SetWarrior")) {
			if (args.length == 0) {
				Player player = (Player) sender;
				if (player.hasPermission("pg.setwarrior")) {
					if (!(sender instanceof Player)) {
						sender
								.sendMessage(ChatColor.RED
										+ "This command cannot be executed in the console!");
						return true;
					} else {
						player.playSound(player.getLocation(), Sound.ANVIL_USE,
								1, 1);
						ItemStack stick = new ItemStack(getConfig().getInt(
								"Warrior.Mainweapon.ID"), getConfig().getInt(
								"Warrior.Mainweapon.Amount"));
						stick.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Warrior.Mainweapon.Enchantmentid")),
								getConfig().getInt(
										"Warrior.Mainweapon.Enchantmentid"));
						ItemStack wbody = new ItemStack(getConfig().getInt(
								"Warrior.Chestplate.ID"), getConfig().getInt(
								"Warrior.Chestplate.Amount"));
						wbody.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
						wbody.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Warrior.Chestplate.Enchantmentid")),
								getConfig().getInt(
										"Warrior.Chestplate.Enchantlevel"));
						ItemStack whelm = new ItemStack(getConfig().getInt(
								"Warrior.Helmet.ID"), getConfig().getInt(
								"Warrior.Helmet.Amount"));
						whelm.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
						whelm.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Warrior.Helmet.Enchantmentid")),
								getConfig().getInt(
										"Warrior.Helmet.Enchantlevel"));
						ItemStack wleg = new ItemStack(getConfig().getInt(
								"Warrior.Leggings.ID"), getConfig().getInt(
								"Warrior.Leggings.Amount"));
						wleg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wleg.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Warrior.Leggings.Enchantmentid")),
								getConfig().getInt(
										"Warrior.Leggings.Enchantlevel"));
						ItemStack wboot = new ItemStack(getConfig().getInt(
								"Warrior.Boots.ID"), getConfig().getInt(
								"Warrior.Boots.Amount"));
						wboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wboot.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Warrior.Boots.Enchantmentid")),
								getConfig()
										.getInt("Warrior.Boots.Enchantlevel"));
						// ItemStack special = new ItemStack(Material.POTION);
						ItemStack food = new ItemStack(getConfig().getInt(
								"Warrior.Food.ID"), getConfig().getInt(
								"Warrior.Food.Amount"));
						ItemStack et1 = new ItemStack(getConfig().getInt(
								"Warrior.Extraitem1.ID"), getConfig().getInt(
								"Warrior.Extraitem1.Amount"),
								(short) getConfig().getInt(
										"Warrior.Extraitem1.Extraint"));
						// Potion pot = new Potion(1);
						// pot.setType(PotionType.STRENGTH);
						// pot.apply(special);
						ItemStack heal = new ItemStack(getConfig().getInt(
								"Warrior.Heal.ID"), getConfig().getInt(
								"Warrior.Heal.Amount"), (short) getConfig()
								.getInt("Warrior.Heal.Extraint"));
						PlayerInventory pi = player.getInventory();
						pi.clear();
						pi.addItem(stick);
						pi.setHelmet(whelm);
						pi.setChestplate(wbody);
						pi.setLeggings(wleg);
						pi.setBoots(wboot);
						// pi.addItem(special);
						pi.addItem(heal);
						pi.addItem(food);
						pi.addItem(et1);
						player
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						player
								.removePotionEffect(PotionEffectType.REGENERATION);
						player
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						player
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						player.removePotionEffect(PotionEffectType.SPEED);
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer().broadcastMessage(
									ChatColor.LIGHT_PURPLE + player.getName()
											+ " has chosen warrior class!");
						}
						player.sendMessage(ChatColor.BOLD
								+ "You have chosen warrior class!");
						return true;
					}
				} else {
					player.sendMessage(ChatColor.RED + noPermission);
					return true;
				}
			} else if (args.length == 1) {
				Player player = (Player) sender;
				if (player.hasPermission("pg.setwarrior.setother")) {
					Player targetPlayer = getServer().getPlayer(args[0]);
					targetPlayer.playSound(targetPlayer.getLocation(),
							Sound.ANVIL_USE, 1, 1);
					ItemStack stick = new ItemStack(getConfig().getInt(
							"Warrior.Mainweapon.ID"), getConfig().getInt(
							"Warrior.Mainweapon.Amount"));
					stick.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
					stick.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Warrior.Mainweapon.Enchantmentid")),
							getConfig().getInt(
									"Warrior.Mainweapon.Enchantmentid"));
					ItemStack wbody = new ItemStack(getConfig().getInt(
							"Warrior.Chestplate.ID"), getConfig().getInt(
							"Warrior.Chestplate.Amount"));
					wbody.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
					wbody.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Warrior.Chestplate.Enchantmentid")),
							getConfig().getInt(
									"Warrior.Chestplate.Enchantlevel"));
					ItemStack whelm = new ItemStack(getConfig().getInt(
							"Warrior.Helmet.ID"), getConfig().getInt(
							"Warrior.Helmet.Amount"));
					whelm.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
					whelm.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Warrior.Helmet.Enchantmentid")),
							getConfig().getInt("Warrior.Helmet.Enchantlevel"));
					ItemStack wleg = new ItemStack(getConfig().getInt(
							"Warrior.Leggings.ID"), getConfig().getInt(
							"Warrior.Leggings.Amount"));
					wleg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					wleg
							.addUnsafeEnchantment(Enchantment
									.getById(getConfig().getInt(
											"Warrior.Leggings.Enchantmentid")),
									getConfig().getInt(
											"Warrior.Leggings.Enchantlevel"));
					ItemStack wboot = new ItemStack(getConfig().getInt(
							"Warrior.Boots.ID"), getConfig().getInt(
							"Warrior.Boots.Amount"));
					wboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					wboot.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Warrior.Boots.Enchantmentid")),
							getConfig().getInt("Warrior.Boots.Enchantlevel"));
					// ItemStack special = new ItemStack(Material.POTION);
					ItemStack food = new ItemStack(getConfig().getInt(
							"Warrior.Food.ID"), getConfig().getInt(
							"Warrior.Food.Amount"));
					ItemStack et1 = new ItemStack(getConfig().getInt(
							"Warrior.Extraitem1.ID"), getConfig().getInt(
							"Warrior.Extraitem1.Amount"), (short) getConfig()
							.getInt("Warrior.Extraitem1.Extraint"));
					// Potion pot = new Potion(1);
					// pot.setType(PotionType.STRENGTH);
					// pot.apply(special);
					ItemStack heal = new ItemStack(getConfig().getInt(
							"Warrior.Heal.ID"), getConfig().getInt(
							"Warrior.Heal.Amount"), (short) getConfig().getInt(
							"Warrior.Heal.Extraint"));
					PlayerInventory pi = targetPlayer.getInventory();
					pi.clear();
					pi.addItem(stick);
					pi.setHelmet(whelm);
					pi.setChestplate(wbody);
					pi.setLeggings(wleg);
					pi.setBoots(wboot);
					// pi.addItem(special);
					pi.addItem(heal);
					pi.addItem(food);
					pi.addItem(et1);
					targetPlayer
							.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					targetPlayer
							.removePotionEffect(PotionEffectType.REGENERATION);
					targetPlayer
							.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					targetPlayer
							.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					targetPlayer.removePotionEffect(PotionEffectType.SPEED);
					if (getConfig().getString("globalclassannouce.onenable") == ("true")) {
						getServer()
								.broadcastMessage(
										ChatColor.LIGHT_PURPLE
												+ targetPlayer.getName()
												+ " has been chosen for warrior class!");
					}
					player.sendMessage(ChatColor.BOLD + "You have chosen "
							+ targetPlayer.getName() + " for warrior class.");
					targetPlayer.sendMessage(ChatColor.BOLD
							+ "You have been chosen for warrior class!");
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + noPermission);
				return true;
			}
		} else if (cmd.getName().equalsIgnoreCase("setpro")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "This command cannot be executed in the console!");
				return true;
			} else {
				if (args.length == 0) {
					Player player = (Player) sender;
					if (player.hasPermission("pg.setpro")) {
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer().broadcastMessage(
									ChatColor.LIGHT_PURPLE + player.getName()
											+ " has chosen Professional!");
						}
						player.sendMessage(ChatColor.BOLD
								+ "You have chosen Professional!");
						player
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						player
								.removePotionEffect(PotionEffectType.REGENERATION);
						player
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						player
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						ItemStack stick = new ItemStack(getConfig().getInt(
								"Pro.Mainweapon.ID"), getConfig().getInt(
								"Pro.Mainweapon.Amount"));
						stick.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Pro.Mainweapon.Enchantmentid")),
								getConfig().getInt(
										"Pro.Mainweapon.Enchantlevel"));
						ItemStack proboot = new ItemStack(getConfig().getInt(
								"Pro.Boots.ID"), getConfig().getInt(
								"Pro.Boots.Amount"));
						ItemStack probody = new ItemStack(getConfig().getInt(
								"Pro.Chestplate.ID"), getConfig().getInt(
								"Pro.Chestplate.Amount"));
						ItemStack proleg = new ItemStack(getConfig().getInt(
								"Pro.Leggings.ID"), getConfig().getInt(
								"Pro.Leggings.Amount"));
						ItemStack prohelm = new ItemStack(getConfig().getInt(
								"Pro.Helmet.ID"), getConfig().getInt(
								"Pro.Helmet.Amount"));
						ItemStack heal = new ItemStack(getConfig().getInt(
								"Pro.Heal.ID"), getConfig().getInt(
								"Pro.Heal.Amount"), (short) getConfig().getInt(
								"Pro.Heal.Extraint"));
						ItemStack food = new ItemStack(getConfig().getInt(
								"Pro.Food.ID"), getConfig().getInt(
								"Pro.Food.Amount"));
						proboot
								.addUnsafeEnchantment(Enchantment.DURABILITY,
										20);
						proboot.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Pro.Boots.Enchantmentid")),
								getConfig().getInt("Pro.Boots.Enchantlevel"));
						PlayerInventory pi = player.getInventory();
						pi.clear();
						pi.setChestplate(probody);
						pi.setLeggings(proleg);
						pi.setHelmet(prohelm);
						pi.addItem(stick);
						pi.addItem(heal);
						pi.addItem(food);
						pi.setBoots(proboot);
						return true;
					} else {
						sender.sendMessage(ChatColor.RED + noPermission);
						return true;
					}
				} else if (args.length == 1) {
					Player player = (Player) sender;
					if (player.hasPermission("pg.setpro.setother")) {
						Player targetPlayer = getServer().getPlayer(args[0]);
						player.sendMessage(ChatColor.BOLD + "You have chosen "
								+ targetPlayer.getName()
								+ " for professional class!");
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer().broadcastMessage(
									ChatColor.LIGHT_PURPLE
											+ targetPlayer.getName()
											+ " has been chosen Professional!");
						}
						targetPlayer
								.sendMessage(ChatColor.BOLD
										+ "Someone has chosen you for Professional class!");
						targetPlayer
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						targetPlayer
								.removePotionEffect(PotionEffectType.REGENERATION);
						targetPlayer
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						targetPlayer
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						ItemStack stick = new ItemStack(getConfig().getInt(
								"Pro.Mainweapon.ID"), getConfig().getInt(
								"Pro.Mainweapon.Amount"));
						stick.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						ItemStack proboot = new ItemStack(getConfig().getInt(
								"Pro.Boots.ID"), getConfig().getInt(
								"Pro.Boots.Amount"));
						ItemStack probody = new ItemStack(getConfig().getInt(
								"Pro.Chestplate.ID"), getConfig().getInt(
								"Pro.Chestplate.Amount"));
						ItemStack proleg = new ItemStack(getConfig().getInt(
								"Pro.Leggings.ID"), getConfig().getInt(
								"Pro.Leggings.Amount"));
						ItemStack prohelm = new ItemStack(getConfig().getInt(
								"Pro.Helmet.ID"), getConfig().getInt(
								"Pro.Helmet.Amount"));
						ItemStack heal = new ItemStack(getConfig().getInt(
								"Pro.Heal.ID"), getConfig().getInt(
								"Pro.Heal.Amount"), (short) getConfig().getInt(
								"Pro.Heal.Extraint"));
						ItemStack food = new ItemStack(getConfig().getInt(
								"Pro.Food.ID"), getConfig().getInt(
								"Pro.Food.Amount"));
						proboot
								.addUnsafeEnchantment(Enchantment.DURABILITY,
										20);
						proboot.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Pro.Boots.Enchantmentid")),
								getConfig().getInt("Pro.Boots.Enchantlevel"));
						PlayerInventory pi = targetPlayer.getInventory();
						pi.clear();
						pi.setChestplate(probody);
						pi.setLeggings(proleg);
						pi.setHelmet(prohelm);
						pi.addItem(stick);
						pi.addItem(heal);
						pi.addItem(food);
						pi.setBoots(proboot);
						return true;
					} else {
						sender.sendMessage(ChatColor.RED + noPermission);
						return true;
					}
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("setTroll")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "This command cannot be executed in the console!");
			} else {
				Player player = (Player) sender;
				if (args.length == 0) {
					if (player.hasPermission("pg.settroll")) {
						player
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						player
								.removePotionEffect(PotionEffectType.REGENERATION);
						player
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						player
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						player.removePotionEffect(PotionEffectType.SPEED);
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer().broadcastMessage(
									ChatColor.LIGHT_PURPLE + player.getName()
											+ " has chosen Troll!");
						}
						player.sendMessage(ChatColor.BOLD
								+ "You have chosen troll!");
						ItemStack stick = new ItemStack(getConfig().getInt(
								"Troll.Mainweapon.ID"), getConfig().getInt(
								"Troll.Mainweapon.Amount"));
						stick.addUnsafeEnchantment(Enchantment.DURABILITY, 20);
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Troll.Mainweapon.Enchantmentid")),
								getConfig().getInt(
										"Troll.Mainweapon.Enchantlevel"));
						ItemMeta stickMeta = stick.getItemMeta();
						stickMeta.setDisplayName(ChatColor.AQUA
								+ "�oHappy Trolling!");
						stick.setItemMeta(stickMeta);
						ItemStack tbody = new ItemStack(getConfig().getInt(
								"Troll.Chestplate.ID"), getConfig().getInt(
								"Troll.Chestplate.Amount"));
						tbody.addUnsafeEnchantment(Enchantment.DURABILITY, 7);
						tbody.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Troll.Chestplate.Enchantmentid")),
								getConfig().getInt(
										"Troll.Chestplate.Enchantlevel"));
						ItemStack helm = new ItemStack(getConfig().getInt(
								"Troll.Helmet.ID"), getConfig().getInt(
								"Troll.Helmet.Amount"));
						helm.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						helm
								.addUnsafeEnchantment(Enchantment
										.getById(getConfig().getInt(
												"Troll.Helmet.Enchantmentid")),
										getConfig().getInt(
												"Troll.Helmet.Enchantlevel"));
						ItemStack tleg = new ItemStack(getConfig().getInt(
								"Troll.Leggings.ID"), getConfig().getInt(
								"Troll.Leggings.Amount"));
						ItemStack tboot = new ItemStack(getConfig().getInt(
								"Troll.Boots.ID"), getConfig().getInt(
								"Troll.Boots.Amount"));
						ItemStack heal = new ItemStack(getConfig().getInt(
								"Troll.Heal.ID"), getConfig().getInt(
								"Troll.Heal.Amount"), (short) getConfig()
								.getInt("Troll.Heal.Extraint"));
						ItemMeta healMeta = heal.getItemMeta();
						healMeta.setDisplayName(ChatColor.LIGHT_PURPLE
								+ "�oCan't touch this!");
						heal.setItemMeta(healMeta);
						ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
						ItemStack special = new ItemStack(getConfig().getInt(
								"Troll.Special.ID"), getConfig().getInt(
								"Troll.Special.Amount"));
						special.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Troll.Special.Enchantmentid")),
								getConfig()
										.getInt("Troll.Special.Enchantlevel"));
						special.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Troll.Special.Enchantmentid2")),
								getConfig().getInt(
										"Troll.Special.Enchantmentlevel2"));
						ItemMeta specialMeta = special.getItemMeta();
						specialMeta.setDisplayName(ChatColor.YELLOW
								+ "�oTROLL'S HAMMER");
						special.setItemMeta(specialMeta);
						special.setDurability((short) getConfig().getInt(
								"Troll.Special.Subtractdura"));
						PlayerInventory pi = player.getInventory();
						pi.clear();
						pi.setLeggings(tleg);
						pi.setBoots(tboot);
						pi.addItem(stick);
						pi.setHelmet(helm);
						pi.setChestplate(tbody);
						pi.addItem(special);
						pi.addItem(heal);
						pi.addItem(food);
					} else {
						player.sendMessage(ChatColor.RED + noPermission);
					}
				} else if (args.length == 1) {
					if (player.hasPermission("pg.settroll.setother")) {
						Player targetPlayer = getServer().getPlayer(args[0]);
						targetPlayer
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						targetPlayer
								.removePotionEffect(PotionEffectType.REGENERATION);
						targetPlayer
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						targetPlayer
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						targetPlayer.removePotionEffect(PotionEffectType.SPEED);
						targetPlayer.sendMessage(ChatColor.BOLD
								+ "You have chosen " + targetPlayer.getName()
								+ " for troll class!");
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer().broadcastMessage(
									ChatColor.LIGHT_PURPLE
											+ targetPlayer.getName()
											+ " has been chosen Troll!");
						}
						targetPlayer.sendMessage(ChatColor.BOLD
								+ "Someone has you chosen you for troll!");
						ItemStack stick = new ItemStack(getConfig().getInt(
								"Troll.Mainweapon.ID"), getConfig().getInt(
								"Troll.Mainweapon.Amount"));
						stick.addUnsafeEnchantment(Enchantment.DURABILITY, 20);
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Troll.Mainweapon.Enchantmentid")),
								getConfig().getInt(
										"Troll.Mainweapon.Enchantlevel"));
						ItemMeta stickMeta = stick.getItemMeta();
						stickMeta.setDisplayName(ChatColor.AQUA
								+ "�oHappy Trolling!");
						stick.setItemMeta(stickMeta);
						ItemStack tbody = new ItemStack(getConfig().getInt(
								"Troll.Chestplate.ID"), getConfig().getInt(
								"Troll.Chestplate.Amount"));
						tbody.addUnsafeEnchantment(Enchantment.DURABILITY, 7);
						tbody.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Troll.Chestplate.Enchantmentid")),
								getConfig().getInt(
										"Troll.Chestplate.Enchantlevel"));
						ItemStack helm = new ItemStack(getConfig().getInt(
								"Troll.Helmet.ID"), getConfig().getInt(
								"Troll.Helmet.Amount"));
						helm.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						helm
								.addUnsafeEnchantment(Enchantment
										.getById(getConfig().getInt(
												"Troll.Helmet.Enchantmentid")),
										getConfig().getInt(
												"Troll.Helmet.Enchantlevel"));
						ItemStack tleg = new ItemStack(getConfig().getInt(
								"Troll.Leggings.ID"), getConfig().getInt(
								"Troll.Leggings.Amount"));
						ItemStack tboot = new ItemStack(getConfig().getInt(
								"Troll.Boots.ID"), getConfig().getInt(
								"Troll.Boots.Amount"));
						ItemStack heal = new ItemStack(getConfig().getInt(
								"Troll.Heal.ID"), getConfig().getInt(
								"Troll.Heal.Amount"), (short) getConfig()
								.getInt("Troll.Heal.Extraint"));
						ItemMeta healMeta = heal.getItemMeta();
						healMeta.setDisplayName(ChatColor.LIGHT_PURPLE
								+ "�oCan't touch this!");
						heal.setItemMeta(healMeta);
						ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
						ItemStack special = new ItemStack(getConfig().getInt(
								"Troll.Special.ID"), getConfig().getInt(
								"Troll.Special.Amount"));
						special.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Troll.Special.Enchantmentid")),
								getConfig()
										.getInt("Troll.Special.Enchantlevel"));
						special.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Troll.Special.Enchantmentid2")),
								getConfig().getInt(
										"Troll.Special.Enchantmentlevel2"));
						ItemMeta specialMeta = special.getItemMeta();
						specialMeta.setDisplayName(ChatColor.YELLOW
								+ "�oTROLL'S HAMMER");
						special.setItemMeta(specialMeta);
						special.setDurability((short) getConfig().getInt(
								"Troll.Special.Subtractdura"));
						PlayerInventory pi = targetPlayer.getInventory();
						pi.clear();
						pi.setLeggings(tleg);
						pi.setBoots(tboot);
						pi.addItem(stick);
						pi.setHelmet(helm);
						pi.setChestplate(tbody);
						pi.addItem(special);
						pi.addItem(heal);
						pi.addItem(food);
					} else {
						player.sendMessage(ChatColor.RED + noPermission);
					}
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("setredacted")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "This command cannot be executed in the console!");
				return true;
			} else {
				Player player = (Player) sender;
				if (player.hasPermission("pg.setredacted")) {
					player.playSound(player.getLocation(), Sound.WITHER_DEATH,
							1, 1);
					player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					player.removePotionEffect(PotionEffectType.REGENERATION);
					player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					player
							.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					player.removePotionEffect(PotionEffectType.SPEED);
					ItemStack stick = new ItemStack(Material.IRON_SWORD);
					ItemMeta stickMeta = stick.getItemMeta();
					stickMeta.setDisplayName(ChatColor.GREEN
							+ "I'll kick you in the shins!");
					stick.setItemMeta(stickMeta);
					ItemStack vhelm = new ItemStack(Material.getMaterial(397),
							1, (short) 4);
					vhelm.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					ItemStack vbody = new ItemStack(Material.DIAMOND_CHESTPLATE);
					vbody.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
					ItemMeta vbodyMeta = vbody.getItemMeta();
					vbodyMeta.setDisplayName(ChatColor.LIGHT_PURPLE
							+ "Redacted's BreastPlate");
					vbody.setItemMeta(vbodyMeta);
					ItemStack vleg = new ItemStack(Material.LEATHER_LEGGINGS);
					LeatherArmorMeta vl = (LeatherArmorMeta) vleg.getItemMeta();
					vl.setColor(Color.MAROON);
					vleg.setItemMeta(vl);
					vleg.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					vleg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					ItemStack vboot = new ItemStack(Material.LEATHER_BOOTS);
					vboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					vboot.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					ItemStack special = new ItemStack(Material.DIAMOND_SWORD);
					special.setDurability((short) 1560);
					ItemMeta specialMeta = special.getItemMeta();
					specialMeta.setDisplayName(ChatColor.RED
							+ "Redacted Madness");
					special.setItemMeta(specialMeta);
					special.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
					special.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
					ItemStack heal = new ItemStack(Material.GOLDEN_APPLE, 1,
							(short) 1);
					ItemMeta healMeta = heal.getItemMeta();
					healMeta.setDisplayName(ChatColor.GOLD + "No");
					heal.setItemMeta(healMeta);
					ItemStack food = new ItemStack(Material.BAKED_POTATO, 64);
					if (getConfig().getString("globalclassannouce.onenable") == ("true")) {
						getServer().broadcastMessage(
								ChatColor.LIGHT_PURPLE + player.getName()
										+ (" has chosen Redacted class!"));
					}
					player.sendMessage(ChatColor.BOLD
							+ "You have chosen Redacted class!");
					PlayerInventory pi = player.getInventory();
					pi.clear();
					pi.addItem(stick);
					pi.setHelmet(vhelm);
					pi.setChestplate(vbody);
					pi.setLeggings(vleg);
					pi.setBoots(vboot);
					pi.addItem(special);
					pi.addItem(heal);
					pi.addItem(food);
					return true;
				} else {

					player.sendMessage(ChatColor.DARK_RED + noPermission);

				}
			}
		} else if (cmd.getName().equalsIgnoreCase("setarcher")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "This command cannot be executed in the console!");
				return true;
			} else {
				Player player = (Player) sender;
				if (player.hasPermission("pg.setarcher")) {
					player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					player.removePotionEffect(PotionEffectType.REGENERATION);
					player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					player
							.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					player.removePotionEffect(PotionEffectType.SPEED);
					ItemStack arrow = new ItemStack(Material.ARROW);
					ItemStack stick = new ItemStack(Material.IRON_SWORD);
					stick.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
					ItemMeta stickMeta = stick.getItemMeta();
					stickMeta.setDisplayName("Knife");
					stick.setItemMeta(stickMeta);
					ItemStack ahelm = new ItemStack(Material.LEATHER_HELMET);
					ahelm.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					ahelm.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					ItemStack abody = new ItemStack(Material.IRON_CHESTPLATE);
					abody.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					ItemStack alegs = new ItemStack(Material.LEATHER_LEGGINGS);
					alegs.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					alegs.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					ItemStack aboot = new ItemStack(Material.LEATHER_BOOTS);
					aboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					aboot.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					ItemStack bow = new ItemStack(Material.BOW);
					bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
					bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);
					ItemMeta bowMeta = bow.getItemMeta();
					bowMeta.setDisplayName(ChatColor.GOLD + "Archer's Bow");
					bow.setItemMeta(bowMeta);
					ItemStack special = new ItemStack(Material.BOW);
					special.setDurability((short) 378);
					special.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
					special.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
					special.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
					ItemMeta specialMeta = special.getItemMeta();
					specialMeta.setDisplayName(ChatColor.BLACK + "Dark Bow");
					special.setItemMeta(specialMeta);
					ItemStack heal = new ItemStack(Material.GOLDEN_APPLE);
					ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);

					PlayerInventory pi = player.getInventory();
					pi.clear();
					pi.addItem(stick);
					pi.addItem(bow);
					pi.addItem(special);
					pi.addItem(arrow);
					pi.setHelmet(ahelm);
					pi.setChestplate(abody);
					pi.setLeggings(alegs);
					pi.setBoots(aboot);
					pi.addItem(heal);
					pi.addItem(food);
					if (getConfig().getString("globalclassannouce.onenable") == ("true")) {
						getServer().broadcastMessage(
								ChatColor.LIGHT_PURPLE + player.getName()
										+ " has chosen Archer!");
					}
					player.sendMessage(ChatColor.BOLD
							+ "You have chosen Archer!");
					player.addPotionEffect(new PotionEffect(
							PotionEffectType.SPEED, 5000000, 0));
					return true;
				} else {
					player.sendMessage(ChatColor.RED + noPermission);
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("setAnthony")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "This command cannot be executed in the console!");
				return true;
			} else {
				Player player = (Player) sender;
				if (player.hasPermission("pg.setanthony")) {
					player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					player.removePotionEffect(PotionEffectType.REGENERATION);
					player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					player
							.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					player.removePotionEffect(PotionEffectType.SPEED);
					ItemStack stick = new ItemStack(Material.BONE);
					stick.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
					PlayerInventory pi = player.getInventory();
					pi.clear();
					pi.addItem(stick);
					pi.setHelmet(null);
					pi.setChestplate(null);
					pi.setLeggings(null);
					pi.setBoots(null);
					player.addPotionEffect(new PotionEffect(
							PotionEffectType.SPEED, 500000, 1));
					if (getConfig().getString("globalclassannouce.onenable") == ("true")) {
						getServer().broadcastMessage(
								ChatColor.LIGHT_PURPLE + player.getName()
										+ " has chosen Anthony class.");
					}
					player.sendMessage(ChatColor.BOLD
							+ "You have chosen Anthony class");
					return true;
				} else {
					player.sendMessage(ChatColor.RED + noPermission);
				}
			}

		} else if (cmd.getName().equalsIgnoreCase("setwither")) {
			if (args.length == 0) {
				if (!(sender instanceof Player)) {
					sender
							.sendMessage(ChatColor.RED
									+ "This command cannot be executed in the console!");
				} else {
					Player player = (Player) sender;
					if (player.hasPermission("pg.setwither")) {
						player.playSound(player.getLocation(),
								Sound.WITHER_IDLE, 1, 1);
						player
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						player
								.removePotionEffect(PotionEffectType.REGENERATION);
						player
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						player
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						player.removePotionEffect(PotionEffectType.SPEED);
						ItemStack stick = new ItemStack(Material.NETHER_STAR);
						stick.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
						stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
						ItemMeta stickMeta = stick.getItemMeta();
						stickMeta.setDisplayName(ChatColor.GOLD
								+ "Wither's Star");
						stick.setItemMeta(stickMeta);
						ItemStack special = new ItemStack(Material.POTION, 45);
						Potion pot = new Potion(1);
						pot.setType(PotionType.INSTANT_DAMAGE);
						pot.setSplash(true);
						pot.apply(special);
						ItemStack range = new ItemStack(Material.BOW);
						ItemMeta rangeMeta = range.getItemMeta();
						rangeMeta.setDisplayName(ChatColor.LIGHT_PURPLE
								+ "Wither Bow");
						range.setItemMeta(rangeMeta);
						ItemStack wihelm = new ItemStack(Material
								.getMaterial(397), 1, (short) 1);
						wihelm.addUnsafeEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						ItemStack wibody = new ItemStack(
								Material.LEATHER_CHESTPLATE);
						wibody.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wibody.addUnsafeEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						LeatherArmorMeta wb = (LeatherArmorMeta) wibody
								.getItemMeta();
						wb.setColor(Color.BLACK);
						wibody.setItemMeta(wb);
						ItemMeta wibodyMeta = wibody.getItemMeta();
						wibodyMeta.setDisplayName("Wither Protection");
						wibody.setItemMeta(wibodyMeta);
						ItemStack wileg = new ItemStack(
								Material.LEATHER_LEGGINGS);
						wileg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wileg.addUnsafeEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						LeatherArmorMeta wl = (LeatherArmorMeta) wileg
								.getItemMeta();
						wl.setColor(Color.BLACK);
						wileg.setItemMeta(wl);
						ItemStack wiboot = new ItemStack(Material.LEATHER_BOOTS);
						wiboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wiboot.addUnsafeEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 3);
						LeatherArmorMeta wbo = (LeatherArmorMeta) wiboot
								.getItemMeta();
						wbo.setColor(Color.BLACK);
						wiboot.setItemMeta(wbo);
						PlayerInventory pi = player.getInventory();
						pi.clear();
						pi.addItem(stick);
						pi.addItem(special);
						pi.setHelmet(wihelm);
						pi.setChestplate(wibody);
						pi.setLeggings(wileg);
						pi.setBoots(wiboot);
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer().broadcastMessage(
									ChatColor.LIGHT_PURPLE + player.getName()
											+ " has chosen wither class!");
						}
						player.sendMessage(ChatColor.BOLD
								+ "You have chosen Wither class!");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + noPermission);
					}
				}
			} else if (args.length == 1) {
				Player player = (Player) sender;
				if (player.hasPermission("pg.setwither.setother")) {
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					targetPlayer
							.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					targetPlayer
							.removePotionEffect(PotionEffectType.REGENERATION);
					targetPlayer
							.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					targetPlayer
							.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					targetPlayer.removePotionEffect(PotionEffectType.SPEED);
					ItemStack stick = new ItemStack(Material.NETHER_STAR);
					stick.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
					stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
					ItemMeta stickMeta = stick.getItemMeta();
					stickMeta.setDisplayName(ChatColor.GOLD + "Wither's Star");
					stick.setItemMeta(stickMeta);
					ItemStack special = new ItemStack(Material.POTION, 45);
					Potion pot = new Potion(1);
					pot.setType(PotionType.INSTANT_DAMAGE);
					pot.setSplash(true);
					pot.apply(special);
					ItemStack range = new ItemStack(Material.BOW);
					ItemMeta rangeMeta = range.getItemMeta();
					rangeMeta.setDisplayName(ChatColor.LIGHT_PURPLE
							+ "Wither Bow");
					range.setItemMeta(rangeMeta);
					ItemStack wihelm = new ItemStack(Material.getMaterial(397),
							1, (short) 1);
					wihelm.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					ItemStack wibody = new ItemStack(
							Material.LEATHER_CHESTPLATE);
					wibody.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					wibody.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					LeatherArmorMeta wb = (LeatherArmorMeta) wibody
							.getItemMeta();
					wb.setColor(Color.BLACK);
					wibody.setItemMeta(wb);
					ItemMeta wibodyMeta = wibody.getItemMeta();
					wibodyMeta.setDisplayName("Wither Protection");
					wibody.setItemMeta(wibodyMeta);
					ItemStack wileg = new ItemStack(Material.LEATHER_LEGGINGS);
					wileg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					wileg.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					LeatherArmorMeta wl = (LeatherArmorMeta) wileg
							.getItemMeta();
					wl.setColor(Color.BLACK);
					wileg.setItemMeta(wl);
					ItemStack wiboot = new ItemStack(Material.LEATHER_BOOTS);
					wiboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					wiboot.addUnsafeEnchantment(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					LeatherArmorMeta wbo = (LeatherArmorMeta) wiboot
							.getItemMeta();
					wbo.setColor(Color.BLACK);
					wiboot.setItemMeta(wbo);
					PlayerInventory pi = targetPlayer.getInventory();
					targetPlayer.playSound(targetPlayer.getLocation(),
							Sound.WITHER_IDLE, 1, 1);
					pi.clear();
					pi.addItem(stick);
					pi.addItem(special);
					pi.setHelmet(wihelm);
					pi.setChestplate(wibody);
					pi.setLeggings(wileg);
					pi.setBoots(wiboot);
					sender.sendMessage(ChatColor.BOLD + "You have chosen "
							+ targetPlayer.getName() + " for wither class!");
					if (getConfig().getString("globalclassannouce.onenable") == ("true")) {
						getServer().broadcastMessage(
								ChatColor.LIGHT_PURPLE + targetPlayer.getName()
										+ " has been chosen for Wither class!");
					}
					targetPlayer.sendMessage(ChatColor.BOLD
							+ "Someone chosen you as wither!");
					return true;
				} else {
					player.sendMessage(ChatColor.RED + noPermission);
				}
			}

		} else if (cmd.getName().equalsIgnoreCase("sethunter")) {
			if (args.length == 0) {
				if (!(sender instanceof Player)) {
					sender
							.sendMessage(ChatColor.RED
									+ "This command cannot be executed in the console!");
					return true;
				} else {
					Player player = (Player) sender;
					if (player.hasPermission("pg.sethunter")) {
						player
								.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
						player
								.removePotionEffect(PotionEffectType.REGENERATION);
						player
								.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						player
								.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
						player.removePotionEffect(PotionEffectType.SPEED);
						player.playSound(player.getLocation(),
								Sound.ITEM_BREAK, 1, 1);
						ItemStack hhelm = new ItemStack(getConfig().getInt(
								"Hunter.Helmet.ID"), getConfig().getInt(
								"Hunter.Helmet.Amount"));
						hhelm.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						hhelm.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Hunter.Helmet.Enchantmentid")),
								getConfig()
										.getInt("Hunter.Helmet.Enchantlevel"));
						ItemStack wbody = new ItemStack(getConfig().getInt(
								"Hunter.Chestplate.ID"), getConfig().getInt(
								"Hunter.Chestplate.Amount"));
						wbody.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wbody.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Hunter.Chestplate.Enchantmentid")),
								getConfig().getInt(
										"Hunter.Chestplate.Enchantlevel"));
						ItemStack wleg = new ItemStack(getConfig().getInt(
								"Hunter.Leggings.ID"), getConfig().getInt(
								"Hunter.Leggings.Amount"));
						wleg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wleg
								.addUnsafeEnchantment(
										Enchantment
												.getById(getConfig()
														.getInt(
																"Hunter.Leggings.Enchantmentid")),
										getConfig().getInt(
												"Hunter.Leggings.Enchantid"));
						ItemStack wboot = new ItemStack(getConfig().getInt(
								"Hunter.Boots.ID"), getConfig().getInt(
								"Hunter.Boots.Amount"));
						wboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
						wboot
								.addUnsafeEnchantment(Enchantment
										.getById(getConfig().getInt(
												"Hunter.Boots.Enchantmentid")),
										getConfig().getInt(
												"Hunter.Boots.Enchantlevel"));
						ItemStack stick = new ItemStack(getConfig().getInt(
								"Hunter.Mainweapon.ID"), getConfig().getInt(
								"Hunter.Mainweapon.Amount"),
								(short) getConfig().getInt(
										"Hunter.Mainweapon.Extraint"));
						ItemMeta stickMeta = stick.getItemMeta();
						stickMeta.setDisplayName("Hunter's Knife");
						stick.setItemMeta(stickMeta);
						stick.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
						stick.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Hunter.Mainweapon.Enchantmentid")),
								getConfig().getInt(
										"Hunter.Mainweapon.Enchantlevel"));
						ItemStack range = new ItemStack(getConfig().getInt(
								"Hunter.Secondaryweapon.ID"), getConfig()
								.getInt("Hunter.Secondaryweapon.Amount"),
								(short) getConfig().getInt(
										"Hunter.Secondaryweapon.Extraint"));
						range
								.addUnsafeEnchantment(
										Enchantment
												.getById(getConfig()
														.getInt(
																"Hunter.Secondaryweapon.Enchantmentid")),
										getConfig()
												.getInt(
														"Hunter.Secondaryweapon.Enchantlevel"));
						range
								.addUnsafeEnchantment(
										Enchantment
												.getById(getConfig()
														.getInt(
																"Hunter.Secondaryweapon.Enchantmentid2")),
										getConfig()
												.getInt(
														"Hunter.Secondaryweapon.Enchantlevel2"));
						ItemMeta rangeMeta = range.getItemMeta();
						rangeMeta.setDisplayName("Hunter's Bow");
						ItemStack special = new ItemStack(getConfig().getInt(
								"Hunter.Specialweapon.ID"), getConfig().getInt(
								"Hunter.Specialweapon.Amount"),
								(short) getConfig().getInt(
										"Hunter.Specialweapon.Extraint"));
						special.addUnsafeEnchantment(Enchantment
								.getById(getConfig().getInt(
										"Hunter.Specialweapon.Enchantmentid")),
								getConfig().getInt(
										"Hunter.Specialweapon.Enchantlevel"));
						special.setDurability((short) getConfig().getInt(
								"Hunter.Specialweapon.SubtractDurabil"));
						ItemMeta specialMeta = special.getItemMeta();
						specialMeta.setDisplayName(ChatColor.AQUA
								+ "Special Hunter's Knife");
						special.setItemMeta(specialMeta);
						ItemStack food = new ItemStack(getConfig().getInt(
								"Hunter.Food.ID"), getConfig().getInt(
								"Hunter.Food.Amount"), (short) getConfig()
								.getInt("Hunter.Food.Extraint"));
						ItemStack heal = new ItemStack(getConfig().getInt(
								"Hunter.Heal.ID"), getConfig().getInt(
								"Hunter.Heal.Amount"), (short) getConfig()
								.getInt("Hunter.Heal.Extraint"));
						ItemStack et1 = new ItemStack(getConfig().getInt(
								"Hunter.Extraitem1.ID"), getConfig().getInt(
								"Hunter.Extraitem1.Amount"),
								(short) getConfig().getInt(
										"Hunter.Extraitem1.Extraint"));
						ItemStack et2 = new ItemStack(getConfig().getInt(
								"Hunter.Extraitem2.ID"), getConfig().getInt(
								"Hunter.Extraitem2.Amount"),
								(short) getConfig().getInt(
										"Hunter.Extraitem1.Extraint"));
						ItemStack et3 = new ItemStack(getConfig().getInt(
								"Hunter.Extraitem3.ID"), getConfig().getInt(
								"Hunter.Extraitem3.Amount"),
								(short) getConfig().getInt(
										"Hunter.Extraitem1.Extraint"));
						PlayerInventory pi = player.getInventory();
						pi.clear();
						pi.setHelmet(hhelm);
						pi.setChestplate(wbody);
						pi.setLeggings(wleg);
						pi.setBoots(wboot);
						pi.addItem(stick);
						pi.addItem(range);
						pi.addItem(special);
						pi.addItem(food);
						pi.addItem(heal);
						pi.addItem(et1);
						pi.addItem(et2);
						pi.addItem(et3);
						if (getConfig()
								.getString("globalclassannouce.onenable") == ("true")) {
							getServer().broadcastMessage(
									ChatColor.LIGHT_PURPLE + player.getName()
											+ " has chosen Hunter!");
						}
						player.sendMessage(ChatColor.BOLD
								+ "You have chosen Hunter");
						return true;
					} else {
						player.sendMessage(ChatColor.RED + noPermission);
					}
				}
			} else if (args.length == 1) {
				Player player = (Player) sender;
				if (player.hasPermission("pg.sethunter.setother")) {
					Player targetPlayer = getServer().getPlayer(args[0]);
					targetPlayer
							.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					targetPlayer
							.removePotionEffect(PotionEffectType.REGENERATION);
					targetPlayer
							.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					targetPlayer
							.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
					targetPlayer.removePotionEffect(PotionEffectType.SPEED);
					player.sendMessage(ChatColor.BOLD + "You have chosen "
							+ targetPlayer.getName() + " for Hunter class!");
					if (getConfig().getString("globalclassannouce.onenable") == ("true")) {
						getServer().broadcastMessage(
								ChatColor.LIGHT_PURPLE + targetPlayer.getName()
										+ " has been chosen for hunter!");
					}
					targetPlayer.sendMessage(ChatColor.BOLD
							+ "Someone has chosen you for hunter!");
					ItemStack hhelm = new ItemStack(getConfig().getInt(
							"Hunter.Helmet.ID"), getConfig().getInt(
							"Hunter.Helmet.Amount"));
					hhelm.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					hhelm.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Hunter.Helmet.Enchantmentid")),
							getConfig().getInt("Hunter.Helmet.Enchantlevel"));
					ItemStack wbody = new ItemStack(getConfig().getInt(
							"Hunter.Chestplate.ID"), getConfig().getInt(
							"Hunter.Chestplate.Amount"));
					wbody.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					wbody.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Hunter.Chestplate.Enchantmentid")),
							getConfig()
									.getInt("Hunter.Chestplate.Enchantlevel"));
					ItemStack wleg = new ItemStack(getConfig().getInt(
							"Hunter.Leggings.ID"), getConfig().getInt(
							"Hunter.Leggings.Amount"));
					wleg.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					wleg.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Hunter.Leggings.Enchantmentid")),
							getConfig().getInt("Hunter.Leggings.Enchantid"));
					ItemStack wboot = new ItemStack(getConfig().getInt(
							"Hunter.Boots.ID"), getConfig().getInt(
							"Hunter.Boots.Amount"));
					wboot.addUnsafeEnchantment(Enchantment.DURABILITY, 30);
					wboot.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Hunter.Boots.Enchantmentid")), getConfig()
							.getInt("Hunter.Boots.Enchantlevel"));
					ItemStack stick = new ItemStack(getConfig().getInt(
							"Hunter.Mainweapon.ID"), getConfig().getInt(
							"Hunter.Mainweapon.Amount"), (short) getConfig()
							.getInt("Hunter.Mainweapon.Extraint"));
					ItemMeta stickMeta = stick.getItemMeta();
					stickMeta.setDisplayName("Hunter's Knife");
					stick.setItemMeta(stickMeta);
					stick.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
					stick.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Hunter.Mainweapon.Enchantmentid")),
							getConfig()
									.getInt("Hunter.Mainweapon.Enchantlevel"));
					ItemStack range = new ItemStack(getConfig().getInt(
							"Hunter.Secondaryweapon.ID"), getConfig().getInt(
							"Hunter.Secondaryweapon.Amount"),
							(short) getConfig().getInt(
									"Hunter.Secondaryweapon.Extraint"));
					range.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Hunter.Secondaryweapon.Enchantmentid")),
							getConfig().getInt(
									"Hunter.Secondaryweapon.Enchantlevel"));
					range.addUnsafeEnchantment(Enchantment.getById(getConfig()
							.getInt("Hunter.Secondaryweapon.Enchantmentid2")),
							getConfig().getInt(
									"Hunter.Secondaryweapon.Enchantlevel2"));
					ItemMeta rangeMeta = range.getItemMeta();
					rangeMeta.setDisplayName("Hunter's Bow");
					ItemStack special = new ItemStack(getConfig().getInt(
							"Hunter.Specialweapon.ID"), getConfig().getInt(
							"Hunter.Specialweapon.Amount"), (short) getConfig()
							.getInt("Hunter.Specialweapon.Extraint"));
					special.addUnsafeEnchantment(Enchantment
							.getById(getConfig().getInt(
									"Hunter.Specialweapon.Enchantmentid")),
							getConfig().getInt(
									"Hunter.Specialweapon.Enchantlevel"));
					special.setDurability((short) getConfig().getInt(
							"Hunter.Specialweapon.SubtractDurabil"));
					ItemMeta specialMeta = special.getItemMeta();
					specialMeta.setDisplayName(ChatColor.AQUA
							+ "Special Hunter's Knife");
					special.setItemMeta(specialMeta);
					ItemStack food = new ItemStack(getConfig().getInt(
							"Hunter.Food.ID"), getConfig().getInt(
							"Hunter.Food.Amount"), (short) getConfig().getInt(
							"Hunter.Food.Extraint"));
					ItemStack heal = new ItemStack(getConfig().getInt(
							"Hunter.Heal.ID"), getConfig().getInt(
							"Hunter.Heal.Amount"), (short) getConfig().getInt(
							"Hunter.Heal.Extraint"));
					ItemStack et1 = new ItemStack(getConfig().getInt(
							"Hunter.Extraitem1.ID"), getConfig().getInt(
							"Hunter.Extraitem1.Amount"), (short) getConfig()
							.getInt("Hunter.Extraitem1.Extraint"));
					ItemStack et2 = new ItemStack(getConfig().getInt(
							"Hunter.Extraitem2.ID"), getConfig().getInt(
							"Hunter.Extraitem2.Amount"), (short) getConfig()
							.getInt("Hunter.Extraitem1.Extraint"));
					ItemStack et3 = new ItemStack(getConfig().getInt(
							"Hunter.Extraitem3.ID"), getConfig().getInt(
							"Hunter.Extraitem3.Amount"), (short) getConfig()
							.getInt("Hunter.Extraitem1.Extraint"));
					PlayerInventory pi = targetPlayer.getInventory();
					pi.clear();
					pi.setHelmet(hhelm);
					pi.setChestplate(wbody);
					pi.setLeggings(wleg);
					pi.setBoots(wboot);
					pi.addItem(stick);
					pi.addItem(range);
					pi.addItem(special);
					pi.addItem(food);
					pi.addItem(heal);
					pi.addItem(et1);
					pi.addItem(et2);
					pi.addItem(et3);
					return true;
				} else {
					player.sendMessage(ChatColor.RED + noPermission);
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("alertpvp")) {
			if (sender.hasPermission("pg.alertpvp")) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.RED
							+ "Usage: /alertpvp <Message or warp>");
					return true;
				} else if (args.length > 0) {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < args.length; i++) {
						sb.append(args[i]).append(" ");
					}
					String allArgs = sb.toString().trim();
					getServer().broadcastMessage(
							ChatColor.AQUA + "[ThePvpGames] " + ChatColor.GREEN
									+ "A game has started at " + allArgs);
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED
						+ "You do not have permission or rank.");
				return true;
			}
		} else if (cmd.getName().equalsIgnoreCase("pgleave")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED
						+ "This command cannot be executed in the console.");
				return true;
			} else {
				Player player = (Player) sender;
				if (player.hasPermission("pg.pgleave")) {
					player.sendMessage(ChatColor.AQUA + "[ThePvPGames] "
							+ ChatColor.GREEN + "Thank you for playing!");
					PlayerInventory pi = player.getInventory();
					pi.clear();
					pi.setHelmet(null);
					pi.setChestplate(null);
					pi.setLeggings(null);
					pi.setBoots(null);
					return true;
				} else {
					player.sendMessage(ChatColor.RED + noPermission);
				}
			}

		} else if (cmd.getName().equalsIgnoreCase("pgconfig")) {
			String pgconfigUsage = (ChatColor.RED + "Usage: /pgconfig (class) (configname) (value)");
			String pgClasses = (ChatColor.GREEN + "Available configurations: mainweapon, secondaryweapon, helmet, chestplate, leggings, boots, secondaryweapon, heal, food");
			if (args.length == 1) {
				if (args[1] == ("wizard")) {
					if (args[2] == ("mainweapon")) {
						getConfig().set("Wizard.Mainweapon.ID", args[3]);
					}
				} else {
					sender.sendMessage(pgClasses);
					sender.sendMessage(pgconfigUsage);
				}
			} else {
				sender.sendMessage(pgconfigUsage);
			}
		}
		return false;
	}
}
