package fr.valentin.loupgarou;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import fr.valentin.loupgarou.status.Status;

public class Game {

	private LoupGarou plugin;
	public Game(LoupGarou plugin) {
		this.plugin = plugin;
	}
	

	public void TestWin() {

		for(Player p : Bukkit.getOnlinePlayers()){
			if(plugin.status == Status.game) {
				if(plugin.teams.getTeamsHumain().hasPlayer(p)) {
					if(p.hasPotionEffect(PotionEffectType.WEAKNESS)) {
						p.removePotionEffect(PotionEffectType.WEAKNESS);
						plugin.teams.getTeamsHumain().removePlayer(p);
						plugin.teams.getPlayersHumain();
						plugin.teams.getTeamsLoup().addPlayer(p);
						plugin.teams.getPlayersLoup();
						p.teleport(plugin.loupGarouSetupCommands.getSpawnLoup());
					}
				}
				else {
					p.removePotionEffect(PotionEffectType.WEAKNESS);
				}
				if(plugin.teams.getTeamsLoup().hasPlayer(p)) {
					if(p.hasPotionEffect(PotionEffectType.REGENERATION)) {
						p.removePotionEffect(PotionEffectType.REGENERATION);
						p.removePotionEffect(PotionEffectType.SPEED);
						p.removePotionEffect(PotionEffectType.JUMP);
						plugin.teams.getTeamsLoup().removePlayer(p);
						plugin.teams.getPlayersLoup();
						plugin.teams.getTeamsHumain().addPlayer(p);
						plugin.teams.getPlayersHumain();	
						p.teleport(plugin.loupGarouSetupCommands.getSpawnHumain());
					}			
				}
				else {
					p.removePotionEffect(PotionEffectType.REGENERATION);
				}

				if(plugin.teams.nmbHumain() == 0) {
					plugin.teams.getTeamsSpectateur().addPlayer(Bukkit.getServer().getPlayer(""));
					Bukkit.getServer().broadcastMessage(ChatColor.BOLD+""+ChatColor.GREEN+"--------------------");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY+"Les "+ChatColor.DARK_BLUE+"Loups "+ChatColor.DARK_GRAY+"ont gagnés.");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage(ChatColor.BOLD+""+ChatColor.GREEN+"--------------------");
					plugin.status = Status.end;
				}
				if (plugin.teams.nmbLoup() == 0) {
					plugin.teams.getTeamsSpectateur().addPlayer(Bukkit.getServer().getPlayer(""));
					Bukkit.getServer().broadcastMessage(ChatColor.BOLD+""+ChatColor.GREEN+"--------------------");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage(ChatColor.DARK_GRAY+"Les "+ChatColor.AQUA+"Humains "+ChatColor.DARK_GRAY+"ont gagnés.");
					Bukkit.getServer().broadcastMessage("");
					Bukkit.getServer().broadcastMessage(ChatColor.BOLD+""+ChatColor.GREEN+"--------------------");
					plugin.status = Status.end;
				}
			}
		}
	}

}

