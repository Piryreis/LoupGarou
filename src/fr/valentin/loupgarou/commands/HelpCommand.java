package fr.valentin.loupgarou.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import fr.valentin.loupgarou.LoupGarou;

public class HelpCommand implements CommandExecutor {

	private LoupGarou plugin;
	public HelpCommand(LoupGarou plugin) {
		this.plugin = plugin;
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player || sender instanceof ConsoleCommandSender) {
			if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
				sender.sendMessage("");
				sender.sendMessage("");
				sender.sendMessage(ChatColor.BOLD+""+ChatColor.GREEN+"=========="+ChatColor.GOLD+" Loup Garou "+ChatColor.BOLD+""+ChatColor.GREEN+"==========");
				sender.sendMessage(ChatColor.GRAY+"     - "+ChatColor.DARK_PURPLE+"Commandes :");
				sender.sendMessage(ChatColor.YELLOW+"/lg start"+ChatColor.GRAY+" : Démarre la partie.");
				sender.sendMessage(ChatColor.YELLOW+"/lg setup <spawn||spawnHumain||spawnLoup>"+ChatColor.GRAY+" : configure le setup.");
				sender.sendMessage("");
				sender.sendMessage(ChatColor.GRAY+"     - "+ChatColor.DARK_PURPLE+"Règles :");
				sender.sendMessage(ChatColor.AQUA+"Le but de chacun est d'envoyer une "
						+ "potion qui sera donnée sur l'adversaire pour qu'il rejoigne la team afin qu'une team soit réduite à 0 joueur. Pour récupérer des potions ou "
						+ "des blocks, il vous suffira de marcher sur votre spawn."+ChatColor.LIGHT_PURPLE+" Bon jeu !!!");
				sender.sendMessage("");
				sender.sendMessage(ChatColor.BOLD+""+ChatColor.GREEN+"=================================");

				plugin.getConfig().set(label, "test");
				
				return true;
			}

			return true;

		}

		return false;
	}

}
