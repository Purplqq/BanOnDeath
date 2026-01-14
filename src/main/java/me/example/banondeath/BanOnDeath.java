package me.example.banondeath;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BanOnDeath extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        Bukkit.getBanList(BanList.Type.NAME).addBan(
                player.getName(),
                "You died.",
                null,
                "BanOnDeath"
        );

        Bukkit.getScheduler().runTask(this, () ->
                player.kickPlayer("§cYou died.\n§7You are banned.")
        );
    }
}
