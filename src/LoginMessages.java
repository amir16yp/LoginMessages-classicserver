import net.classicube.api.API;
import net.classicube.api.JavaPlugin;
import net.classicube.api.enums.ChatColors;
import net.classicube.api.event.EventRegistry;
import net.classicube.api.event.PlayerDisconnectEvent;
import net.classicube.api.event.PlayerJoinEvent;

public class LoginMessages extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        EventRegistry.registerListener(this);
    }

    @Override
    public void onDisable()
    {
        super.onDisable();
        EventRegistry.unregisterListener(this);
    }

    @EventRegistry.EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        API.getInstance().broadcastMessage(ChatColors.YELLOW + "Welcome, " + ChatColors.AQUA + event.getPlayer().getUsername() + ChatColors.YELLOW + "!");
        //player.sendMessage(ChatColors.YELLOW + "You have logged into world: " + ChatColors.RED + player.getLevel().getName());
    }

    @EventRegistry.EventHandler
    public void onPlayerDisconnect(PlayerDisconnectEvent event)
    {
        API.getInstance().broadcastMessage(ChatColors.YELLOW + "Goodbye, " + ChatColors.AQUA + event.getPlayer().getUsername() + ChatColors.YELLOW + "!");
    }


}