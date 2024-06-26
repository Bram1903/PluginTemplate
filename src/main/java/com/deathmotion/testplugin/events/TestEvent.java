package com.deathmotion.testplugin.events;

import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TestEvent implements Listener {

    public TestEvent(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();

        World world = entity.getWorld();
        int entityId = entity.getEntityId();

        Entity retrievedEntity = SpigotConversionUtil.getEntityById(world, entityId);

        if (retrievedEntity != null) {
            Bukkit.getConsoleSender().sendMessage("Entity with ID " + entityId + " has been retrieved through the conversion utility.");
        } else {
            Bukkit.getConsoleSender().sendMessage("Entity with ID " + entityId + " could not be retrieved through the conversion utility.");
        }
    }
}
