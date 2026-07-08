package com.juiceybeans.veilsandvegetation.block;

import com.juiceybeans.veilsandvegetation.init.VVBlocks;

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

public class RoseCreepsBlock extends SpreadableVVBlock {

    public RoseCreepsBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult hit) {
        var stack = player.getItemInHand(hand);
        if (stack.is(Items.SHEARS)) {
            if (!level.isClientSide()) {
                if (level.random.nextInt(100) > 35) popResource(level, pos, Items.ROSE_BUSH.getDefaultInstance());
                level.setBlock(pos, VVBlocks.ROSE_VINES.withPropertiesOf(state), Block.UPDATE_ALL);
            } else {
                level.playSound(player, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, pos, player, hand, hit);
    }
}
