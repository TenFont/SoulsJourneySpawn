package org.tenfont.soulsjourneyspawn;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.tenfont.soulsjourneyspawn.commands.CmdSetSpawn;
import org.tenfont.soulsjourneyspawn.commands.CmdSpawn;
import org.tenfont.soulsjourneyspawn.events.DisableSpawnDamage;
import org.tenfont.soulsjourneyspawn.events.DisableSpawnMobSpawning;
import org.tenfont.soulsjourneyspawn.events.SlowFall;
import org.tenfont.soulsjourneyspawn.events.SpawnLeave;
import org.tenfont.soulsjourneyspawn.util.MessageUtils;

public final class SoulsJourneySpawn extends JavaPlugin {
    @Getter
    private static SoulsJourneySpawn instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        // Load elements
        getCommand("setspawn").setExecutor(new CmdSetSpawn());
        getCommand("spawn").setExecutor(new CmdSpawn());

        Bukkit.getPluginManager().registerEvents(new DisableSpawnDamage(), this);
        Bukkit.getPluginManager().registerEvents(new DisableSpawnMobSpawning(), this);
        Bukkit.getPluginManager().registerEvents(new SlowFall(), this);
        Bukkit.getPluginManager().registerEvents(new SpawnLeave(), this);

        MessageUtils.log("&aPlugin successfully enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MessageUtils.log("&cPlugin disabled.");
    }
}
