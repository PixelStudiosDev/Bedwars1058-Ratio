package me.leoo.bedwars.kd_fkd_wl.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BedwarsMode {
    BEDWARS("BedWars1058"), PROXY("BedWarsProxy");

    private final String name;
}
