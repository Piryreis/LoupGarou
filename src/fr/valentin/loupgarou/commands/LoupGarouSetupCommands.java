package fr.valentin.loupgarou.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.valentin.loupgarou.LoupGarou;

public class LoupGarouSetupCommands implements CommandExecutor {

	private LoupGarou plugin;
	public LoupGarouSetupCommands(LoupGarou plugin) {
		this.plugin = plugin;
	}


	private Location Spawn;
	public Location getSpawn() {
		return Spawn;
	}
	private Location SpawnHumain;
	public Location getSpawnHumain() {
		return SpawnHumain;
	}
	private Location SpawnLoup;
	public Location getSpawnLoup() {
		return SpawnLoup;
	}

	@Override @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("LoupGarouSetup")) {
			if (sender instanceof Player) {

				Player player = (Player) sender;
				Block block = player.getTargetBlock(null, 5);

				if (!(player.isOp())) {
					player.sendMessage(plugin.Tag+ChatColor.DARK_RED+"Vous devez être Op.");
					return true;
				}

				else if (args.length == 1 && args[0].equalsIgnoreCase("spawn")) {
					Location location = new Location(player.getWorld(), block.getX(), block.getY(), block.getZ());
					Spawn = location;
					block.setType(Material.BEACON);
					player.sendMessage(plugin.Tag+ChatColor.GRAY+"Spawn : x:"+location.getBlockX()+" y:"+location.getBlockY()+" z:"+location.getBlockZ());
					return true;
				}
				else if (args.length == 1 && args[0].equalsIgnoreCase("spawnHumain")) {
					Location location = new Location(player.getWorld(), block.getX(), block.getY(), block.getZ());
					SpawnHumain = location;
					block.setType(Material.STAINED_CLAY);
					block.setData((byte) 4);
					player.sendMessage(plugin.Tag+ChatColor.GRAY+"Spawn Humain : x:"+location.getBlockX()+" y:"+location.getBlockY()+" z:"+location.getBlockZ());
					return true;
				}
				else if (args.length == 1 && args[0].equalsIgnoreCase("spawnLoup")) {
					Location location = new Location(player.getWorld(), block.getX(), block.getY(), block.getZ());
					SpawnLoup = location;
					block.setType(Material.STAINED_CLAY);
					block.setData((byte) 11);
					player.sendMessage(plugin.Tag+ChatColor.GRAY+"Spawn Loup : x:"+location.getBlockX()+" y:"+location.getBlockY()+" z:"+location.getBlockZ());
					return true;
				}

				else if (args.length == 0 || !(args[0].equalsIgnoreCase("spawn")) || !(args[0].equalsIgnoreCase("spawnHumain")) || !(args[0].equalsIgnoreCase("spawnLoup"))) {
					player.sendMessage(plugin.Tag+command.getUsage());
					return true;
				}
				return true;
			} else {
				sender.sendMessage(ChatColor.DARK_RED+"Cette commande ne peut être éxécuter que part un joueur.");
			}
			return true;
		}
		return false;
	}

}
