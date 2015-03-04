package fr.valentin.loupgarou.eventhandler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;

import fr.valentin.loupgarou.LoupGarou;
import fr.valentin.loupgarou.status.Status;

public class PlayerMove {

	private LoupGarou plugin;
	public PlayerMove(LoupGarou plugin) {
		plugin = this.plugin;
	}

	
	@EventHandler
	public void GiveItem(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if(LoupGarou.status == Status.game) {
			if(LGPT.getTeamsHumain().hasPlayer(player)) {
				if(player.getLocation().getBlockX() == LGPC.SpawnHumain.getBlockX() && player.getLocation().getBlockZ() == LGPC.SpawnHumain.getBlockZ()) {
					LGPI.ItemHumain(player);
				}
			}
			else if(LGPT.getTeamsLoup().hasPlayer(player)) {
				if(player.getLocation().getBlockX() == LGPC.SpawnLoup.getBlockX() && player.getLocation().getBlockZ() == LGPC.SpawnLoup.getBlockZ()) {
					LGPI.ItemLoup(player);
				}
			}
		}
	}
}
