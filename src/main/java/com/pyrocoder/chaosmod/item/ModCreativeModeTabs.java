package com.pyrocoder.chaosmod.item;

import com.pyrocoder.chaosmod.ChaosMod;
import com.pyrocoder.chaosmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChaosMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHAOTIC_ITEMS_TAB = CREATIVE_MODE_TABS.register("chaotic_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WAND.get()))
                    .title(Component.translatable("creativetab.chaosmod.chaotic_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                    }).build());

    //public static final RegistryObject<CreativeModeTab> STELLALUNITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("stellalunite_blocks_tab",
      //      () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STELLALUNITE_BLOCK.get()))
        //            .withTabsBefore(STELLALUNITE_ITEMS_TAB.getId())
          //          .title(Component.translatable("creativetab.chaosmod.stellalunite_blocks"))
            //        .displayItems((itemDisplayParameters, output) -> {

//                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
