package me.rex.module.modules.misc;

import me.rex.module.Category;
import net.minecraft.item.Items;
import me.rex.module.Module;
import org.lwjgl.glfw.GLFW;

public class FastPlace extends Module{
    public FastPlace() {
        super("FastPlace", Category.MISC, GLFW.GLFW_KEY_B);
    }
    @Override
    public void onTick() {
        if (mc.player.isHolding(Items.EXPERIENCE_BOTTLE)) {
            mc.itemUseCooldown = 0;
        }
    }
}