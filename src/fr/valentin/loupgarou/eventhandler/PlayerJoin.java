package fr.valentin.loupgarou.eventhandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.valentin.loupgarou.LoupGarou;

public class PlayerJoin implements Listener {
	
	private LoupGarou plugin;
	public PlayerJoin(LoupGarou plugin) {
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent event) {
		plugin.items.GiveItemTeam();
	}

}
