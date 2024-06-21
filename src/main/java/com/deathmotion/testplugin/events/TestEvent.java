package com.deathmotion.testplugin.events;

import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TestEvent implements Listener {

    private final JavaPlugin plugin;

    public TestEvent(JavaPlugin plugin) {
        this.plugin = plugin;

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerJoin(EntitySpawnEvent event) {
        Entity entity = event.getEntity();

        World world = entity.getWorld();
        int entityId = entity.getEntityId();

        Entity retrievedEntity = SpigotConversionUtil.getEntityById(world, entityId);

        if (retrievedEntity != null) {
            Bukkit.getConsoleSender().sendMessage(Component.text("Entity with ID " + entityId + " has been retrieved through the conversion utility.", NamedTextColor.GREEN));
        }
    }
}
