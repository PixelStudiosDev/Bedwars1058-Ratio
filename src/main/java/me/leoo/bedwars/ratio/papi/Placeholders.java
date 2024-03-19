package me.leoo.bedwars.ratio.papi;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.proxy.BedWarsProxy;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.leoo.bedwars.ratio.Main;
import me.leoo.bedwars.ratio.utils.BedwarsMode;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

public class Placeholders extends PlaceholderExpansion {

    private static final BedwarsMode MODE = Main.getPlugin().getBedwarsMode();

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

            double kills;
            double deaths;

            if (MODE == BedwarsMode.PROXY) {
                kills = BedWarsProxy.getStatsCache().getPlayerKills(player.getUniqueId());
                deaths = BedWarsProxy.getStatsCache().getPlayerDeaths(player.getUniqueId());
            } else {
                kills = BedWars.getStatsManager().get(player.getUniqueId()).getKills();
                deaths = BedWars.getStatsManager().get(player.getUniqueId()).getDeaths();
            }

            if (deaths != 0) {
                return decimalFormat.format(kills / deaths);
            }
        }

        if (params.equalsIgnoreCase("fkdr")) {
            double finalDeaths;
            double finalKills;

            if (MODE == BedwarsMode.PROXY) {
                finalDeaths = BedWarsProxy.getStatsCache().getPlayerFinalDeaths(player.getUniqueId());
                finalKills = BedWarsProxy.getStatsCache().getPlayerFinalKills(player.getUniqueId());
            } else {
                finalDeaths = BedWars.getStatsManager().get(player.getUniqueId()).getFinalDeaths();
                finalKills = BedWars.getStatsManager().get(player.getUniqueId()).getFinalKills();
            }

            if (finalDeaths != 0) {
                return decimalFormat.format(finalKills / finalDeaths);
            }
        }

        if (params.equalsIgnoreCase("wlr")) {
            double lose;
            double wins;

            if (MODE == BedwarsMode.PROXY) {
                lose = BedWarsProxy.getStatsCache().getPlayerLoses(player.getUniqueId());
                wins = BedWarsProxy.getStatsCache().getPlayerWins(player.getUniqueId());
            } else {
                lose = BedWars.getStatsManager().get(player.getUniqueId()).getLosses();
                wins = BedWars.getStatsManager().get(player.getUniqueId()).getWins();
            }

            if (lose != 0) {
                return decimalFormat.format(wins / lose);
            }
        }

        return "NaN";
    }
}