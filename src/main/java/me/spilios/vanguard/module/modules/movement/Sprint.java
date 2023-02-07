package me.spilios.vanguard.module.modules.movement;

import me.spilios.vanguard.module.Category;
import me.spilios.vanguard.module.Module;
import org.lwjgl.glfw.GLFW;

public class Sprint extends Module {
    public Sprint(){
        super("Sprint", Category.MOVEMENT, GLFW.GLFW_KEY_T);
    }

    public void onEnable(){

    }

}
