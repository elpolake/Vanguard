package me.rex;

import me.rex.module.ModuleManager;
import me.rex.module.Module;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;
import org.slf4j.LoggerFactory;

public class VanguardClient implements ClientModInitializer {
	public static final String MOD_ID = "Vanguard";
	public static final VanguardClient INSTANCE = new VanguardClient();
	public Logger logger = LogManager.getLogger(Vanguard.class);
	public MinecraftClient mc = MinecraftClient.getInstance();
	@Override
	public void onInitializeClient() {
		logger.info("Client initialized");
	}
	public void onKeyPress(int key, int action){
		if(action == GLFW.GLFW_PRESS) {
			//logger.info("Key" + key + "was pressed");
			for(Module module : ModuleManager.INSTANCE.modules){
				if(key == module.key){
					module.toggle();
				}
			}
		}
	}
	public void onTick(){
		//logger.info("Tick");
		if(mc.player != null){
			for(Module module : ModuleManager.INSTANCE.getEnabledModules()){
				module.onTick();
			}
		}
	}
}