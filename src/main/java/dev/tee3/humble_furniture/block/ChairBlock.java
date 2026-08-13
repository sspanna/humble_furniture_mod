package dev.tee3.humble_furniture.block;

import java.util.Map;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import dev.tee3.humble_furniture.entity.ChairSeatEntity;
import dev.tee3.humble_furniture.entity.ModEntities;

public class ChairBlock extends HorizontalDirectionalBlock {
	public static final MapCodec<ChairBlock> CODEC = simpleCodec(ChairBlock::new);

	// Matches the seat surface height (y=7.2/16) modeled in chair.json.
	private static final double SEAT_HEIGHT = 7.2 / 16.0;

	private static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(buildNorthShape());

	public ChairBlock(BlockBehaviour.Properties properties) {
		super(properties);
		registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
	}

	@Override
	protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
		return CODEC;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPES.get(state.getValue(FACING));
	}

	@Override
	protected InteractionResult useWithoutItem(
			BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
		if (player.isPassenger()) {
			return InteractionResult.PASS;
		}
		if (level.isClientSide()) {
			return InteractionResult.SUCCESS;
		}
		if (!(level instanceof ServerLevel serverLevel) || isOccupied(serverLevel, pos)) {
			return InteractionResult.CONSUME;
		}

		ChairSeatEntity seat = new ChairSeatEntity(ModEntities.CHAIR_SEAT, serverLevel);
		seat.setPos(pos.getX() + 0.5, pos.getY() + SEAT_HEIGHT, pos.getZ() + 0.5);
		serverLevel.addFreshEntity(seat);
		player.startRiding(seat);
		return InteractionResult.CONSUME;
	}

	private static boolean isOccupied(ServerLevel level, BlockPos pos) {
		return !level.getEntitiesOfClass(ChairSeatEntity.class, new AABB(pos)).isEmpty();
	}

	private static VoxelShape buildNorthShape() {
		VoxelShape shape = box(5.6, 6.2, 3.8, 11.6, 7.2, 10.8);
		shape = Shapes.or(shape, box(11.1, 4, 3.5, 12.1, 16, 4.5));
		shape = Shapes.or(shape, box(5.1, 4, 3.5, 6.1, 16, 4.5));
		shape = Shapes.or(shape, box(5.1, 4, 10.5, 6.1, 9, 11.5));
		shape = Shapes.or(shape, box(11.1, 4, 10.5, 12.1, 9, 11.5));
		shape = Shapes.or(shape, box(5, 9, 4, 12, 15, 5));
		return shape;
	}
}
