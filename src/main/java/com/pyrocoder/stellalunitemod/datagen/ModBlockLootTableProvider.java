package com.pyrocoder.stellalunitemod.datagen;

import com.pyrocoder.stellalunitemod.block.ModBlocks;
import com.pyrocoder.stellalunitemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.STELLALUNITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_STELLALUNITE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.DUPLICATE_BLOCK.get(),
                block -> createMultipleDrops(ModBlocks.DUPLICATE_BLOCK.get(), ModBlocks.DUPLICATE_BLOCK.get(), 2, 4));

        this.add(ModBlocks.STELLALUNITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.STELLALUNITE_ORE.get(), ModItems.RAW_STELLALUNITE.get(), 64, 128));
        this.add(ModBlocks.STELLALUNITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.STELLALUNITE_DEEPSLATE_ORE.get(), ModItems.RAW_STELLALUNITE.get(), 32, 64));

        dropSelf(ModBlocks.CRASH_BUTTON.get());

        dropSelf(ModBlocks.STELLALUNITE_STAIR.get());
        this.add(ModBlocks.STELLALUNITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.STELLALUNITE_SLAB.get()));

        dropSelf(ModBlocks.STELLALUNITE_BUTTON.get());
        dropSelf(ModBlocks.STELLALUNITE_PRESSURE_PLATE.get());

        dropSelf(ModBlocks.STELLALUNITE_FENCE.get());
        dropSelf(ModBlocks.STELLALUNITE_FENCE_GATE.get());
        dropSelf(ModBlocks.STELLALUNITE_WALL.get());

        this.add(ModBlocks.STELLALUNITE_DOOR.get(),
                block -> createDoorTable(ModBlocks.STELLALUNITE_DOOR.get()));
        dropSelf(ModBlocks.STELLALUNITE_TRAP_DOOR.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    protected LootTable.Builder createMultipleDrops(Block pBlock, Block block, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(block)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
