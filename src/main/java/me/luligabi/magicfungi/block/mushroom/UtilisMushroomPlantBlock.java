package me.luligabi.magicfungi.block.mushroom;

import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UtilisMushroomPlantBlock extends MagicMushroomPlantBlock {
    private static final VoxelShape SHAPE = Block.box(4.5D, 0.0D, 4.5D, 11.5D, 7.0D, 11.5D);

    public UtilisMushroomPlantBlock(Properties properties) {
        super(properties, MushroomType.UTILIS);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
