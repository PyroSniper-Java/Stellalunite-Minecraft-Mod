package com.pyrocoder.stellalunitemod.datagen;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.block.ModBlocks;
import com.pyrocoder.stellalunitemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> STELLALUNITE_SMELTABLES = List.of(
                ModItems.RAW_STELLALUNITE.get(),
                ModBlocks.STELLALUNITE_ORE.get(),
                ModBlocks.STELLALUNITE_DEEPSLATE_ORE.get(),
                ModBlocks.RAW_STELLALUNITE_BLOCK.get()
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.INBONE_STEAK.get())
                .pattern("CBC")
                .pattern("BAB")
                .pattern("CBC")
                .define('A', ModItems.STELLALUNITE_BONE.get())
                .define('B', ModItems.BONE_MARROW.get())
                .define('C', Items.BREAD)
                .unlockedBy(getHasName(ModItems.STELLALUNITE_BONE.get()), has(ModItems.STELLALUNITE_BONE.get()))
                .unlockedBy(getHasName(ModItems.BONE_MARROW.get()), has(ModItems.BONE_MARROW.get()))
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BREWING, ModBlocks.MAGIC_BLOCK.get())
                .pattern("aba")
                .pattern("bab")
                .pattern("aba")
                .define('a', ModItems.WAND.get())
                .define('b', Items.BREWING_STAND)
                .unlockedBy(getHasName(ModItems.WAND.get()), has(ModItems.WAND.get()))
                .unlockedBy(getHasName(Items.BREWING_STAND), has(Items.BREWING_STAND))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_STELLALUNITE_BLOCK.get())
                .requires(ModItems.RAW_STELLALUNITE.get(), 9)
                .unlockedBy(getHasName(ModItems.RAW_STELLALUNITE.get()), has(ModItems.RAW_STELLALUNITE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STELLALUNITE.get())
                .requires(ModBlocks.STELLALUNITE_BLOCK.get(), 1)
                .unlockedBy(getHasName(ModBlocks.STELLALUNITE_BLOCK.get()), has(ModBlocks.STELLALUNITE_BLOCK.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_STELLALUNITE.get())
                .requires(ModBlocks.RAW_STELLALUNITE_BLOCK.get(), 1)
                .unlockedBy(getHasName(ModBlocks.RAW_STELLALUNITE_BLOCK.get()), has(ModBlocks.RAW_STELLALUNITE_BLOCK.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STELLALUNITE_BLOCK.get())
                .requires(ModItems.STELLALUNITE.get(), 9)
                .unlockedBy(getHasName(ModItems.STELLALUNITE.get()), has(ModItems.STELLALUNITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STELLALUNITE_BONE.get())
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', ModItems.STELLALUNITE.get())
                .define('b', Items.BONE)
                .unlockedBy(getHasName(ModItems.STELLALUNITE.get()), has(ModItems.STELLALUNITE.get()))
                .unlockedBy(getHasName(Items.BONE), has(Items.BONE))
                .save(pRecipeOutput);

        oreSmelting(pRecipeOutput, STELLALUNITE_SMELTABLES, RecipeCategory.MISC, ModItems.STELLALUNITE.get(), 999999999, 100, "stellalunite");
        oreBlasting(pRecipeOutput, STELLALUNITE_SMELTABLES, RecipeCategory.MISC, ModItems.STELLALUNITE.get(), 999999999, 50, "stellalunite");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WAND.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItems.INBONE_STEAK.get())
                .define('B', Items.BREWING_STAND)
                .unlockedBy(getHasName(ModItems.INBONE_STEAK.get()), has(ModItems.INBONE_STEAK.get()))
                .unlockedBy(getHasName(Items.BREWING_STAND), has(Items.BREWING_STAND))
                .save(pRecipeOutput);

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.EMPTY, RecipeCategory.MISC, ModItems.BONE_MARROW.get(), 900, 100);

        stairBuilder(ModBlocks.STELLALUNITE_STAIR.get(), Ingredient.of(ModItems.STELLALUNITE.get())).group("stellalunite").unlockedBy(getHasName(ModItems.STELLALUNITE.get()), has(ModItems.STELLALUNITE.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STELLALUNITE_SLAB.get(), ModItems.STELLALUNITE.get());

        buttonBuilder(ModBlocks.CRASH_BUTTON.get(), Ingredient.of(ModItems.BONE_MARROW.get())).group("stellalunite").unlockedBy(getHasName(ModItems.BONE_MARROW.get()), has(ModItems.BONE_MARROW.get())).save(pRecipeOutput);
        buttonBuilder(ModBlocks.STELLALUNITE_BUTTON.get(), Ingredient.of(ModItems.STELLALUNITE.get())).group("stellalunite").unlockedBy(getHasName(ModItems.STELLALUNITE.get()), has(ModItems.STELLALUNITE.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.STELLALUNITE_PRESSURE_PLATE.get(), ModItems.STELLALUNITE.get());

        fenceBuilder(ModBlocks.STELLALUNITE_FENCE.get(), Ingredient.of(ModItems.STELLALUNITE.get())).group("stellalunite").unlockedBy(getHasName(ModItems.STELLALUNITE.get()), has(ModItems.STELLALUNITE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.STELLALUNITE_FENCE_GATE.get(), Ingredient.of(ModItems.STELLALUNITE.get())).group("stellalunite").unlockedBy(getHasName(ModItems.STELLALUNITE.get()), has(ModItems.STELLALUNITE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STELLALUNITE_WALL.get(), ModItems.STELLALUNITE.get());

        doorBuilder(ModBlocks.STELLALUNITE_DOOR.get(), Ingredient.of(ModItems.STELLALUNITE.get())).group("stellalunite").unlockedBy(getHasName(ModItems.STELLALUNITE.get()), has(ModItems.STELLALUNITE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.STELLALUNITE_TRAP_DOOR.get(), Ingredient.of(ModItems.STELLALUNITE.get())).group("stellalunite").unlockedBy(getHasName(ModItems.STELLALUNITE.get()), has(ModItems.STELLALUNITE.get())).save(pRecipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, StellaluniteMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
