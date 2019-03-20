package com.unrealdinnerbone.leathercows.mixin;

import com.unrealdinnerbone.leathercows.item.DropCalculatorItem;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public class MobEntityMixin {

//    @Inject(method = "interact(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Z", at = @At("HEAD"))
    public void onMobClick(PlayerEntity playerEntity, Hand hand, CallbackInfoReturnable callbackInfo) {
        DropCalculatorItem.onEntityClicked(playerEntity, hand, getThis());
    }

    public MobEntity getThis() {
        return ((MobEntity) (Object) this);
    }
}
