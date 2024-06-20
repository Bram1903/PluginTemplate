package com.plugin.template;

import com.plugin.template.commands.TestCommand;
import com.plugin.template.events.TestEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        registerEvents();
        registerCommands();

        Bukkit.getConsoleSender().sendMessage(Component.text("The plugin has successfully been enabled!", NamedTextColor.GREEN));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Component.text("The plugin has successfully been disabled!", NamedTextColor.GREEN));
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