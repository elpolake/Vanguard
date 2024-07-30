package me.rex.vanguard.module.modules.client;

import me.rex.vanguard.gui.ClickGUIScreen;
import me.rex.vanguard.module.Category;
import me.rex.vanguard.module.Module;
import org.lwjgl.glfw.GLFW;

public class ClickGUI extends Module {
    public ClickGUI(){
        super("ClickGUI", Category.CLIENT, GLFW.GLFW_KEY_RIGHT_SHIFT, false);
    }
    @Override
    public void onEnable(){
        mc.setScreenAndRender(ClickGUIScreen.INSTANCE);
    }

    @Override
    public void onDisable() {
        mc.setScreen(null);
    }
}