package captain.captain;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class ComCaptain implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            openInventory((Player) sender);
        }else{
            sender.sendMessage("§6Only player can execute this command");
        }
        return true;
    }
    private static void openInventory(Player p){
        Inventory gui = Bukkit.createInventory(null,27,"§6Kaptan");
        ItemStack trepson = new ItemStack(Material.DIRT);
        ItemMeta trepsonMeta = trepson.getItemMeta();
        trepsonMeta.setDisplayName("§6Trepson");
        ArrayList<String>trepsonLore = new ArrayList<>();
        trepsonLore.add("");
        trepsonLore.add("§oBurda genelde Çam ağaçları olur");
        trepsonLore.add("§oEvet, evet.. o büyük çam ağaçları");
        trepsonLore.add("§oHbenden duymuş olmayın \"pek tekin bir yer değil\"");
        trepsonLore.add("");
        trepsonLore.add("§2Trepson'a §a§o§ngitmek için tıkla§4!");
        trepsonMeta.setLore(trepsonLore);
        trepson.setItemMeta(trepsonMeta);

        ItemStack yumont = new ItemStack(Material.DIRT);
        ItemMeta yumontMeta = yumont.getItemMeta();
        yumontMeta.setDisplayName("§6Yumont");
        ArrayList<String> yumontLore = new ArrayList<>();
        yumontLore.add("");
        yumontLore.add("§oSunucunun en güzel diyarı.");
        yumontLore.add("§oOrmanlar, Dağlar, Apaçlar.");
        yumontLore.add("§oHepsi birbirinden güzel...");
        yumontLore.add("");
        yumontLore.add("§2Yumont'a §a§o§ngitmek için tıkla");
        yumontMeta.setLore(yumontLore);
        yumont.setItemMeta(yumontMeta);

        ItemStack nether = new ItemStack(Material.NETHERRACK);
        ItemMeta netherMeta = nether.getItemMeta();
        netherMeta.setDisplayName("§cNether");
        ArrayList<String> netherLore = new ArrayList<>();
        netherLore.add("§4Nether Ne Değildir :D?");
        netherLore.add("");
        netherLore.add("§cNether'e Gitmek İçin Tıkla !");
        netherMeta.setLore(netherLore);
        nether.setItemMeta(netherMeta);

        gui.setItem(13,trepson);
        gui.setItem(11,yumont);
        gui.setItem(15,nether);

        p.openInventory(gui);

    }
}

