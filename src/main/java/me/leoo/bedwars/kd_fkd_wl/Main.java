package me.leoo.bedwars.kd_fkd_wl;

import lombok.Getter;
import me.leoo.bedwars.kd_fkd_wl.papi.Placeholders;
import me.leoo.bedwars.kd_fkd_wl.utils.BedwarsMode;
import me.leoo.utils.bukkit.Utils;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getPluginManager;

@Getter
public class Main extends JavaPlugin {

    @Getter
    private static Main plugin;

    private BedwarsMode bedwarsMode;

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


        if (getPluginManager().isPluginEnabled("PlaceholderAPI")) {
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
