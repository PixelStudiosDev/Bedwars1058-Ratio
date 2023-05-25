package me.leoo.bedwars.kd_fkd_wl;

import lombok.Getter;
import me.leoo.bedwars.kd_fkd_wl.papi.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Main extends JavaPlugin {

    @Getter
    private static Main plugin;

    private int bedwarsPlugin;

    public void onEnable() {
        plugin = this;

        if (Bukkit.getPluginManager().isPluginEnabled("BedWarsProxy")) {
            bedwarsPlugin = 1;
        }
        if (Bukkit.getPluginManager().isPluginEnabled("BedWars1058")) {
            bedwarsPlugin = 2;
        }
        if (bedwarsPlugin != 1 && bedwarsPlugin != 2) {
            getLogger().severe("Bedwars1058/BedwarsProxy plugin was not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().severe("PlaceholderAPI plugin was not found. Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        new Placeholders().register();

        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&a" + getDescription().getName() + " plugin by itz_leoo has been successfully enabled."));
    }

    public void onDisable() {
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&c" + getDescription().getName() + " plugin by itz_leoo has been successfully disabled."));
    }
}
