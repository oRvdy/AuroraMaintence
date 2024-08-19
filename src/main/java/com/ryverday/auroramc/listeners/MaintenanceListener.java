package com.ryverday.auroramc.listeners;

import com.ryverday.auroramc.Maintence;
import com.ryverday.auroramc.manager.Manager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class MaintenanceListener implements Listener {

    private final Maintence plugin;

    public MaintenanceListener(Maintence plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPostLogin(PostLoginEvent event) {
        Manager maintenanceManager = plugin.getMaintenanceManager();
        if (maintenanceManager.isMaintenanceMode() && !maintenanceManager.getAllowedPlayers().contains(event.getPlayer().getName())) {
            event.getPlayer().disconnect(new TextComponent(ChatColor.RED + "O Servidor está disponível apenas para nossa equipe."));
        }
    }

}
