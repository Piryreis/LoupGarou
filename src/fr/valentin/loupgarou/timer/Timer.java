package fr.valentin.loupgarou.timer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.valentin.loupgarou.LoupGarou;

public class Timer {

	private Integer Minutes;
	private Integer Secondes = 0;

	private LoupGarou plugin;
	public Timer(LoupGarou plugin) {
		this.plugin = plugin;
		this.Minutes = plugin.time_of_a_game;
	}


	public void Chrono() {

		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin , new BukkitRunnable() {

			@Override
			public void run() {
				if (Minutes != -2) {
					plugin.scoreboardManager.getScoreboard();
					Secondes--;
					plugin.game.TestWin();
				}
				if (Secondes == -1) {
					Minutes--;
					Secondes = 59;
					plugin.game.TestWin();
				}
				if (Minutes == -1) {
					Minutes = -2;
					Secondes = 0;
					for(Player player : Bukkit.getOnlinePlayers()) {
						player.sendMessage(plugin.Tag +ChatColor.RED+"Temps écouler! Fin de la partie!");
						player.playNote(player.getLocation(), Instrument.BASS_DRUM, Note.flat(1, Tone.A));
					}
				}
			}
		}, 0L, 20L);

	}

	public Integer getMinutes(){
		return Minutes;
	}

	public Integer getSecondes(){
		return Secondes;
	}

}
