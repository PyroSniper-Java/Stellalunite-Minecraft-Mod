package com.pyrocoder.stellalunitemod.datagen;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.item.ModItems;
import com.pyrocoder.stellalunitemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                              CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, StellaluniteMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.WOLF_FOOD)
                .add(ModItems.STELLALUNITE_BONE.get());
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.STELLALUNITE.get())
                .add(ModItems.RAW_STELLALUNITE.get())
                .add(ModItems.BONE_MARROW.get())
                .add(Items.REDSTONE);
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.STELLALUNITE_BOOTS.get())
                .add(ModItems.STELLALUNITE_LEGGINGS.get())
                .add(ModItems.STELLALUNITE_CHESTPLATE.get())
                .add(ModItems.STELLALUNITE_HELMET.get());
    }
}
