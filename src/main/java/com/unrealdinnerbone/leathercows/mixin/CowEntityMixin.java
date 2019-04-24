package com.unrealdinnerbone.leathercows.mixin;

import com.unrealdinnerbone.leathercows.api.IDropperItemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CowEntity.class)
public abstract class CowEntityMixin extends AnimalEntity implements IDropperItemEntity {

    private int leatherDropTime;
    private boolean isPowerCow;

    public CowEntityMixin(EntityType<? extends CowEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V", at = @At("RETURN"))
    public void onInit(CallbackInfo callbackReference) {
        updateLeatherDropTime();
    }

    @Override
    public void updateState() {
        super.updateState();
        if (!this.world.isClient && !this.isChild() && --this.leatherDropTime <= 0) {
            this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Items.LEATHER);
            updateLeatherDropTime();
        }
    }


    @Override
    public void onStruckByLightning(LightningEntity lightningEntity) {
        if(this.isPowerCow) {
            super.onStruckByLightning(lightningEntity);
        }else {
            isPowerCow = true;
            this.addPotionEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 10, 10));
        }
    }

    @Override
    public void writeCustomDataToTag(CompoundTag compoundTag) {
        compoundTag.putBoolean("isPowerCow", isPowerCow);
        super.writeCustomDataToTag(compoundTag);
    }

    @Override
    public void readCustomDataFromTag(CompoundTag compoundTag) {
        isPowerCow = compoundTag.getBoolean("isPowerCow");
        super.readCustomDataFromTag(compoundTag);
    }

    private void updateLeatherDropTime() {
        int time = isPowerCow ? 3000 : 6000;
        leatherDropTime = this.random.nextInt(time) + time;
    }

    @Override
    public int getLCTimeTillNextDrop() {
        return leatherDropTime;
    }

    @Override
    public Item getLCItemDrooped() {
        return Items.LEATHER;
    }
}

