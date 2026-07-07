package com.juiceybeans.ubergrowth.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BuddingHyphaeUbergrowthBlock extends SpreadableUbergrowthBlock {
    private Block strippedBlock;
    private final ItemStack droppedItem;

    public BuddingHyphaeUbergrowthBlock(Properties properties, ItemStack droppedItem) {
        super(properties);
        this.droppedItem = droppedItem;
    }

    public void setStrippedBlock(Block strippedBlock) {
        this.strippedBlock = strippedBlock;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        var stack = player.getItemInHand(hand);
        if (stack.is(ItemTags.AXES) ||stack.is(Items.SHEARS)) {
            if (!level.isClientSide()) {
                popResource(level, pos, this.droppedItem);
                level.setBlock(pos, strippedBlock.withPropertiesOf(state), Block.UPDATE_ALL);
            } else {
                level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, pos, player, hand, hit);
    }
}
