package fr.valentin.loupgarou.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.valentin.loupgarou.LoupGarou;

public class LoupGarouCommands implements CommandExecutor {

	private LoupGarou plugin;
	public LoupGarouCommands(LoupGarou plugin) {
		this.plugin = plugin;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("LoupGarou")) {
			if(sender instanceof Player || sender instanceof ConsoleCommandSender) {

				//-- Help Command --------------------------------------------------------------------------------------------

				if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
					sender.sendMessage("");
					sender.sendMessage("");
					sender.sendMessage(ChatColor.BOLD+""+ChatColor.GREEN+"=========="+ChatColor.GOLD+" Loup Garou "+ChatColor.BOLD+""+ChatColor.GREEN+"==========");
					sender.sendMessage(ChatColor.GRAY+"     - "+ChatColor.DARK_PURPLE+"Commandes :");
					sender.sendMessage(ChatColor.YELLOW+"/lg start"+ChatColor.GRAY+" : Démarre la partie.");
					sender.sendMessage(ChatColor.YELLOW+"/lgs <spawn|spawnHumain|spawnLoup>"+ChatColor.GRAY+" : Permet de configurer le setup.");
					sender.sendMessage("");
					sender.sendMessage(ChatColor.GRAY+"     - "+ChatColor.DARK_PURPLE+"Règles :");
					sender.sendMessage(ChatColor.AQUA+"Le but de chacun est d'envoyer une "
							+ "potion qui sera donnée sur l'adversaire pour qu'il rejoigne la team afin qu'une team soit réduite à 0 joueur. Pour récupérer des potions ou "
							+ "des blocks, il vous suffira de marcher sur votre spawn."+ChatColor.LIGHT_PURPLE+" Bon jeu !!!");
					sender.sendMessage("");
					sender.sendMessage(ChatColor.BOLD+""+ChatColor.GREEN+"=================================");

					return true;
				} 

				// -- Start Command ----------------------------------------------------------------------------------------------		

				else if(args.length == 1 && args[0].equalsIgnoreCase("start")) {
					if (plugin.loupGarouSetupCommands.getSpawn() == null || plugin.loupGarouSetupCommands.getSpawnHumain() == null || plugin.loupGarouSetupCommands.getSpawnLoup() == null) {
						sender.sendMessage(plugin.Tag+ChatColor.RED+"Setup non configuré !  Impossible de lancer la partie.");
						return true;
					}

					if (plugin.teams.nmbHumain() == 0 || plugin.teams.nmbLoup() == 0) {
						sender.sendMessage(ChatColor.RED+"Il faut au moins 1 joueur dans chaque teams.");
						return true;
					}

					else {
						plugin.start.StartGame();					
						return true;
					}

				} else {
					sender.sendMessage(plugin.Tag+command.getUsage());	
					return true;
				}
			}
			return true;
		}
		return false;
	}
	
}
