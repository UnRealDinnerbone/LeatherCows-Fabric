package com.unrealdinnerbone.leathercows;

import com.unrealdinnerbone.leathercows.item.DropCalculatorItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LeatherCowItems
{
    public static DropCalculatorItem itemDropCalculator;
    public static ItemGroup itemGroup;

    public static void initItems() {
        itemGroup = FabricItemGroupBuilder.build(new Identifier(LeatherCows.MOD_ID, LeatherCows.MOD_ID), () -> new ItemStack(itemDropCalculator));
        itemDropCalculator = Registry.register(Registry.ITEM, new Identifier(LeatherCows.MOD_ID, "dropcalculator"), new DropCalculatorItem());
    }
}
