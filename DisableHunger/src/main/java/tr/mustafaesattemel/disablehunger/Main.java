package tr.mustafaesattemel.disablehunger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
    
    private boolean hungerEnabled = false;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("disablehungerreload").setExecutor(new ReloadConfig(this));
        
        hungerEnabled = getConfig().getBoolean("DisableHunger");
        
        Bukkit.getPluginManager().registerEvents(this,this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"DisableHunger has been actived!");

    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"DisableHunger closing...  cya <3");
    }
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e){
        e.setCancelled(hungerEnabled);
    }
}
