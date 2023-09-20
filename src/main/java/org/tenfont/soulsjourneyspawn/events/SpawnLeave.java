package org.tenfont.soulsjourneyspawn.events;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.tenfont.soulsjourneyspawn.util.RegionUtils;

import java.time.Duration;

public class SpawnLeave implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (!event.hasChangedBlock()) return;
        if (!RegionUtils.isLocationInsideSpawn(event.getFrom()) || RegionUtils.isLocationInsideSpawn(event.getTo())) return;
        Component title = Component.text("Leaving Spawn")
                .color(TextColor.fromHexString("#eb4034"))
                .decorate(TextDecoration.BOLD);
        Component subtitle = Component.text("You will no longer be protected.")
                .color(TextColor.fromHexString("#ffaaaa"));
        event.getPlayer().showTitle(Title.title(title, subtitle, Title.Times.times(
                Duration.ofMillis(500),
                Duration.ofSeconds(5),
                Duration.ofSeconds(1)
        )));
    }
}
