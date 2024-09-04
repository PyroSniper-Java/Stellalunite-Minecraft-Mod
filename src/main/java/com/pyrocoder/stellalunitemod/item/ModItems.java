package com.pyrocoder.stellalunitemod.item;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.item.custom.WandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, StellaluniteMod.MOD_ID);

    public static final RegistryObject<Item> STELLALUNITE = ITEMS.register("stellalunite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_STELLALUNITE = ITEMS.register("raw_stellalunite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STELLALUNITE_BONE = ITEMS.register("stellalunite_bone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new WandItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
