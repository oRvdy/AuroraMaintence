package com.ryverday.auroramc.manager;

import com.ryverday.auroramc.Maintence;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private final Maintence plugin;
    private boolean maintenanceMode;
    private List<String> allowedPlayers;

    public Manager(Maintence plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public boolean isMaintenanceMode() {
        return maintenanceMode;
    }

    public void setMaintenanceMode(boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
        saveConfig();
    }

    public List<String> getAllowedPlayers() {
        return allowedPlayers;
    }

    public void addAllowedPlayer(String player) {
        allowedPlayers.add(player);
        saveConfig();
    }

    public void removeAllowedPlayer(String player) {
        allowedPlayers.remove(player);
        saveConfig();
    }

    private void loadConfig() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        File configFile = new File(plugin.getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Configuration config = null;
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (config != null) {
            maintenanceMode = config.getBoolean("maintenance-mode", false);
            allowedPlayers = config.getStringList("allowed-players");
        } else {
            maintenanceMode = false;
            allowedPlayers = new ArrayList<>();
        }
    }

    private void saveConfig() {
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        Configuration config = new Configuration();

        config.set("maintenance-mode", maintenanceMode);
        config.set("allowed-players", allowedPlayers);

        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
