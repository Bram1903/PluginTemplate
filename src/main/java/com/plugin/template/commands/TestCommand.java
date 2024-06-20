package com.plugin.template.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {

    public TestCommand(JavaPlugin plugin) {
        plugin.getCommand("test").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Component.text("Hello Console!", NamedTextColor.GREEN));
            return true;
        }

        sender.sendMessage(Component.text("Hello Player!", NamedTextColor.GREEN));
        return true;
    }
}
