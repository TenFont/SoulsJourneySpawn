package org.tenfont.soulsjourneyspawn.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.tenfont.soulsjourneyspawn.SoulsJourneySpawn;

public class CmdSetSpawn implements CommandExecutor {
    private static final SoulsJourneySpawn plugin;

    static {
        plugin = SoulsJourneySpawn.getInstance();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cThis command can only be executed by players.");
            return true;
        }
        Location location = player.getLocation();
        plugin.getConfig().set("spawn-location", location);
        plugin.saveConfig();
        player.sendMessage("§aSuccessfully set the new spawn location.");
        return true;
    }
}
