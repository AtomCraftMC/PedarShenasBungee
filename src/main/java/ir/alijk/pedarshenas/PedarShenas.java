package ir.alijk.pedarshenas;

import ir.alijk.pedarshenas.events.OnCommand;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;

public final class PedarShenas extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new OnCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static boolean isVerifyServer(ServerInfo serverInfo) {
        return serverInfo.getName().toLowerCase().equalsIgnoreCase("verify");
    }

}
