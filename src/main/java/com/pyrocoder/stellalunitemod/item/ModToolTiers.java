package com.pyrocoder.stellalunitemod.item;

import com.pyrocoder.stellalunitemod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier STELLALUNITE = new ForgeTier(1200, 18.0F, 999, 288,
            ModTags.Blocks.NEEDS_STELLALUNITE_TOOL, () -> Ingredient.of(ModItems.STELLALUNITE.get()),
            ModTags.Blocks.INCORRECT_FOR_STELLALUNITE_TOOL);
}
