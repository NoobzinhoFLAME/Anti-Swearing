package com.noobzinhoflame.antiswearing;

import com.noobzinhoflame.antiswearing.Listener.ChatListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public final class Main extends JavaPlugin {

    private FileConfiguration config;
    private List<String> PalavrasOfensivas;

    @Override
    public void onEnable() {
        loadConfig();
        getServer().getPluginManager().registerEvents(new ChatListener(PalavrasOfensivas), this);
    }

    @Override
    public void onDisable() {}

    private void loadConfig() {
        saveDefaultConfig();
        PalavrasOfensivas = getConfig().getStringList("PalavrasOfensivas");

        File configFile = new File(getDataFolder(), "config.yml");
        try {
            config = YamlConfiguration.loadConfiguration(new InputStreamReader(new FileInputStream(configFile), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}