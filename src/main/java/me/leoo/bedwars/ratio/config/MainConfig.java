package me.leoo.bedwars.ratio.config;

import me.leoo.utils.bukkit.config.ConfigManager;

public class MainConfig extends ConfigManager {

    public MainConfig(String name, String directory) {
        super(name, directory);

        add("ratio.placeholders.null-text", "Nan");
    }
}
