package com.juiceybeans.ubergrowth.init;

import com.juiceybeans.ubergrowth.Ubergrowth;
import com.juiceybeans.ubergrowth.block.blockentity.TackedNotesBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class UbergrowthBlockEntityTypes {
  public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
    return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Ubergrowth.id(path), blockEntityType);
  }
 
  public static final BlockEntityType<TackedNotesBlockEntity> TACKED_NOTES = register(
      "tacked_notes", BlockEntityType.Builder.of(TackedNotesBlockEntity::new, UbergrowthBlocks.TACKED_NOTES).build(null)
  );
 
  public static void initialize() {
  }
}