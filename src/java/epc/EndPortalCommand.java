package epc;

import epc.listener.PortalCommandListener;
import org.bukkit.plugin.java.JavaPlugin;

public class EndPortalCommand extends JavaPlugin {
    @Override
    public void onEnable() {
        //Listener
        getServer().getPluginManager().registerEvents(new PortalCommandListener(this), this);
        
        saveDefaultConfig();
    }
}
