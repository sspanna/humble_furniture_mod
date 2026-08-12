package dev.tee3.humble_furniture.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import dev.tee3.humble_furniture.Humble_furniture;

public class ModItems {
	public static final ResourceKey<Item> SWORD_KEY =
			ResourceKey.create(Registries.ITEM, Humble_furniture.id("sword"));
	public static final Item SWORD = new Item(new Item.Properties().setId(SWORD_KEY));

	public static void initialize() {
		Registry.register(BuiltInRegistries.ITEM, SWORD_KEY, SWORD);

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
				.register(output -> output.accept(SWORD));
	}
}
