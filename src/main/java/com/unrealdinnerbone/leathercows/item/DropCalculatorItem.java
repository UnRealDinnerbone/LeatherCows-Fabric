package com.unrealdinnerbone.leathercows.item;

import com.unrealdinnerbone.leathercows.LeatherCowItems;
import com.unrealdinnerbone.leathercows.api.IDropperItemEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.text.StringTextComponent;
import net.minecraft.text.TextComponent;
import net.minecraft.text.TranslatableTextComponent;
import net.minecraft.util.Hand;

public class DropCalculatorItem extends Item {

    public DropCalculatorItem() {
        super(new Settings().itemGroup(LeatherCowItems.itemGroup));
    }

    public static void onEntityClicked(PlayerEntity playerEntity, Hand hand, MobEntity mobEntity) {
        if (!playerEntity.world.isClient()) {
            System.out.println(playerEntity.getStackInHand(hand).getItem());
            if (playerEntity.getStackInHand(hand).getItem() instanceof DropCalculatorItem)
                if (mobEntity instanceof IDropperItemEntity) {
                    IDropperItemEntity iDropperItemEntity = (IDropperItemEntity) mobEntity;
                    TextComponent textComponent = new StringTextComponent("Next ").append(new TranslatableTextComponent(iDropperItemEntity.getLCItemDrooped().getTranslationKey()).append(new StringTextComponent(" Drop in " + iDropperItemEntity.getLCTimeTillNextDrop() / 20 + "s")));
                    playerEntity.addChatMessage(textComponent, true);
                }
        }
    }
}
