package me.rex.module.modules.misc;

import me.rex.module.Category;
import me.rex.module.Module;
import me.rex.utils.TestPlayerUtil;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class TestingPlayer extends Module{
    private static final List<TestPlayerUtil> ENTITIES = new ArrayList<>();
    public TestingPlayer(){
        super("TestingPlayer", Category.MISC, GLFW.GLFW_KEY_Y);
    }
    @Override
    public void onEnable(){
        TestPlayerUtil testPlayer = new TestPlayerUtil(mc.player, name, 20, false);
        testPlayer.spawn();
        ENTITIES.add(testPlayer);
    }
    @Override
    public void onDisable(){
        ENTITIES.removeIf(fp1 -> {
            if (fp1 != null) {
                fp1.despawn();
                return true;
            }
            return false;
        });
    }
}