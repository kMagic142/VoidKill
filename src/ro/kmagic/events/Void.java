package ro.kmagic.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ro.kmagic.main.Main;
import ro.kmagic.utils.Utils;

public class Void implements Listener {
    private static Main plugin;
    public Utils utils;

    public Void(Main plugin) {
        Void.plugin = plugin;
        this.utils = new Utils();
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(ignoreCancelled=true)
    public void onVoidEnter(PlayerMoveEvent e) {
        if (e.getTo().getBlockY() < Void.plugin.getConfig().getInt("YLimit")) {
            if (plugin.dead.contains(e.getPlayer().getName())) {
                return;
            }
            else {
                plugin.dead.add(e.getPlayer().getName());
            }
            e.getPlayer().setHealth(0.0D);
            Player p = e.getPlayer();
            if (Void.plugin.getConfig().getString("dead_message").equals("")) {
                return;
            }
            else {
                p.sendMessage(this.utils.chat(Void.plugin.getConfig().getString("dead_message")));
            }
        }
        else {
            if(plugin.dead.contains(e.getPlayer().getName())) {
                plugin.dead.remove(e.getPlayer().getName());
            }
        }
    }

}
