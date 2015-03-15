package fr.valentin.loupgarou.scoreboard;


import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import fr.valentin.loupgarou.LoupGarou;

public class ScoreboardManager {

	private NumberFormat formatter = new DecimalFormat("00");
	private Scoreboard scoreboard;
	private Objective objective;

	private LoupGarou plugin;
	public ScoreboardManager(LoupGarou plugin) {
		this.plugin = plugin;
	}

	
	public void getScoreboard() {
		
		scoreboard = plugin.sbManager.getNewScoreboard();
		objective = scoreboard.registerNewObjective("LoupGarou", "dummy");
		objective.setDisplayName(ChatColor.GRAY+" -- "+""+ChatColor.GOLD+"Loup Garou"+""+ChatColor.GRAY+" -- ");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		for (Player p : Bukkit.getServer().getOnlinePlayers()){
			p.setScoreboard(plugin.sbManager.getNewScoreboard());
			p.setScoreboard(scoreboard);
		}	

		objective.getScore(Bukkit.getOfflinePlayer(ChatColor.DARK_BLUE+"Team Loup")).setScore(8);
		objective.getScore(Bukkit.getOfflinePlayer("Players :"+ChatColor.WHITE+" "+plugin.teams.nmbLoup())).setScore(7);
		objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY+"---------- ")).setScore(6);
		objective.getScore(Bukkit.getOfflinePlayer(ChatColor.AQUA+"Team Humain")).setScore(5);
		objective.getScore(Bukkit.getOfflinePlayer(ChatColor.WHITE+"Players : "+plugin.teams.nmbHumain())).setScore(4);
		objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY+"----------")).setScore(3);
		objective.getScore(Bukkit.getOfflinePlayer("")).setScore(2);

		if (plugin.timer.getMinutes() == 0 && plugin.timer.getSecondes() == 0) {
			objective.getScore(Bukkit.getOfflinePlayer(ChatColor.RED+"00"+ChatColor.GRAY+":"+ChatColor.RED+"00")).setScore(1);
		}
		else {
			objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN+formatter.format(plugin.timer.getMinutes())+ChatColor.GRAY+":"+ChatColor.GREEN+formatter.format(plugin.timer.getSecondes()))).setScore(1);		
		}
	}

	
}
