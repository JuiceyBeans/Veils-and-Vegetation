package com.juiceybeans.veilsandvegetation.network;

import com.juiceybeans.veilsandvegetation.VeilsAndVegetation;
import com.juiceybeans.veilsandvegetation.block.blockentity.TackedNotesBlockEntity;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;

public class VVNetworking {

    public static final ResourceLocation UPDATE_NOTES_PACKET = VeilsAndVegetation.id("update_notes");

    public static void registerServerReceivers() {
        ServerPlayNetworking.registerGlobalReceiver(UPDATE_NOTES_PACKET,
                (server, player, handler, buf, responseSender) -> {
                    BlockPos pos = buf.readBlockPos();
                    String text = buf.readUtf(1024);
                    server.execute(() -> {
                        BlockEntity be = player.level().getBlockEntity(pos);
                        if (be instanceof TackedNotesBlockEntity tnbe) {
                            tnbe.setText(text);
                        }
                    });
                });
    }
}
