package com.pyrocoder.stellalunitemod.datagen;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StellaluniteMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.STELLALUNITE_BLOCK);
        blockWithItem(ModBlocks.RAW_STELLALUNITE_BLOCK);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        blockWithItem(ModBlocks.DUPLICATE_BLOCK);

        blockWithItem(ModBlocks.STELLALUNITE_ORE);
        blockWithItem(ModBlocks.STELLALUNITE_DEEPSLATE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
