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

public class FruitingGlowberryCreepsBlock extends SpreadableVVBlock {

    public FruitingGlowberryCreepsBlock(Properties properties) {
        super(properties);
        this.setSpreadBlock((BaseVVBlock) VVBlocks.GLOWBERRY_CREEPS);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult hit) {
        var stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            var isShears = false;
            popResource(level, pos, Items.GLOW_BERRIES.getDefaultInstance());

            if (stack.is(Items.SHEARS)) {
                level.setBlock(pos, VVBlocks.BARE_GLOWBERRY_CREEPS.withPropertiesOf(state), Block.UPDATE_ALL);
            } else level.setBlock(pos, VVBlocks.GLOWBERRY_CREEPS.withPropertiesOf(state), Block.UPDATE_ALL);
        } else {
            level.playSound(player, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        return InteractionResult.SUCCESS;
    }
}
