package me.rex.module.modules.movement;

import me.rex.module.Category;
import me.rex.module.Module;
import org.lwjgl.glfw.GLFW;

public class ReverseStep extends Module {
    public ReverseStep(){
        super("ReverseStep", Category.MOVEMENT, GLFW.GLFW_KEY_O);
    }
    @Override
    public void onTick(){
        if (mc.player.isInLava() || mc.player.isTouchingWater() || !mc.player.isOnGround()) return;
        mc.player.addVelocity(0, -1, 0);
    }
}
