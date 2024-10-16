package com.pyrocoder.stellalunitemod.item.custom;

import com.pyrocoder.stellalunitemod.block.ModBlocks;
import com.pyrocoder.stellalunitemod.component.ModDataComponentTypes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class WandItem extends Item {
    private static final Map<Block, Block> WAND_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.DIRT, Blocks.BEDROCK,
                    Blocks.BEDROCK, Blocks.DIRT
            );

    private static final Map<Block, Block> CRASH_MAP =
            Map.of(
                    ModBlocks.CRASH_BUTTON.get(), Blocks.BARRIER
            );

    public WandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (WAND_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()){
                level.setBlockAndUpdate(pContext.getClickedPos(), WAND_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.stellalunitemod.wand_shift"));
        } else if(Screen.hasAltDown()){
            pTooltipComponents.add(Component.translatable("tooltip.stellalunitemod.wand_alt1"));
            pTooltipComponents.add(Component.translatable("tooltip.stellalunitemod.wand_alt2"));
            pTooltipComponents.add(Component.translatable("tooltip.stellalunitemod.wand_alt3"));
            pTooltipComponents.add(Component.translatable("tooltip.stellalunitemod.wand_alt4"));
            pTooltipComponents.add(Component.translatable("tooltip.stellalunitemod.wand_alt5"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.stellalunitemod.wand_null"));
        }

        if (pStack.get(ModDataComponentTypes.COORDINATES.get()) != null) {
            pTooltipComponents.add(Component.literal("Last Block Changed At " + pStack.get(ModDataComponentTypes.COORDINATES.get())));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
