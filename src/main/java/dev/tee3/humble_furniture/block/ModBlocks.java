package dev.tee3.humble_furniture.block;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import dev.tee3.humble_furniture.Humble_furniture;

public class ModBlocks {
	public static final ResourceKey<Block> COOL_BLOCK_1_KEY =
			ResourceKey.create(Registries.BLOCK, Humble_furniture.id("cool_block_1"));
	public static final Block COOL_BLOCK_1 = new Block(
			BlockBehaviour.Properties.of()
					.setId(COOL_BLOCK_1_KEY)
					.strength(2.0f)
					.sound(SoundType.STONE));

	public static void initialize() {
		Registry.register(BuiltInRegistries.BLOCK, COOL_BLOCK_1_KEY, COOL_BLOCK_1);

		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Humble_furniture.id("cool_block_1"));
		Registry.register(
				BuiltInRegistries.ITEM,
				itemKey,
				new BlockItem(COOL_BLOCK_1, new Item.Properties().setId(itemKey)));

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
				.register(output -> output.accept(COOL_BLOCK_1));
	}
}
