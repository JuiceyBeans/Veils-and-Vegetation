package com.juiceybeans.ubergrowth.block;

import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FrutingSweetBerryFoliage extends BaseUbergrowthBlock {
    public FrutingSweetBerryFoliage(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            popResource(level, pos, Items.SWEET_BERRIES.getDefaultInstance());
            level.setBlock(pos, UbergrowthBlocks.SWEET_BERRY_FOLIAGE.withPropertiesOf(state), Block.UPDATE_ALL);
        } else {
            level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        return InteractionResult.SUCCESS;
    }
}
