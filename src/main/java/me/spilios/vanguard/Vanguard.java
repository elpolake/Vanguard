package me.spilios.vanguard;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.*;

public class Vanguard implements ModInitializer {
    public static final String MOD_ID = "Vanguard";
    @Override
    public void onInitialize() {

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("foo")
                .executes(context -> {
                    // For versions below 1.19, replace "Text.literal" with "new LiteralText".
                    context.getSource().sendMessage(Text.literal("Called /foo with no arguments"));

                    return 1;
                })));

        ServerTickEvents.END_WORLD_TICK.register(world -> {
            // Do something on server tick
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Do something on client tick
        });
    }
}