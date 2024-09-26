package com.pyrocoder.stellalunitemod.datagen;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.block.ModBlocks;
import com.pyrocoder.stellalunitemod.block.custom.StellaluniteLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
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

        stairsBlock(ModBlocks.STELLALUNITE_STAIR.get(), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()));
        slabBlock(ModBlocks.STELLALUNITE_SLAB.get(), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()));

        buttonBlock(ModBlocks.CRASH_BUTTON.get(), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()));

        buttonBlock(ModBlocks.STELLALUNITE_BUTTON.get(), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.STELLALUNITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()));

        fenceBlock(ModBlocks.STELLALUNITE_FENCE.get(), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.STELLALUNITE_FENCE_GATE.get(), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()));
        wallBlock(ModBlocks.STELLALUNITE_WALL.get(), blockTexture(ModBlocks.STELLALUNITE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.STELLALUNITE_DOOR.get(), modLoc("block/stellalunite_door_bottom"), modLoc("block/stellalunite_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.STELLALUNITE_TRAP_DOOR.get(), modLoc("block/stellalunite_trap_door"), true, "cutout");


        blockItem(ModBlocks.STELLALUNITE_STAIR);
        blockItem(ModBlocks.STELLALUNITE_SLAB);

        blockItem(ModBlocks.STELLALUNITE_PRESSURE_PLATE);

        blockItem(ModBlocks.STELLALUNITE_FENCE_GATE);

        blockItem(ModBlocks.STELLALUNITE_TRAP_DOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.STELLALUNITE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(StellaluniteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("stellalunite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(StellaluniteMod.MOD_ID, "block/" + "stellalunite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("stellalunite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(StellaluniteMod.MOD_ID, "block/" + "stellalunite_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.STELLALUNITE_LAMP.get(), models().cubeAll("stellalunite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(StellaluniteMod.MOD_ID, "block/" + "stellalunite_lamp_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("stellalunitemod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("stellalunitemod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
