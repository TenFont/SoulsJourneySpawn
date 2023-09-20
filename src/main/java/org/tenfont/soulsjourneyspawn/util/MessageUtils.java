package org.tenfont.soulsjourneyspawn.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MessageUtils {
    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage("§8[§6SoulsJourneySpawn§8] §r" + ChatColor.translateAlternateColorCodes('&', message));
    }
}
