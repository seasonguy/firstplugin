package me.mineocraft.pvpgames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
//PlayerListener class!
public class PlayerListener implements Listener {
	private pvpmineo plugin;
	public PlayerListener(pvpmineo instance) {
		this.plugin = instance;
	}
   @SuppressWarnings("deprecation")
@EventHandler(priority =  EventPriority.HIGHEST)
   public void onDeath(PlayerDeathEvent e)
   {
	   Player p = e.getEntity();
	if (plugin.getConfig().getString("enabledrop.Enable") == ("true")) {
		   Bukkit.broadcastMessage(ChatColor.AQUA + "[ThePvPGames] " + ChatColor.GOLD + p.getName() + " has been eliminated!");
		   p.playSound(p.getLocation(), Sound.ANVIL_BREAK, 1, 1);
		   if (plugin.getConfig().getString("enabledrop.Cleardropitems") == ("true")){
			   e.getDrops().clear();
		   }
		   ItemStack healdrop = new ItemStack(plugin.getConfig().getInt("enabledrop.Itemdropid"), plugin.getConfig().getInt("enabledrop.Amount"), (short)plugin.getConfig().getInt("enabledrop.Extraint"));
		   e.getDrops().add(healdrop);
	   }
   }
   @EventHandler
   public void onJoin(PlayerJoinEvent e)
   {
	   Player p = e.getPlayer();
	   if (plugin.getConfig().getString("joinmessage.onenable") == ("true")) {
		   p.sendMessage(plugin.getConfig().getString("joinmessage.message"));
	   } else {
		   //Nuffin' but you can put stuff here.
	   }
   }
   @EventHandler
   public void onChat(AsyncPlayerChatEvent e){
	   e.setMessage(e.getMessage().replaceAll(":)", ":D"));
   }
}
