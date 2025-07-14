package epc.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.plugin.java.JavaPlugin;

public class PortalCommandListener implements Listener {
    private final JavaPlugin plugin;
    
    public PortalCommandListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onPortalUse(PlayerTeleportEvent event) {
        if (event.getCause() == TeleportCause.END_PORTAL) {
            Player player = event.getPlayer();
            
            boolean cancel = plugin.getConfig().getBoolean("cancel-teleport");
            String command = plugin.getConfig().getString("command");
            
            //cancel end portal teleport
            if (cancel) {
                event.setCancelled(true);
            }
            
            //do player command
            player.performCommand(command);
        }
    }
}