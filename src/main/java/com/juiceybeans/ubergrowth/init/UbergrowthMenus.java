package com.juiceybeans.ubergrowth.init;

import com.juiceybeans.ubergrowth.Ubergrowth;
import com.juiceybeans.ubergrowth.block.blockentity.TackedNotesBlockEntity;
import com.juiceybeans.ubergrowth.menu.TackedNotesMenu;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;

public class UbergrowthMenus {
    public static final MenuType<TackedNotesMenu> TACKED_NOTES_MENU =
            new ExtendedScreenHandlerType<>(
                    (syncId, inventory, buf) -> {
                        BlockPos pos = buf.readBlockPos();
                        BlockEntity entity = inventory.player.level().getBlockEntity(pos);
                        if (entity instanceof TackedNotesBlockEntity notesEntity) {
                            return new TackedNotesMenu(syncId, notesEntity);
                        }
                        return null;
                    }
            );

    public static void registerAll() {
        Registry.register(
                BuiltInRegistries.MENU,
                Ubergrowth.id("tacked_notes"),
                TACKED_NOTES_MENU
        );
    }
}
