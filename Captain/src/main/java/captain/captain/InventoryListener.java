package captain.captain;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class InventoryListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getView().getTitle().equals("§6Kaptan")){
            Random rd = new Random();
            Captain main = Captain.cap;
            FileConfiguration config = main.getFileConfiguration();
            ItemStack clickedItem = e.getCurrentItem();
            if (clickedItem.getType() == Material.DIRT && clickedItem.getItemMeta().getDisplayName().equals("§6Trepson")){
                if (config.contains(e.getWhoClicked().getUniqueId().toString() +".Trepson")){
                    int locX = config.getInt(e.getWhoClicked().getUniqueId().toString() + ".Trepson.X");
                    int locZ = config.getInt(e.getWhoClicked().getUniqueId().toString() + ".Trepson.Z");
                    int locY = config.getInt(e.getWhoClicked().getUniqueId().toString() + ".Trepson.Y");
                    Location loc = new Location(Bukkit.getWorld("Trepson"),locX,locY,locZ);
                    e.getWhoClicked().teleport(loc);
                }else{
                    int locX = rd.nextInt(60000)-30000;
                    int locZ = rd.nextInt(60000)-30000;
                    int locY = 257;
                    Location loc = new Location(Bukkit.getWorld("Trepson"),locX,locY,locZ);
                    Material item;
                    do {
                        loc.add(0,-1,0);
                        locY--;
                        item = loc.getBlock().getType();
                    }while (item.isAir());
                    e.getWhoClicked().teleport(loc);
                    config.addDefault(e.getWhoClicked().getUniqueId().toString() + ".Trepson.X",locX);
                    config.addDefault(e.getWhoClicked().getUniqueId().toString() + ".Trepson.Y",locY);
                    config.addDefault(e.getWhoClicked().getUniqueId().toString() + ".Trepson.Z",locZ);
                    config.options().copyDefaults(true);
                    main.saveConfig();
                }
                e.setCancelled(true);
                return;
            }
            if (clickedItem.getType() == Material.DIRT && clickedItem.getItemMeta().getDisplayName().equals("§6Yumont")){
                if (config.contains(e.getWhoClicked().getUniqueId().toString() +".Yumont")){
                    int locX = config.getInt(e.getWhoClicked().getUniqueId().toString() + ".Yumont.X");
                    int locZ = config.getInt(e.getWhoClicked().getUniqueId().toString() + ".Yumont.Z");
                    int locY = config.getInt(e.getWhoClicked().getUniqueId().toString() + ".Yumont.Y");
                    Location loc = new Location(Bukkit.getWorld("Yumont"),locX,locY,locZ);
                    e.getWhoClicked().teleport(loc);
                }else{
                    int locX = rd.nextInt(60000)-30000;
                    int locZ = rd.nextInt(60000)-30000;
                    int locY = 257;
                    Location loc = new Location(Bukkit.getWorld("Yumont"),locX,locY,locZ);
                    Material item;
                    do {
                        loc.add(0,-1,0);
                        locY--;
                        item = loc.getBlock().getType();
                    }while (item.isAir());
                    e.getWhoClicked().teleport(loc);
                    config.addDefault(e.getWhoClicked().getUniqueId().toString() + ".Yumont.X",locX);
                    config.addDefault(e.getWhoClicked().getUniqueId().toString() + ".Yumont.Y",locY);
                    config.addDefault(e.getWhoClicked().getUniqueId().toString() + ".Yumont.Z",locZ);
                    config.options().copyDefaults(true);
                    main.saveConfig();
                }
                e.setCancelled(true);
                return;
            }
            if (clickedItem.getType() == Material.NETHERRACK){
                Location loc = new Location(Bukkit.getWorld("Nether"),786,35,11033);
                e.getWhoClicked().teleport(loc);
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
    }
}
