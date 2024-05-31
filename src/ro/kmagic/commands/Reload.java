package ro.kmagic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ro.kmagic.main.Main;
import ro.kmagic.utils.Utils;

public class Reload implements CommandExecutor {
    private Main plugin;
    public Utils utils;

    public Reload(Main plugin) {
        this.plugin = plugin;
        this.utils = new Utils();
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You cannot execute commands from the console!");
            return true;
        }
        final Player p = (Player)sender;

        if (args.length == 0) {
            p.sendMessage(this.utils.chat("&f&l&m-------------&e VoidKill &f&l&m-------------\n&f \n&fCreated by &ekMagic &f(Version: &e1.0&f)\n&fType &e/voidkill help &ffor more commands.\n&f \n&f&l&m--------------------------------"));
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
            p.sendMessage(this.utils.chat("&f&l&m-------------&e VoidKill &f&l&m-------------\n&f \n&e/voidkill reload &f- Reloads plugin configs.\n&f \n&f&l&m--------------------------------"));
        }

        if (p.hasPermission("voidkill.reload")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                Main.getInstance().reloadConfig();
                p.sendMessage(this.utils.chat(this.plugin.getConfig().getString("reload_message")));
            }
        }
        else {
            p.sendMessage(this.utils.chat(this.plugin.getConfig().getString("noperm_message")));
        }
        return false;
    }
}