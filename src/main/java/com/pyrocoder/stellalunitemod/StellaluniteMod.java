package com.pyrocoder.stellalunitemod;
//Testing to see if this updates

import com.mojang.logging.LogUtils;
import com.pyrocoder.stellalunitemod.block.ModBlocks;
import com.pyrocoder.stellalunitemod.component.ModDataComponentTypes;
import com.pyrocoder.stellalunitemod.item.ModCreativeModeTabs;
import com.pyrocoder.stellalunitemod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StellaluniteMod.MOD_ID)
public class StellaluniteMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "stellalunitemod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public StellaluniteMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeModeTabs.STELLALUNITE_ITEMS_TAB.getKey()) {
            event.accept(ModItems.STELLALUNITE.get());
            event.accept(ModItems.RAW_STELLALUNITE.get());
            event.accept(ModItems.STELLALUNITE_BONE.get());

            event.accept(ModItems.BONE_MARROW.get());

            event.accept(ModItems.WAND.get());
        }

        if (event.getTabKey() == ModCreativeModeTabs.STELLALUNITE_TOOLS_TAB.getKey()) {
            event.accept(ModItems.STELLALUNITE_SWORD.get());
            event.accept(ModItems.STELLALUNITE_PICKAXE.get());
            event.accept(ModItems.STELLALUNITE_SHOVEL.get());
            event.accept(ModItems.STELLALUNITE_AXE.get());
            event.accept(ModItems.STELLALUNITE_HOE.get());
            event.accept(ModItems.STELLALUNITE_HAMMER.get());

            event.accept(ModItems.STELLALUNITE_BOOTS);
            event.accept(ModItems.STELLALUNITE_LEGGINGS);
            event.accept(ModItems.STELLALUNITE_CHESTPLATE);
            event.accept(ModItems.STELLALUNITE_HELMET);

            event.accept(ModItems.STELLALUNITE_HORSE_ARMOR);
        }

        if (event.getTabKey() == ModCreativeModeTabs.STELLALUNITE_BLOCKS_TAB.getKey()) {
            event.accept(ModBlocks.STELLALUNITE_BLOCK.get());
            event.accept(ModBlocks.RAW_STELLALUNITE_BLOCK.get());
            event.accept(ModBlocks.STELLALUNITE_ORE.get());
            event.accept(ModBlocks.STELLALUNITE_DEEPSLATE_ORE.get());
            event.accept(ModBlocks.MAGIC_BLOCK.get());
            event.accept(ModBlocks.DUPLICATE_BLOCK.get());
        }

        if (event.getTabKey() == ModCreativeModeTabs.STELLALUNITE_FOODS_TAB.getKey()) {
            event.accept(ModItems.INBONE_STEAK.get());
        }

        if(event.getTabKey() == ModCreativeModeTabs.STELLALUNITE_NONBLOCK_BLOCKS_TAB.getKey()) {
            event.accept(ModBlocks.CRASH_BUTTON.get());

            event.accept(ModBlocks.STELLALUNITE_STAIR.get());
            event.accept(ModBlocks.STELLALUNITE_SLAB.get());

            event.accept(ModBlocks.STELLALUNITE_PRESSURE_PLATE.get());
            event.accept(ModBlocks.STELLALUNITE_BUTTON.get());

            event.accept(ModBlocks.STELLALUNITE_FENCE.get());
            event.accept(ModBlocks.STELLALUNITE_FENCE_GATE.get());
            event.accept(ModBlocks.STELLALUNITE_WALL.get());

            event.accept(ModBlocks.STELLALUNITE_DOOR.get());
            event.accept(ModBlocks.STELLALUNITE_TRAP_DOOR.get());

            event.accept(ModBlocks.STELLALUNITE_LAMP.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
