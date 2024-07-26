package org.w8o;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.w8o.misc.TabCompleteCanceller;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class main extends JavaPlugin implements Listener {

    private List<String> customCommands;

    @Override
    public void onEnable() {
        saveResource("cmds.yml", false);
        loadcmd();
        Bukkit.getPluginManager().registerEvents(new TabCompleteCanceller(this), this);
    }

    @Override
    public void onDisable() {
    }

    public List<String> getcmds() {
        return customCommands;
    }

    private void loadcmd() {
        File cmdsFile = new File(getDataFolder(), "cmds.yml");
        FileConfiguration cmdsConfig = YamlConfiguration.loadConfiguration(cmdsFile);
        customCommands = cmdsConfig.getStringList("commands");
    }
}
