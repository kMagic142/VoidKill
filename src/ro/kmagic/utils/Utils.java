package ro.kmagic.utils;

import org.bukkit.ChatColor;

public class Utils {
    public String chat(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}