package org.tenfont.soulsjourneyspawn.util;

import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;
import org.tenfont.soulsjourneyspawn.SoulsJourneySpawn;

public class RegionUtils {
    private static final SoulsJourneySpawn plugin;

    static {
        plugin = SoulsJourneySpawn.getInstance();
    }

    @SuppressWarnings("ConstantConditions")
    public static boolean isLocationInsideSpawn(Location location) {
        String regionID = plugin.getConfig().getString("spawn-region-name");
        ProtectedRegion spawnRegion = WorldGuard.getInstance().getPlatform().getRegionContainer().get(new BukkitWorld(location.getWorld())).getRegion(regionID);
        if (spawnRegion == null) {
            MessageUtils.log("&cThe region &e'" + regionID + "' &cdoes not exist!");
            return false;
        }
        return spawnRegion.contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }
}
