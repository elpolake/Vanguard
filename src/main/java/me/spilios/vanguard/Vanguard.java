package me.spilios.vanguard;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class Vanguard implements ModInitializer {
    public static final String MOD_ID = "Vanguard";
    public static final Vanguard INSTANCE = new Vanguard();
    public Logger logger = LogManager.getLogger(Vanguard.class);
    @Override
    public void onInitialize() {
        logger.info("Client initialized");
    }
    public void onKeyPress(int key, int action){
        if(action == GLFW.GLFW_PRESS) {
            logger.info("Key" + key + "was pressed");
        }
    }
    public void onTick(){
        //logger.info("Tick");
    }
}