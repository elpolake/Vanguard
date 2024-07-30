package me.rex.vanguard.module.modules.movement;

import me.rex.vanguard.module.Category;
import me.rex.vanguard.module.Module;
import me.rex.vanguard.settings.NumberSetting;
import org.lwjgl.glfw.GLFW;

public class Flight extends Module {
    public NumberSetting speed = new NumberSetting("Speed", 0, 10, 2);
    public Flight() {
        super("Flight", Category.MOVEMENT, GLFW.GLFW_KEY_R, false);
        addSettings(speed);
    }
    @Override
    public void onTick(){
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().setFlySpeed(speed.getValueFloat());
        super.onTick();
    }

    @Override
    public void onDisable(){
        mc.player.getAbilities().flying = false;
        super.onDisable();
    }
}
