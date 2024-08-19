package com.ryverday.auroramc;

import com.ryverday.auroramc.listeners.MaintenanceListener;
import com.ryverday.auroramc.commands.MaintenanceCommands;
import com.ryverday.auroramc.manager.Manager;
import net.md_5.bungee.api.plugin.Plugin;

public class Maintence extends Plugin {

    private Manager maintenanceManager;
    private MaintenanceListener maintenanceListener;

    @Override
    public void onEnable() {
        maintenanceManager = new Manager(this);
        maintenanceListener = new MaintenanceListener(this);
        getProxy().getPluginManager().registerCommand(this, new MaintenanceCommands(this, "manutenção"));
        getProxy().getPluginManager().registerListener(this, maintenanceListener);
    }

    public Manager getMaintenanceManager() {
        return maintenanceManager;
    }
}
