package me.rex.vanguard.module.modules.movement;

import me.rex.vanguard.module.Category;
import me.rex.vanguard.module.Module;
import org.lwjgl.glfw.GLFW;

public class Sprint extends Module {
    public Sprint(){
        super("Sprint", Category.MOVEMENT, GLFW.GLFW_KEY_T, false);
    }
    @Override
    public void onTick(){
        mc.player.setSprinting(true);
    }
    @Override
    public void onDisable(){
        mc.player.setSprinting(false);
        super.onDisable();
    }

}
