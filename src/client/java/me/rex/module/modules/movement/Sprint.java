package me.rex.module.modules.movement;

import me.rex.module.Category;
import me.rex.module.Module;
import org.lwjgl.glfw.GLFW;

public class Sprint extends Module {
    public Sprint(){
        super("Sprint", Category.MOVEMENT, GLFW.GLFW_KEY_T);
    }

    public void onEnable(){

    }

}
