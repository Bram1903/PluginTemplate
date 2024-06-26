package com.deathmotion.testplugin.commands;

import io.github.retrooper.packetevents.util.SpigotConversionUtil;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor {

    public TestCommand(JavaPlugin plugin) {
        plugin.getCommand("test").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        com.github.retrooper.packetevents.protocol.item.ItemStack packetItem = SpigotConversionUtil.fromBukkitItemStack(item);
        item = SpigotConversionUtil.toBukkitItemStack(packetItem);

        sender.sendMessage("ItemStack has been converted to PacketEvents ItemStack and back to Bukkit ItemStack.");

        return true;
    }
}
