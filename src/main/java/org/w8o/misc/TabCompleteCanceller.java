package org.w8o.misc;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.server.TabCompleteEvent;
import org.w8o.main;

import java.util.List;

public class TabCompleteCanceller implements Listener {

    private final main plugin;

    public TabCompleteCanceller(main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {
        // Cancel the default tab completion suggestions
        event.setCancelled(true);

        // Add custom commands to the tab completion list
        List<String> customCommands = plugin.getcmds();
        event.getCompletions().clear();
        event.getCompletions().addAll(customCommands);
    }

    @EventHandler
    public void onPlayerCommandSend(PlayerCommandSendEvent event) {
        // Clear the command list to prevent any default commands from being shown
        event.getCommands().clear();

        // Add custom commands to the command list
        List<String> customCommands = plugin.getcmds();
        event.getCommands().addAll(customCommands);
    }
}
