package com.pyrocoder.stellalunitemod.item.custom;

import com.pyrocoder.stellalunitemod.StellaluniteMod;
import com.pyrocoder.stellalunitemod.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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
                wolf.level().broadcastEntityEvent(wolf, (byte)7);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
