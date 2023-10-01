package org.tenfont.soulsjourneyspawn.events;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.tenfont.soulsjourneyspawn.util.RegionUtils;

public class DisableBuild implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (RegionUtils.isLocationInsideSpawn(event.getBlock().getLocation()) && !event.getPlayer().hasPermission("soulsjourneyspawn.admin"))
            event.setCancelled(true);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (RegionUtils.isLocationInsideSpawn(event.getBlock().getLocation()) && !event.getPlayer().hasPermission("soulsjourneyspawn.admin"))
            event.setCancelled(true);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        if (block == null) return;
        if (RegionUtils.isLocationInsideSpawn(block.getLocation()) && !event.getPlayer().hasPermission("soulsjourneyspawn.admin"))
            event.setCancelled(true);
    }
}
