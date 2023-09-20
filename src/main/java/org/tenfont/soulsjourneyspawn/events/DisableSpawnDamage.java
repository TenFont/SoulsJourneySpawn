package org.tenfont.soulsjourneyspawn.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.tenfont.soulsjourneyspawn.util.RegionUtils;

public class DisableSpawnDamage implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!RegionUtils.isLocationInsideSpawn(player.getLocation())) return;
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            event.setCancelled(true);
        }
        else if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            EntityDamageByEntityEvent damageByEntityEvent = (EntityDamageByEntityEvent) event;
            if (!(damageByEntityEvent.getDamager() instanceof Player attacker)) return;
            attacker.sendMessage("§cYou cannot PVP at spawn.");
            event.setCancelled(true);
        }
    }
}
