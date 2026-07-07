package com.juiceybeans.ubergrowth.menu;

import com.juiceybeans.ubergrowth.block.blockentity.TackedNotesBlockEntity;
import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import com.juiceybeans.ubergrowth.init.UbergrowthMenus;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;

public class TackedNotesMenu extends AbstractContainerMenu {
    private final TackedNotesBlockEntity notesEntity;
    private final ContainerLevelAccess access;

    public TackedNotesMenu(int containerId, TackedNotesBlockEntity notesEntity) {
        super(UbergrowthMenus.TACKED_NOTES_MENU, containerId);
        this.notesEntity = notesEntity;
        this.access = ContainerLevelAccess.create(notesEntity.getLevel(), notesEntity.getBlockPos());
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, UbergrowthBlocks.TACKED_NOTES);
    }

    public TackedNotesBlockEntity getNotesEntity() {
        return notesEntity;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slot) {
        return ItemStack.EMPTY;
    }
}
