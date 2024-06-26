package com.deathmotion.testplugin;

import com.deathmotion.testplugin.commands.TestCommand;
import com.deathmotion.testplugin.events.TestEvent;
import com.deathmotion.testplugin.packetlistener.TestListener;
import com.github.retrooper.packetevents.PacketEvents;
import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        RegisterPacketListeners();
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
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