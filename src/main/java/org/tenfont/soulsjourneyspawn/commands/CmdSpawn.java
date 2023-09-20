package org.tenfont.soulsjourneyspawn.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.tenfont.soulsjourneyspawn.SoulsJourneySpawn;

public class CmdSpawn implements CommandExecutor {
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
        if (!plugin.getConfig().contains("spawn-location")) {
            sender.sendMessage("§cThe spawn location is not set.");
            return true;
        }
        Location location = plugin.getConfig().getLocation("spawn-location");
        player.teleport(location);
        return true;
    }
}
