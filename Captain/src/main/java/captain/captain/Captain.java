package captain.captain;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Captain extends JavaPlugin {
    public static Captain cap;
    private FileConfiguration fileConfiguration;
    @Override
    public void onEnable() {
        this.getCommand("comcaptain").setExecutor(new ComCaptain());
        this.getServer().getPluginManager().registerEvents(new InventoryListener(),this);
        cap = this;
        fileConfiguration = this.getConfig();
        fileConfiguration.options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }
}
