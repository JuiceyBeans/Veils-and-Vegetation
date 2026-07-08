package com.juiceybeans.veilsandvegetation.block.blockentity;

import com.juiceybeans.veilsandvegetation.init.VVBlockEntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TackedNotesBlockEntity extends BlockEntity {

    private String text = "";

    public TackedNotesBlockEntity(BlockPos pos, BlockState state) {
        super(VVBlockEntityTypes.TACKED_NOTES, pos, state);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("Text", text);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        text = tag.getString("Text");
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }
}
