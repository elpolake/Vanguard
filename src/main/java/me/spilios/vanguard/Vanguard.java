package me.spilios.vanguard;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.*;

public class Vanguard implements ModInitializer {
    public static final String MOD_ID = "Vanguard";
    public static final Vanguard INSTANCE = new Vanguard();
    @Override
    public void onInitialize() {

    }
    public void onKeyPress(int key, int action){

    }
    public void onTick(){

    }
}