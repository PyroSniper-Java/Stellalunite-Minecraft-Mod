package com.pyrocoder.stellalunitemod.datagen;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StellaluniteMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STELLALUNITE.get());
        basicItem(ModItems.RAW_STELLALUNITE.get());

        basicItem(ModItems.STELLALUNITE_BONE.get());

        basicItem(ModItems.INBONE_STEAK.get());
        basicItem(ModItems.BONE_MARROW.get());
        basicItem(ModItems.WAND.get());
    }
}
