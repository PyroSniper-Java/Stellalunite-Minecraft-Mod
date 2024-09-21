package com.pyrocoder.stellalunitemod.block;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.block.custom.MagicBlock;
import com.pyrocoder.stellalunitemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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
                    .strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> DUPLICATE_BLOCK = registerBlock("duplicate_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.SUSPICIOUS_GRAVEL)));

    public static final RegistryObject<Block> RAW_STELLALUNITE_BLOCK = registerBlock("raw_stellalunite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> STELLALUNITE_ORE = registerBlock("stellalunite_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 4), BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE)));

    public static final RegistryObject<Block> STELLALUNITE_DEEPSLATE_ORE = registerBlock("stellalunite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 8), BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<StairBlock> STELLALUNITE_STAIR = registerBlock("stellalunite_stair",
            () -> new StairBlock(ModBlocks.STELLALUNITE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> STELLALUNITE_SLAB = registerBlock("stellalunite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()));

    public static final RegistryObject<ButtonBlock> CRASH_BUTTON = registerBlock("crash_button",
            () -> new ButtonBlock(BlockSetType.BAMBOO, 1, BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .noCollission()));

    public static final RegistryObject<PressurePlateBlock> STELLALUNITE_PRESSURE_PLATE = registerBlock("stellalunite_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> STELLALUNITE_BUTTON = registerBlock("stellalunite_button",
            () -> new ButtonBlock(BlockSetType.IRON, 1, BlockBehaviour.Properties.of()
                    .noCollission()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<FenceBlock> STELLALUNITE_FENCE = registerBlock("stellalunite_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> STELLALUNITE_FENCE_GATE = registerBlock("stellalunite_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));
   public static final RegistryObject<WallBlock> STELLALUNITE_WALL = registerBlock("stellalunite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> STELLALUNITE_DOOR = registerBlock("stellalunite_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));
   public static final RegistryObject<TrapDoorBlock> STELLALUNITE_TRAP_DOOR = registerBlock("stellalunite_trap_door",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

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
