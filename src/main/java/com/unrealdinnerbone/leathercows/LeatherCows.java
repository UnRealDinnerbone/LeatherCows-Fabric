package com.unrealdinnerbone.leathercows;

import net.fabricmc.api.ModInitializer;

public class LeatherCows implements ModInitializer {

    public static final String MOD_ID = "leathercows";

    @Override
	public void onInitialize() {
        System.out.println("Loading LeatherCows!");
        LeatherCowItems.initItems();
    }
}
