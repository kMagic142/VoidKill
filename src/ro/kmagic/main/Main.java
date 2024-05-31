package ro.kmagic.main;

import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ro.kmagic.commands.Reload;
import ro.kmagic.events.Void;
import ro.kmagic.utils.Utils;

public class Main
        extends JavaPlugin
        implements Listener
{
    public Utils utils;
    public static Main instance;

    public void onEnable()
    {
        this.loadConfig();
        this.utils = new Utils();
        instance = this;
        Reload comandaReload = new Reload(this);
        getCommand("voidkill").setExecutor(comandaReload);
        new Void(this);
    }

    public void loadConfig()
    {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
    }

    public static Main getInstance()
    {
        return instance;
    }

    public ArrayList<String> dead = new ArrayList<>();
}