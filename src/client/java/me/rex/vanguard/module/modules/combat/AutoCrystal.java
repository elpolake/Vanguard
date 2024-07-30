package me.rex.vanguard.module.modules.combat;

import me.rex.vanguard.module.Category;
import me.rex.vanguard.module.Module;
import org.lwjgl.glfw.GLFW;

public class AutoCrystal extends Module {
    public AutoCrystal(){
        super("AutoCrystal", Category.COMBAT, GLFW.GLFW_KEY_C);
    }
}
