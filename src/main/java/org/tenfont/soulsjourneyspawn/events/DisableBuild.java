package org.tenfont.soulsjourneyspawn.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
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
}
