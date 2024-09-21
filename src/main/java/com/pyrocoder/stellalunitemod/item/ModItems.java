package com.pyrocoder.stellalunitemod.item;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.item.custom.FuelItem;
import com.pyrocoder.stellalunitemod.item.custom.StellaluniteBone;
import com.pyrocoder.stellalunitemod.item.custom.WandItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, StellaluniteMod.MOD_ID);

    //Items Used In Crafting (No Real Functions)
    public static final RegistryObject<Item> STELLALUNITE = ITEMS.register("stellalunite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_STELLALUNITE = ITEMS.register("raw_stellalunite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IDK = ITEMS.register("idk",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STELLALUNITE_BONE = ITEMS.register("stellalunite_bone",
            () -> new StellaluniteBone(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.stellalunitemod.stellalunite_bone"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    //Custom Items With Functions
    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new WandItem(new Item.Properties().durability(32)));

    //Food Items
    public static final RegistryObject<Item> INBONE_STEAK = ITEMS.register("inbone_steak",
            () -> new Item(new Item.Properties().food(ModFoodProperties.INBONE_STEAK)));

    //Fuel Items
    public static final RegistryObject<Item> BONE_MARROW = ITEMS.register("bone_marrow",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
