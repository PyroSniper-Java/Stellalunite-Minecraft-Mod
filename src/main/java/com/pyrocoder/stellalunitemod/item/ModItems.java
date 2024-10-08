package com.pyrocoder.stellalunitemod.item;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.item.custom.FuelItem;
import com.pyrocoder.stellalunitemod.item.custom.HammerItem;
import com.pyrocoder.stellalunitemod.item.custom.StellaluniteBone;
import com.pyrocoder.stellalunitemod.item.custom.WandItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
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

    //Tools
    public static final RegistryObject<Item> STELLALUNITE_SWORD = ITEMS.register("stellalunite_sword",
            () -> new SwordItem(ModToolTiers.STELLALUNITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.STELLALUNITE, 3, -2.4f))));
    public static final RegistryObject<Item> STELLALUNITE_PICKAXE = ITEMS.register("stellalunite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STELLALUNITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STELLALUNITE, 1, -2.8f))));
    public static final RegistryObject<Item> STELLALUNITE_SHOVEL = ITEMS.register("stellalunite_shovel",
            () -> new ShovelItem(ModToolTiers.STELLALUNITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.STELLALUNITE, 1.5f, -3.0f))));
    public static final RegistryObject<Item> STELLALUNITE_AXE = ITEMS.register("stellalunite_axe",
            () -> new AxeItem(ModToolTiers.STELLALUNITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.STELLALUNITE, 6, -3.2f))));
    public static final RegistryObject<Item> STELLALUNITE_HOE = ITEMS.register("stellalunite_hoe",
            () -> new HoeItem(ModToolTiers.STELLALUNITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.STELLALUNITE, 0, -3.0f))));

    public static final RegistryObject<Item> STELLALUNITE_HAMMER = ITEMS.register("stellalunite_hammer",
            () -> new HammerItem(ModToolTiers.STELLALUNITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STELLALUNITE, 1, -2.8f))));

    //ARMOR
    public static final RegistryObject<Item> STELLALUNITE_BOOTS = ITEMS.register("stellalunite_boots",
            () -> new ArmorItem(ModArmorMaterials.STELLALUNITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(100))));
    public static final RegistryObject<Item> STELLALUNITE_LEGGINGS = ITEMS.register("stellalunite_leggings",
            () -> new ArmorItem(ModArmorMaterials.STELLALUNITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(100))));
    public static final RegistryObject<Item> STELLALUNITE_CHESTPLATE = ITEMS.register("stellalunite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STELLALUNITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(100))));
    public static final RegistryObject<Item> STELLALUNITE_HELMET = ITEMS.register("stellalunite_helmet",
            () -> new ArmorItem(ModArmorMaterials.STELLALUNITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(100))));
    public static final RegistryObject<Item> STELLALUNITE_BODY = ITEMS.register("stellalunite_body",
            () -> new ArmorItem(ModArmorMaterials.STELLALUNITE_ARMOR_MATERIAL, ArmorItem.Type.BODY,
                    new Item.Properties().durability(ArmorItem.Type.BODY.getDurability(100))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
