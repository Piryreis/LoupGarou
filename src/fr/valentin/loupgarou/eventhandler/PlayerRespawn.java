package fr.valentin.loupgarou.eventhandler;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.valentin.loupgarou.LoupGarou;
import fr.valentin.loupgarou.status.Status;

public class PlayerRespawn {

	private LoupGarou plugin;
	
	public PlayerRespawn(LoupGarou plugin) {
		plugin = this.plugin;
	}
	
	
	@EventHandler
	public void PlayerRespawnEvent(PlayerRespawnEvent event) {
		final Player player = event.getPlayer();
		if(LoupGarou.status == Status.game) {
			if(LGPT.getTeamsHumain().hasPlayer(player)) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						player.teleport(LGPC.SpawnHumain);
						LGPI.ItemHumain(player);
					}
				}, 1);				
			}
			else if(LGPT.getTeamsLoup().hasPlayer(player)) {
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						player.teleport(LGPC.SpawnLoup);
					}
				}, 1);		

			}

		}
	}
}
