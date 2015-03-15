package fr.valentin.loupgarou;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.valentin.loupgarou.commands.LoupGarouCommands;
import fr.valentin.loupgarou.commands.LoupGarouSetupCommands;
import fr.valentin.loupgarou.eventhandler.InventoryClick;
import fr.valentin.loupgarou.eventhandler.PlayerInteract;
import fr.valentin.loupgarou.eventhandler.PlayerJoin;
import fr.valentin.loupgarou.eventhandler.PlayerMove;
import fr.valentin.loupgarou.eventhandler.PlayerRespawn;
import fr.valentin.loupgarou.items.Items;
import fr.valentin.loupgarou.status.Status;
import fr.valentin.loupgarou.teams.Teams;
import fr.valentin.loupgarou.timer.Timer;

public class LoupGarou extends JavaPlugin{

	private Logger logger;
	public PluginManager pm;
	public ScoreboardManager sbManager;
	
	public Items items;
	public LoupGarouSetupCommands loupGarouSetupCommands;
	public Start start;
	public Status status;
	public Timer timer;
	public fr.valentin.loupgarou.scoreboard.ScoreboardManager scoreboardManager;
	public Teams teams;
	public Game game;
	
	public String Tag = "§7[§6LoupGarou§7]:§r ";
	public int time_of_a_game = this.getConfig().getInt("time_of_a_game");
	public int time_before_the_party = this.getConfig().getInt("time_before_the_party");
	

	
	@Override
	public void onEnable() {
		logger = this.getLogger();
		pm = getServer().getPluginManager();
		sbManager = Bukkit.getScoreboardManager();

		items = new Items(this);
		loupGarouSetupCommands = new LoupGarouSetupCommands(this);
		start = new Start(this);
		timer = new Timer(this);
		scoreboardManager = new fr.valentin.loupgarou.scoreboard.ScoreboardManager(this);
		teams = new Teams(this);
		game = new Game(this);
		
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(new PlayerInteract(this), this);
		pm.registerEvents(new PlayerMove(this), this);
		pm.registerEvents(new PlayerRespawn(this), this);
		pm.registerEvents(new Teams(this), this);

		getCommand("LoupGarou").setExecutor(new LoupGarouCommands(this));
		getCommand("loupGarouSetup").setExecutor(new LoupGarouSetupCommands(this));

		status = Status.waiting;
		logger.info("[LoupGarou] is enable !");	
	}

	@Override
	public void onDisable() {
		teams.removeHumain();
		teams.removeLoup();
		teams.removeSpectateur();
		
		logger.info("[LoupGarou] is disable !");
	}

}