package fr.valentin.loupgarou;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.valentin.loupgarou.commands.HelpCommand;
import fr.valentin.loupgarou.eventhandler.PlayerJoin;
import fr.valentin.loupgarou.items.Items;
import fr.valentin.loupgarou.status.Status;

public class LoupGarou extends JavaPlugin{

	private Logger logger;
	public PluginManager pm;
	public Items items;
	public static Status status;
	
	public void onEnable() {
		logger = this.getLogger();
		pm = getServer().getPluginManager();
		
		items = new Items(this);
		
		pm.registerEvents(new PlayerJoin(this), this);
		
		getCommand("LoupGarou").setExecutor(new HelpCommand(this));
		//getCommand("LoupGarou").setExecutor(new SetupCommand(this));
		
		status = Status.waiting;
		logger.info("[LoupGarou] is enable !");	
	}
	
	public void onDisable() {
		logger.info("[LoupGarou] is disable !");
	}
}
