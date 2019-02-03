package com.unrealdinnerbone.leathercows.api;

import net.minecraft.item.Item;

public interface IDropperItemEntity {
    int getLCTimeTillNextDrop();
    Item getLCItemDrooped();
}
