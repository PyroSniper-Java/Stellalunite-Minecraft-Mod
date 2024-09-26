package com.pyrocoder.stellalunitemod.datagen;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.block.ModBlocks;
import com.pyrocoder.stellalunitemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, StellaluniteMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STELLALUNITE_BLOCK.get())
                .add(ModBlocks.RAW_STELLALUNITE_BLOCK.get())
                .add(ModBlocks.STELLALUNITE_ORE.get())
                .add(ModBlocks.STELLALUNITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.DUPLICATE_BLOCK.get())
                .add(Blocks.BEDROCK);

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STELLALUNITE_BLOCK.get())
                .add(ModBlocks.RAW_STELLALUNITE_BLOCK.get())
                .add(ModBlocks.STELLALUNITE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.STELLALUNITE_DEEPSLATE_ORE.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.STELLALUNITE_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.STELLALUNITE_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.STELLALUNITE_WALL.get());

        tag(ModTags.Blocks.NEEDS_STELLALUNITE_TOOL)
                .add(Blocks.BEDROCK)
                .addTags(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_STELLALUNITE_TOOL)
                .addTags(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(ModTags.Blocks.NEEDS_STELLALUNITE_TOOL);
    }
}
