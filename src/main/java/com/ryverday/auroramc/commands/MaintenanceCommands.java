package com.ryverday.auroramc.commands;

import com.ryverday.auroramc.Maintence;
import com.ryverday.auroramc.manager.Manager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class MaintenanceCommands extends Command {

    private final Maintence plugin;

    public MaintenanceCommands(Maintence plugin, String name) {
        super(name);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Manager maintenanceManager = plugin.getMaintenanceManager();

        if (args.length == 1 && args[0].equalsIgnoreCase("toggle")) {
            maintenanceManager.setMaintenanceMode(!maintenanceManager.isMaintenanceMode());
            sender.sendMessage(new TextComponent(ChatColor.DARK_PURPLE + "AuroraMC " + ChatColor.GREEN + "Manutenção " + (maintenanceManager.isMaintenanceMode() ? "ativada" : "desativada")));
        } else if (args.length == 2 && args[0].equalsIgnoreCase("add")) {
            maintenanceManager.addAllowedPlayer(args[1]);
            sender.sendMessage(new TextComponent(ChatColor.DARK_PURPLE + "AuroraMC " + ChatColor.GREEN + "Jogador " + args[1] + " adicionado à lista de permissão."));
        } else if (args.length == 2 && args[0].equalsIgnoreCase("remove")) {
            maintenanceManager.removeAllowedPlayer(args[1]);
            sender.sendMessage(new TextComponent(ChatColor.DARK_PURPLE + "AuroraMC " + ChatColor.GREEN + "Jogador " + args[1] + " removido da lista de permissão."));
        } else {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Uso: /manutenção <toggle | add|remove jogador."));
        }
    }
}
