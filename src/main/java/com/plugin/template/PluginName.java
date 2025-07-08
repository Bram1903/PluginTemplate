package com.plugin.template;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginName extends JavaPlugin {

    @Getter
    private static PluginName instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Enabling plugin...");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling plugin...");
    }
}
