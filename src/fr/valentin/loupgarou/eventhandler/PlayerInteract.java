package fr.valentin.loupgarou.eventhandler;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.valentin.loupgarou.LoupGarou;

public class PlayerInteract implements Listener {
	
	private LoupGarou plugin;
	public PlayerInteract(LoupGarou plugin) {
		plugin = this.plugin;
	}

	
	@EventHandler (priority = EventPriority.HIGH)
	public void PlayerInteractEvent(PlayerInteractEvent event) {
		Inventory inv = Bukkit.createInventory(null, 45,"Spectateur");
		ArrayList<String> lore;
		Action a = event.getAction();
		ItemStack is = event.getItem();
		Player pl = event.getPlayer();

		if (a == Action.PHYSICAL || is == null || is.getType() == Material.AIR) 
			return;

		if (is.getType() == Material.COMPASS) {
			for(Player p : Bukkit.getOnlinePlayers()){
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(p.getName());
				lore = new ArrayList<String>();
				lore.add(ChatColor.DARK_PURPLE + "Clicker pour vous téléporter") ;
				meta.setLore(lore) ;
				item.setItemMeta(meta);
				inv.addItem(item);

			}
			pl.openInventory(inv);
		}
	}
	
}
