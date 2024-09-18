package com.pyrocoder.stellalunitemod;
//Testing to see if this updates

import com.mojang.logging.LogUtils;
import com.pyrocoder.stellalunitemod.block.ModBlocks;
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

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ModCreativeModeTabs.STELLALUNITE_ITEMS_TAB.getKey()) {
            event.accept(ModItems.STELLALUNITE);
            event.accept(ModItems.RAW_STELLALUNITE);
            event.accept(ModItems.STELLALUNITE_BONE);

            event.accept(ModItems.BONE_MARROW);

            event.accept(ModItems.WAND);
        }

        if (event.getTabKey() == ModCreativeModeTabs.STELLALUNITE_BLOCKS_TAB.getKey()) {
            event.accept(ModBlocks.STELLALUNITE_BLOCK);
            event.accept(ModBlocks.RAW_STELLALUNITE_BLOCK);
            event.accept(ModBlocks.STELLALUNITE_ORE);
            event.accept(ModBlocks.STELLALUNITE_DEEPSLATE_ORE);
            event.accept(ModBlocks.MAGIC_BLOCK);
            event.accept(ModBlocks.DUPLICATE_BLOCK);
        }

        if (event.getTabKey() == ModCreativeModeTabs.STELLALUNITE_FOODS_TAB.getKey()) {
            event.accept(ModItems.INBONE_STEAK);
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
