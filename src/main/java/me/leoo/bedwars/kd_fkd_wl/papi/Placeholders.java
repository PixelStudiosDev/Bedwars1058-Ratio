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
                double deaths = BedWarsProxy.getStatsCache().getPlayerDeaths(player.getUniqueId());
                if(deaths != 0){
                    return decimalFormat.format(BedWarsProxy.getStatsCache().getPlayerKills(player.getUniqueId()) / deaths);
                }
            }
            double deaths = BedWars.getStatsManager().get(player.getUniqueId()).getDeaths();
            if(deaths != 0){
                return decimalFormat.format(BedWars.getStatsManager().get(player.getUniqueId()).getKills() / deaths);
            }
        }
        if (params.equalsIgnoreCase("fkdr")) {
            if (Main.getPlugin().getBedwarsPlugin() == 1) {
                double finalDeaths = BedWarsProxy.getStatsCache().getPlayerFinalDeaths(player.getUniqueId());
                if(finalDeaths != 0){
                    return decimalFormat.format(BedWarsProxy.getStatsCache().getPlayerFinalKills(player.getUniqueId()) / finalDeaths);
                }
            }

            double finalDeaths = BedWars.getStatsManager().get(player.getUniqueId()).getFinalDeaths();
            if(finalDeaths != 0){
                return decimalFormat.format(BedWars.getStatsManager().get(player.getUniqueId()).getFinalKills() / finalDeaths);
            }
        }
        if (params.equalsIgnoreCase("wlr")) {
            if (Main.getPlugin().getBedwarsPlugin() == 1) {
                double lose = BedWarsProxy.getStatsCache().getPlayerLoses(player.getUniqueId());
                if(lose != 0){
                    return decimalFormat.format(BedWarsProxy.getStatsCache().getPlayerWins(player.getUniqueId()) / lose);
                }
            }

            double lose = BedWars.getStatsManager().get(player.getUniqueId()).getLosses();
            if(lose != 0){
                return decimalFormat.format(BedWars.getStatsManager().get(player.getUniqueId()).getWins() / lose);
            }
        }

        return "NaN";
    }
}