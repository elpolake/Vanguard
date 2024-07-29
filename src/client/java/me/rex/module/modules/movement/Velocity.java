package me.rex.module.modules.movement;

import me.rex.module.Category;
import me.rex.module.Module;
import org.lwjgl.glfw.GLFW;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ExplosionS2CPacket;
import com.google.common.eventbus.Subscribe;
import me.rex.event.events.PacketEvent;

public class Velocity extends Module {
    public Velocity() {
        super("Velocity", Category.MOVEMENT, GLFW.GLFW_KEY_V);
    }
    @Subscribe
    private void onPacketReceive(PacketEvent.Receive event) {
        if (event.getPacket() instanceof EntityVelocityUpdateS2CPacket || event.getPacket() instanceof ExplosionS2CPacket) {
            event.cancel();
        }
    }
}