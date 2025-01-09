package me.luligabi.magicfungi.block.mushroom;

import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MorbusMushroomPlantBlock extends MagicMushroomPlantBlock {
    private static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.5D, 13.0D);

    public MorbusMushroomPlantBlock(Properties properties) {
        super(properties, MushroomType.MORBUS);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
