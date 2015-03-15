package fr.valentin.loupgarou;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.valentin.loupgarou.status.Status;


public class Start {

	private LoupGarou plugin;
	public Start(LoupGarou plugin) {
		this.plugin = plugin;
	}

	
	public void StartGame() {

		for(Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(plugin.Tag+ChatColor.GOLD+"Lancement de la partie dans "+ChatColor.LIGHT_PURPLE+ plugin.time_before_the_party +ChatColor.GOLD+" seconde(s).");
			player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Tone.A));
			player.setLevel(plugin.time_before_the_party);
		}

		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin , new BukkitRunnable() {

			@Override
			public void run() {

				if (!(plugin.time_before_the_party <= -1)) {
					plugin.time_before_the_party--;

					if (plugin.time_before_the_party != 0) {	
						for (Player player : Bukkit.getOnlinePlayers()) {
							player.setLevel(plugin.time_before_the_party);
						}

						if (plugin.time_before_the_party == 1) {
							for(Player player : Bukkit.getOnlinePlayers()) {
								player.sendMessage(plugin.Tag+ChatColor.GOLD+"Lancement de la partie dans "+ChatColor.LIGHT_PURPLE+ plugin.time_before_the_party +ChatColor.GOLD+" seconde.");
								player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Tone.A));
							}
						}

						else if (plugin.time_before_the_party == 60 || plugin.time_before_the_party == 30 || plugin.time_before_the_party == 10 || plugin.time_before_the_party <= 5) {
							for(Player player : Bukkit.getOnlinePlayers()) {
								player.sendMessage(plugin.Tag+ChatColor.GOLD+"Lancement de la partie dans "+ChatColor.LIGHT_PURPLE+ plugin.time_before_the_party +ChatColor.GOLD+" secondes.");
								player.playNote(player.getLocation(), Instrument.PIANO, Note.flat(1, Tone.A));
							}
						}
					}		
					else {
						for(Player player : Bukkit.getOnlinePlayers()) {
							player.sendMessage(plugin.Tag+ChatColor.GREEN+" >>  C'est parti !  <<");
							player.playNote(player.getLocation(), Instrument.BASS_DRUM, Note.flat(1, Tone.A));
							player.setLevel(0);
						}
						plugin.time_before_the_party = -2;
						plugin.status = Status.game;

						plugin.teams.teleportHumain(plugin.loupGarouSetupCommands.getSpawnHumain());
						plugin.teams.teleportLoup(plugin.loupGarouSetupCommands.getSpawnLoup());
						plugin.teams.teleportSpectateur(plugin.loupGarouSetupCommands.getSpawn());

						plugin.timer.Chrono();
						plugin.scoreboardManager.getScoreboard();

					}

				}
			}	
		},0L, 20L);

	}

}