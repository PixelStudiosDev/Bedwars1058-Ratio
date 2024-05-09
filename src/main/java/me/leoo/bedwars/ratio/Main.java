package me.leoo.bedwars.ratio;

import lombok.Getter;
import me.leoo.bedwars.ratio.config.MainConfig;
import me.leoo.bedwars.ratio.papi.Placeholders;
import me.leoo.bedwars.ratio.utils.BedwarsMode;
import me.leoo.utils.bukkit.Utils;
import me.leoo.utils.bukkit.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getPluginManager;

@Getter
public class Main extends JavaPlugin {

    @Getter
    private static Main plugin;

    private BedwarsMode bedwarsMode;
    private ConfigManager mainConfig;

    @Override
    public void onEnable() {
        plugin = this;

        Utils.initialize(this);

        for (BedwarsMode mode : BedwarsMode.values()) {
            if (getPluginManager().isPluginEnabled(mode.getName())) {
                bedwarsMode = mode;

                getLogger().info("Hooked into " + mode.getName());
            }
        }

        if (bedwarsMode == null) {
            getLogger().info("Bedwars1058/BedwarsProxy not found. Disabling...");

            getPluginManager().disablePlugin(this);

            return;
        }

        mainConfig = new MainConfig("config", bedwarsMode.getPath());

        if (!getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            getLogger().severe("PlaceholderAPI plugin was not found. Disabling...");
            getPluginManager().disablePlugin(this);

            return;
        }

        new Placeholders().register();

        getLogger().info(getDescription().getName() + " plugin by itz_leoo has been successfully enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " plugin by itz_leoo has been successfully disabled.");
    }
}
