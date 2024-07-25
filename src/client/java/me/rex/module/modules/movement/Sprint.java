package me.rex.module.modules.movement;

import me.rex.module.Category;
import me.rex.module.Module;
import org.lwjgl.glfw.GLFW;

public class Sprint extends Module {
    public Sprint(){
        super("Sprint", Category.MOVEMENT, GLFW.GLFW_KEY_T);
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
