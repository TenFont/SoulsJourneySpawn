package org.tenfont.soulsjourneyspawn.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.tenfont.soulsjourneyspawn.util.RegionUtils;

public class DisableSpawnMobSpawning implements Listener {
    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.COMMAND) return;
        if (RegionUtils.isLocationInsideSpawn(event.getLocation())) event.setCancelled(true);
    }
}
