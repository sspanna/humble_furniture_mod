package dev.tee3.humble_furniture.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import dev.tee3.humble_furniture.Humble_furniture;

public class ModEntities {
	public static final ResourceKey<EntityType<?>> CHAIR_SEAT_KEY =
			ResourceKey.create(Registries.ENTITY_TYPE, Humble_furniture.id("chair_seat"));
	public static final EntityType<ChairSeatEntity> CHAIR_SEAT = EntityType.Builder
			.<ChairSeatEntity>of(ChairSeatEntity::new, MobCategory.MISC)
			.sized(0.98f, 0.1f)
			.noSummon()
			.build(CHAIR_SEAT_KEY);

	public static void initialize() {
		Registry.register(BuiltInRegistries.ENTITY_TYPE, CHAIR_SEAT_KEY, CHAIR_SEAT);
	}
}
