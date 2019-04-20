package com.unrealdinnerbone.leathercows;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeatherCows implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "leathercows";

    @Override
	public void onInitialize() {
        LOGGER.info("[LeatherCows] Loading!");
        LeatherCowItems.initItems();
    }
}
