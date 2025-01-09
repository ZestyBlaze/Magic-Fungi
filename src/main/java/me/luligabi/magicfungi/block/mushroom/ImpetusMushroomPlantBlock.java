package me.luligabi.magicfungi.block.mushroom;

import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ImpetusMushroomPlantBlock extends MagicMushroomPlantBlock {
    private static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);

    public ImpetusMushroomPlantBlock(Properties properties) {
        super(properties, MushroomType.IMPETUS);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
