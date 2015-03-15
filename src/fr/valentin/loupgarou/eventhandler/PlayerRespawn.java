package fr.valentin.loupgarou.eventhandler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.valentin.loupgarou.LoupGarou;
import fr.valentin.loupgarou.status.Status;

public class PlayerRespawn implements Listener {

	private LoupGarou plugin;
	public PlayerRespawn(LoupGarou plugin) {
		plugin = this.plugin;
	}


	@EventHandler
	public void PlayerRespawnEvent(PlayerRespawnEvent event) {
		final Player player = event.getPlayer();
		if(plugin.status == Status.game) {
			if(plugin.teams.getTeamsHumain().hasPlayer(player)) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						player.teleport(plugin.loupGarouSetupCommands.getSpawnHumain());
					}
				}, 1);				
			}
			else if(plugin.teams.getTeamsLoup().hasPlayer(player)) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						player.teleport(plugin.loupGarouSetupCommands.getSpawnLoup());
					}
				}, 1);		

			}

		}
	}
	
}
