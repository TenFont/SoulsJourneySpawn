package org.tenfont.soulsjourneyspawn.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.tenfont.soulsjourneyspawn.util.RegionUtils;

public class SlowFall implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!event.hasChangedBlock()) return;
        Block blockBelow = event.getTo().getBlock().getRelative(BlockFace.DOWN);
        if (!RegionUtils.isLocationInsideSpawn(event.getTo())) return;
        if (blockBelow.getType() == Material.BEDROCK) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 600, 0, false, false, false));
        } else if (blockBelow.getType() != Material.AIR || event.getPlayer().isSneaking()) {
            event.getPlayer().removePotionEffect(PotionEffectType.SLOW_FALLING);
        }
    }
}
