package me.Maximilian1021.events;


import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import me.Maximilian1021.util.filemanager;
import me.Maximilian1021.util.utils;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;



import java.io.File;

import static org.bukkit.configuration.file.YamlConfiguration.loadConfiguration;

public class Events implements Listener {


    private File file = filemanager.getLangFile();
    private FileConfiguration lang = loadConfiguration(file);
    private String language = lang.getString("Language");

    private String prefix = lang.getString(language + ".Prefix");

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        PlayerManager playerManager = GadgetsMenuAPI.getPlayerManager(e.getPlayer());

        playerManager.addMysteryDust(2500);
        Player p = e.getPlayer();
        Player M = Bukkit.getPlayer("Maximilian1021");
        World world = Bukkit.getWorld("world");
        Location loc = new Location(world, 258.5, 204, -62.5);



        p.getInventory().setItem(2  ,utils.getNavigator());

        p.setPlayerListHeader("§k!i!i   §cMinecraft Hardcore Network   §r§k!i!i!");
        p.setPlayerListFooter("§7+++ §bNetwork hosted by §6§lMaximilian1021  §7+++");

        p.teleport(loc);
        e.setJoinMessage("§a+ §b " + e.getPlayer().getName());


        if (p.hasPermission("tab.admin")) {
            e.getPlayer().setPlayerListName("§4 Admin §8| §b" + p.getName());
        } else if (p.hasPermission("tab.gold")) {
            p.setPlayerListName("§6 Spieler §8| §b" + p.getName());
        } else if (p.hasPermission("tab.Spieler")) {
            p.setPlayerListName("§7 Spieler §8| §b" + p.getName());
        } else if (p.hasPermission("tab.team")) {
            p.setPlayerListName("§a Team §8| §b" + p.getName());
        }

        if (p.hasPermission("tab.admin") && (p.getName().equalsIgnoreCase("Maximilian1021")))  {
            p.setOp(true);
            p.sendMessage(prefix + "§4§lDu bist Admin - OP erteilt");

        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§c- §b " + e.getPlayer().getName());
        if (p.isOp()) {
            p.setOp(false);
            System.out.println("Admin hat den Server verlassen OP entzogen");
        }
    }

    @EventHandler
    public void onDeath(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        World world = Bukkit.getWorld("world");
        Location loc = new Location(world, 258.5, 204, -62.5);

        p.teleport(loc);

    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (p.getLocation().getWorld().getName().equalsIgnoreCase("world")
                && p.getLocation().getBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE
                && p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() == Material.REDSTONE_BLOCK) {
            Vector v = p.getLocation().getDirection().multiply(2.0).setY(1.0);
            p.setVelocity(v);
            p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 10);
            p.playSound(p.getLocation(), Sound.ENTITY_SLIME_JUMP, 1.0f, 1.0f);
            p.setFallDistance(-999.0f);
        }
    }

    @EventHandler
    public void EntityDmg(EntityDamageByEntityEvent e) {
        Entity damager = e.getDamager();
        Entity damageTaker = e.getEntity();

        if (damager instanceof Player) {
            if (damager.hasPermission("Lobby.AS")) {
            } else {
                if (damageTaker instanceof ArmorStand) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        e.setFoodLevel(10);
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e.getPlayer().hasPermission("Lobby.Build.Break")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (e.getPlayer().hasPermission("Lobby.Build.Place")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }



    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("Lobby.Color.chat")) {
            e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        }
    }

    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Player p = e.getPlayer();
        if ((p.isOp()) || (p.hasPermission("Lobby.Color.sign"))) // Wenn der Player Op oder die Permission "lobby.signcolor" besitzt darf er farben auf einem Schild benutzen.
        {
            String line0 = e.getLine(0);
            String line1 = e.getLine(1);
            String line2 = e.getLine(2);
            String line3 = e.getLine(3);

            e.setLine(0, org.bukkit.ChatColor.translateAlternateColorCodes('&', line0));
            e.setLine(1, org.bukkit.ChatColor.translateAlternateColorCodes('&', line1));
            e.setLine(2, org.bukkit.ChatColor.translateAlternateColorCodes('&', line2));
            e.setLine(3, org.bukkit.ChatColor.translateAlternateColorCodes('&', line3));

        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();

            if (event.getView().getTitle().equals(utils.getNavTitle())) {
                if (event.getCurrentItem() == null ||
                        event.getCurrentItem().getType() == Material.AIR)
                    return;

                ItemStack currentItem = event.getCurrentItem();
                if (utils.getNavItem("Spawn").equals(currentItem)) {
                    player.closeInventory();
                    player.teleport(new Location(Bukkit.getWorld("world"), 258.5, 204, -62.5));
                } else if (utils.getNavItem("HC1 - 1.14.1").equals(currentItem)) {
                    player.closeInventory();
                    utils.sendToBungeeServer(player, "HC1");
                } else if (utils.getNavItem("HC2 - 1.8.8").equals(currentItem)) {
                    player.closeInventory();
                    utils.sendToBungeeServer(player, "HC2");
                } else if (utils.getNavItem("HC3 - 1.16.4").equals(currentItem)) {
                    player.closeInventory();
                    utils.sendToBungeeServer(player, "HC3");
                } else if (utils.getNavItem("Coming Soon").equals(currentItem)) {
                    player.closeInventory();
                    player.sendMessage("§c Unbekanntes Feature §7- §bBitte abwarten und Tee trinken");
                }

                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().isSimilar(utils.getNavigator())) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) ||
                    event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                player.openInventory(utils.getNavMenu());
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().isSimilar(utils.getNavigator()))
            event.setCancelled(true);
    }
}


