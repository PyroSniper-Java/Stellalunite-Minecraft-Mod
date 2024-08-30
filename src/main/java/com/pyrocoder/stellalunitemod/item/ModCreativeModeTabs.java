package com.pyrocoder.stellalunitemod.item;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StellaluniteMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STELLALUNITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("stellalunite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STELLALUNITE_BONE.get()))
                    .title(Component.translatable("creativetab.stellalunitemod.stellalunite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.STELLALUNITE.get());
                        output.accept(ModItems.RAW_STELLALUNITE.get());
                        output.accept(ModItems.STELLALUNITE_BONE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> STELLALUNITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("stellalunite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STELLALUNITE_BLOCK.get()))
                    .withTabsBefore(STELLALUNITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.stellalunitemod.stellalunite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.STELLALUNITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_STELLALUNITE_BLOCK.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
