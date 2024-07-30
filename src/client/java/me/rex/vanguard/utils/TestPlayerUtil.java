package me.rex.vanguard.utils;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;

import java.util.UUID;
import me.rex.vanguard.VanguardClient;

public class TestPlayerUtil extends OtherClientPlayerEntity {
    public TestPlayerUtil(PlayerEntity player, String name, float health, boolean copyInv) {
        super(VanguardClient.INSTANCE.mc.world, new GameProfile(UUID.randomUUID(), name));
        copyPositionAndRotation(player);

        prevYaw = getYaw();
        prevPitch = getPitch();
        headYaw = player.headYaw;
        prevHeadYaw = headYaw;
        bodyYaw = player.bodyYaw;
        prevBodyYaw = bodyYaw;

        Byte playerModel = player.getDataTracker().get(PlayerEntity.PLAYER_MODEL_PARTS);
        dataTracker.set(PlayerEntity.PLAYER_MODEL_PARTS, playerModel);

        getAttributes().setFrom(player.getAttributes());
        setPose(player.getPose());

        capeX = getX();
        capeY = getY();
        capeZ = getZ();

        if (health <= 20) {
            setHealth(health);
        } else {
            setHealth(health);
            setAbsorptionAmount(health - 20);
        }

        if (copyInv) getInventory().clone(player.getInventory());
    }
    public void spawn() {
        unsetRemoved();
        VanguardClient.INSTANCE.mc.world.addEntity(this);
    }

    public void despawn() {
        VanguardClient.INSTANCE.mc.world.removeEntity(getId(), RemovalReason.DISCARDED);
        setRemoved(RemovalReason.DISCARDED);
    }
}