package fr.valentin.loupgarou.eventhandler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.valentin.loupgarou.LoupGarou;
import fr.valentin.loupgarou.status.Status;

public class PlayerMove implements Listener {

	private LoupGarou plugin;
	public PlayerMove(LoupGarou plugin) {
		plugin = this.plugin;
	}
	
	
	@EventHandler
	public void GiveItem(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if(plugin.status == Status.game) {
			if(plugin.teams.getTeamsHumain().hasPlayer(player)) {
				if(player.getLocation().getBlockX() == plugin.loupGarouSetupCommands.getSpawnHumain().getBlockX() && player.getLocation().getBlockZ() == plugin.loupGarouSetupCommands.getSpawnHumain().getBlockZ()) {
					plugin.items.ItemHumain(player);
				}
			}
			else if(plugin.teams.getTeamsLoup().hasPlayer(player)) {
				if(player.getLocation().getBlockX() == plugin.loupGarouSetupCommands.getSpawnLoup().getBlockX() && player.getLocation().getBlockZ() == plugin.loupGarouSetupCommands.getSpawnLoup().getBlockZ()) {
					plugin.items.ItemLoup(player);
				}
			}
		}
	}
	
}
