package me.rex.module.modules.combat;

import me.rex.module.Category;
import me.rex.module.Module;
import org.lwjgl.glfw.GLFW;

public class AutoCrystal extends Module {
    public AutoCrystal(){
        super("AutoCrystal", Category.COMBAT, GLFW.GLFW_KEY_C);
    }
}
