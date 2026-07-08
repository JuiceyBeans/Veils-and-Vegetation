package com.juiceybeans.veilsandvegetation.block;

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

public class FruitingHyphaeVVBlock extends SpreadableVVBlock {

    private Block shearedBlock;

    public FruitingHyphaeVVBlock(Properties properties) {
        super(properties);
    }

    public void setShearedBlock(Block strippedBlock) {
        this.shearedBlock = strippedBlock;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult hit) {
        var stack = player.getItemInHand(hand);
        if (stack.is(Items.SHEARS)) {
            if (!level.isClientSide()) {
                level.setBlock(pos, shearedBlock.withPropertiesOf(state), Block.UPDATE_ALL);
            } else {
                level.playSound(player, pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, pos, player, hand, hit);
    }
}
