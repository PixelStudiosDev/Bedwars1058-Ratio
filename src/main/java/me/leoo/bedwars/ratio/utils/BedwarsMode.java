package me.leoo.bedwars.ratio.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BedwarsMode {
    BEDWARS("BedWars1058"), PROXY("BedWarsProxy");

    private final String name;

    public String getPath() {
        return "plugins/" + name + "/Addons/Ratio";
    }
}
