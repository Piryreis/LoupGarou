package fr.valentin.loupgarou.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import fr.valentin.loupgarou.LoupGarou;

public class SetupCommand implements CommandExecutor { 

	private LoupGarou plugin;
	public SetupCommand(LoupGarou plugin) {
		this.plugin = plugin;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Block block = player.getTargetBlock(null, 5);
			FileConfiguration config = new YamlConfiguration();
			if (args[0].equalsIgnoreCase("setup")) {

				if (args[0] != null) {
					player.sendMessage(/*préfixe+*/"Usage : /lg setup <spawn|spawnHumain|spawnLoup>");
					return true;
				}

				else if (args[1].equalsIgnoreCase("spawn")) {
					int x = block.getX();
					int y = block.getY();
					int z = block.getZ();
					Location location = new Location(player.getWorld(), x, y+1, z);
					//Spawn = location;
					config.set("Location.Spawn", location);
					block.setType(Material.BEACON);
				//	player.sendMessage(préfixe+"Spawn : x:"+x+" y:"+y+" z:"+z);
					return true;
				}

				else if (args[1].equalsIgnoreCase("spawnHumain")) {
					int x = block.getX();
					int y = block.getY();
					int z = block.getZ();
					Location location  = new Location(player.getWorld(), x, y+1, z);
					//SpawnHumain = location;
					block.setType(Material.STAINED_CLAY);
					block.setData((byte) 4);
					player.sendMessage(/*préfixe+*/"Spawn humain : x:"+x+" y:"+y+" z:"+z);
					return true;
				}

				else if (args[1].equalsIgnoreCase("spawnLoup")) {
					int x = block.getX();
					int y = block.getY();
					int z = block.getZ();
					Location location = new Location(player.getWorld(), x, y+1, z);
					//SpawnLoup = location;
					block.setType(Material.STAINED_CLAY);
					block.setData((byte) 11);
					player.sendMessage(/*préfixe+*/"Spawn loup : x:"+x+" y:"+y+" z:"+z);
					return true;
				}
				return true;
			}
		}
		return false;
	}

}
