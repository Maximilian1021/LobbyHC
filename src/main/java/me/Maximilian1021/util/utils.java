package me.Maximilian1021.util;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.Maximilian1021.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class utils {

    public static void sendToBungeeServer(Player player, String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(serverName);
        player.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", out.toByteArray());
    }

    public static ItemStack getNavigator() {
        ItemStack itemStack = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName("§6Navigator");
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add("§7Navigiere schneller zum Server");
        itemMeta.setLore(itemLore);
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static Inventory getNavMenu() {


        Inventory inventory = Bukkit.createInventory(null, 27, getNavTitle());

//        for (ItemStack i : i1) {
//            ItemStack Glass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
//            inventory.setItem(i, Glass);
//
//        }

        inventory.setItem(9 , getNavItem("HC1 - 1.14.1"));
        inventory.setItem(11, getNavItem("HC2 - 1.8.8"));
        inventory.setItem(13, getNavItem("Spawn"));
        inventory.setItem(15, getNavItem("HC3 - 1.16.4"));
        inventory.setItem(17, getNavItem("Coming Soon"));
        return inventory;
    }

    public static String getNavTitle() {
        return "§6Navigator Menu";
    }

    public static ItemStack getNavItem(String name) {
        ItemStack itemStack;
        ItemMeta itemMeta;
        switch (name) {
            case "Spawn":
                itemStack = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzk1ZDM3OTkzZTU5NDA4MjY3ODQ3MmJmOWQ4NjgyMzQxM2MyNTBkNDMzMmEyYzdkOGM1MmRlNDk3NmIzNjIifX19");
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§6Spawn");
                itemStack.setItemMeta(itemMeta);
                break;
            case "HC1 - 1.14.1":
                itemStack = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzFhOTQ2M2ZkM2M0MzNkNWUxZDlmZWM2ZDVkNGIwOWE4M2E5NzBiMGI3NGRkNTQ2Y2U2N2E3MzM0OGNhYWIifX19");
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§bHC1 - §n1.14.1");
                itemStack.setItemMeta(itemMeta);
                break;
            case "HC2 - 1.8.8":
                itemStack = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFjYThkM2JkYTEzMjViYTJkZGNhYTlhYTE1YWY3Mzk5MWI5MjkxODY2MGI2OTQ2MjA3YmIwYjRjMGJkZDYifX19");
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§bHC2 - §n1.8.8");
                itemStack.setItemMeta(itemMeta);
                break;
            case "HC3 - 1.16.4":
                itemStack = getHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTUxYzZkYTQ2Zjc1ODViZjJmZDVjYTQ0YzRhYmVjNTY4YzIzZWFmNjdjM2Y2ODFjZDJiYzFiM2ViMjc1YSJ9fX0=");
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§bHC3 - §n1.16.4");
                itemStack.setItemMeta(itemMeta);
                break;
            case "Coming Soon":
                itemStack = new ItemStack(Material.BARRIER);
                itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName("§bComing Soon");
                itemStack.setItemMeta(itemMeta);
                break;
            default:
                itemStack = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
                break;
        }

        return itemStack;
    }

    public   static ItemStack getHead(String value) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short)3);
        UUID hashAsId = new UUID(value.hashCode(), value.hashCode());
        return Bukkit.getUnsafe().modifyItemStack(skull,
                "{SkullOwner:{Id:\"" + hashAsId + "\",Properties:{textures:[{Value:\"" + value + "\"}]}}}"
        );
    }


}