package com.pyrocoder.stellalunitemod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class StellaluniteBone extends Item {
    public StellaluniteBone(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {

        if(pInteractionTarget instanceof Wolf wolf){
            if(!wolf.isAngry() && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(wolf, pPlayer)){
                wolf.tame(pPlayer);
                wolf.setTarget(null);
                wolf.setOrderedToSit(true);
                wolf.getNavigation().stop();
                wolf.level().broadcastEntityEvent(wolf, (byte)7);
            }
        }
        return null;
    }
}
