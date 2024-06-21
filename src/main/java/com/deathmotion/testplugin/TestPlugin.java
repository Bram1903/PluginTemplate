package com.deathmotion.testplugin;

import com.deathmotion.testplugin.commands.TestCommand;
import com.deathmotion.testplugin.events.TestEvent;
import com.deathmotion.testplugin.packetlistener.TestListener;
import com.github.retrooper.packetevents.PacketEvents;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        RegisterPacketListeners();
        registerEvents();
        registerCommands();

        Bukkit.getConsoleSender().sendMessage(Component.text("The plugin has successfully been enabled!", NamedTextColor.GREEN));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Component.text("The plugin has successfully been disabled!", NamedTextColor.GREEN));
    }

    private void RegisterPacketListeners() {
        // Register your new packet listeners here
        PacketEvents.getAPI().getEventManager().registerListener(new TestListener());
    }

    private void registerEvents() {
        // Register your new events here
        new TestEvent(this);
    }

    private void registerCommands() {
        // Register your new commands here
        new TestCommand(this);
    }
}