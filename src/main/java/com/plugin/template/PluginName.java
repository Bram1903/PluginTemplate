package com.plugin.template;

import com.plugin.template.commands.HelloCommand;
import com.plugin.template.events.PlayerJoinListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginName extends JavaPlugin {

    @Getter
    private static PluginName instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Enabling plugin...");

        // Register events
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        // Register commands
        getCommand("hello").setExecutor(new HelloCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling plugin...");
    }
}
