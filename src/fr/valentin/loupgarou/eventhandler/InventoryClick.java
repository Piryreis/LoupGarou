package fr.valentin.loupgarou.eventhandler;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import fr.valentin.loupgarou.LoupGarou;

public class InventoryClick implements Listener {

	private LoupGarou plugin;
	public InventoryClick(LoupGarou plugin) {
		plugin = this.plugin;
	}
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();
		if (inventory.getName().equals("Spectateur")) {
			if (clicked.getType() == Material.SKULL_ITEM) {
				event.setCancelled(true);
				player.closeInventory();
				String e = clicked.getItemMeta().getDisplayName();
				Player pl = Bukkit.getPlayer(e);
				Location l = pl.getLocation();
				player.teleport(l);
			}
		}
	}
}
