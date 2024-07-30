package me.rex.vanguard.module.modules.movement;

import me.rex.vanguard.module.Category;
import me.rex.vanguard.module.Module;
import org.lwjgl.glfw.GLFW;

public class Flight extends Module {
    public Flight() {
        super("Flight", Category.MOVEMENT, GLFW.GLFW_KEY_R, false);
    }
    @Override
    public void onTick(){
        mc.player.getAbilities().flying = true;
        super.onTick();
    }

    @Override
    public void onDisable(){
        mc.player.getAbilities().flying = false;
        super.onDisable();
    }
}
