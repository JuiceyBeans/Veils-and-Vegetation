package com.juiceybeans.veilsandvegetation.init;

import com.juiceybeans.veilsandvegetation.VeilsAndVegetation;
import com.juiceybeans.veilsandvegetation.block.blockentity.TackedNotesBlockEntity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class VVBlockEntityTypes {

    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, VeilsAndVegetation.id(path), blockEntityType);
    }

    public static final BlockEntityType<TackedNotesBlockEntity> TACKED_NOTES = register(
            "tacked_notes", BlockEntityType.Builder.of(TackedNotesBlockEntity::new, VVBlocks.TACKED_NOTES).build(null));

    public static void initialize() {}
}
