package com.pyrocoder.stellalunitemod.block;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StellaluniteMod.MOD_ID);

    public static final RegistryObject<Block> STELLALUNITE_BLOCK = registerBlock("stellalunite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_STELLALUNITE_BLOCK = registerBlock("raw_stellalunite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> STELLALUNITE_ORE = registerBlock("stellalunite_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 4), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> STELLALUNITE_DEEPSLATE_ORE = registerBlock("stellalunite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 8), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
