package ir.alijk.pedarshenas.events;

import ir.alijk.pedarshenas.PedarShenas;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

import java.util.Arrays;
import java.util.List;

public class OnCommand implements Listener {
    private final List<String> commandWhitelist = Arrays.asList("verify", "update");

    @EventHandler(priority = EventPriority.LOWEST)
    public void onCommand(final ChatEvent event) {
        if (event.isCancelled() || !event.isCommand()) {
            return;
        }

        // Check if it's a player
        if (!(event.getSender() instanceof ProxiedPlayer)) {
            return;
        }
        final ProxiedPlayer player = (ProxiedPlayer) event.getSender();

        // Only in verify servers
        if (!PedarShenas.isVerifyServer(player.getServer().getInfo())) {
            return;
        }

        // Check if command is whitelisted command
        if (commandWhitelist.contains(event.getMessage().split(" ")[0].toLowerCase())) {
            return;
        }

        event.setCancelled(true);
    }


}
