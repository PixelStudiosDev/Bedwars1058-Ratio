package me.leoo.bedwars.kd_fkd_wl.papi;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.proxy.BedWarsProxy;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.leoo.bedwars.kd_fkd_wl.Main;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class Placeholders extends PlaceholderExpansion {
    @NotNull
    public String getAuthor() {
        return "itz_leoo";
    }

    @NotNull
    public String getIdentifier() {
        return "bw1058stats";
    }

    @NotNull
    public String getVersion() {
        return Main.getPlugin().getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    public String onRequest(OfflinePlayer player, String params) {
        DecimalFormat decimalFormat = new DecimalFormat("#####.##");

        if (params.equalsIgnoreCase("kdr")) {
            if (Main.getPlugin().getBedwarsPlugin() == 1) {
                return decimalFormat.format(BedWarsProxy.getStatsCache().getPlayerKills(player.getUniqueId()) / BedWarsProxy.getStatsCache().getPlayerDeaths(player.getUniqueId()));
            }
            return decimalFormat.format(BedWars.getStatsManager().get(player.getUniqueId()).getKills() / BedWars.getStatsManager().get(player.getUniqueId()).getDeaths());
        }
        if (params.equalsIgnoreCase("fkdr")) {
            if (Main.getPlugin().getBedwarsPlugin() == 1) {
                return decimalFormat.format(BedWarsProxy.getStatsCache().getPlayerFinalKills(player.getUniqueId()) / BedWarsProxy.getStatsCache().getPlayerFinalDeaths(player.getUniqueId()));
            }
            return decimalFormat.format(BedWars.getStatsManager().get(player.getUniqueId()).getFinalKills() / BedWars.getStatsManager().get(player.getUniqueId()).getFinalDeaths());
        }
        if (params.equalsIgnoreCase("wlr")) {
            if (Main.getPlugin().getBedwarsPlugin() == 1) {
                return decimalFormat.format(BedWarsProxy.getStatsCache().getPlayerWins(player.getUniqueId()) / BedWarsProxy.getStatsCache().getPlayerLoses(player.getUniqueId()));
            }
            return decimalFormat.format(BedWars.getStatsManager().get(player.getUniqueId()).getWins() / BedWars.getStatsManager().get(player.getUniqueId()).getLosses());
        }

        return null;
    }
}