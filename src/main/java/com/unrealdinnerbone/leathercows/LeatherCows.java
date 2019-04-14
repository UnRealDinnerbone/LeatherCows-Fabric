package com.unrealdinnerbone.leathercows;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;

public class LeatherCows implements ModInitializer {

    public static final String MOD_ID = "leathercows";

    @Override
	public void onInitialize() {
        System.out.println("Loading LeatherCows!");
        LeatherCowItems.initItems();
    }
}
