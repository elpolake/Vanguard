package me.rex.vanguard.module.modules.combat;

import me.rex.vanguard.module.Category;
import me.rex.vanguard.module.Module;
import org.lwjgl.glfw.GLFW;

public class KillAura extends Module {
    public KillAura() {
        super("Kill Aura", Category.COMBAT, GLFW.GLFW_KEY_K, false);
    }
}
