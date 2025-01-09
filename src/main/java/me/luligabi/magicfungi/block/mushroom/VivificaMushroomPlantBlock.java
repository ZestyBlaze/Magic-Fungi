package me.luligabi.magicfungi.block.mushroom;

import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VivificaMushroomPlantBlock extends MagicMushroomPlantBlock {
    private static final VoxelShape SHAPE = Block.box(4.5D, 0.0D, 4.5D, 11.5D, 9.5D, 11.5D);

    public VivificaMushroomPlantBlock(Properties properties) {
        super(properties, MushroomType.VIVIFICA);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
