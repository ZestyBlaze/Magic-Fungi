package me.luligabi.magicfungi.block.mushroom;

import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;

public class MagicMushroomPlantBlock extends MushroomBlock {
    private final MushroomType mushroomType;

    public MagicMushroomPlantBlock(Properties properties, MushroomType mushroomType) {
        super(null, properties);
        this.mushroomType = mushroomType;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        Block[] bannedStates = {Blocks.SAND, Blocks.RED_SAND, Blocks.GRAVEL, Blocks.PACKED_ICE};

        if (belowState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return level.getRawBrightness(pos, 0) < 13 && mayPlaceOn(state, level, pos) && !Arrays.asList(bannedStates).contains(belowState.getBlock());
        }
    }

    public MushroomType getMushroomType() {
        return this.mushroomType;
    }

    @Override
    protected void randomTick(BlockState p_221784_, ServerLevel p_221785_, BlockPos p_221786_, RandomSource p_221787_) {
    }

    @Override
    public boolean growMushroom(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        return false;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_255904_, BlockPos p_54871_, BlockState p_54872_) {
        return false;
    }

    @Override
    public void performBonemeal(ServerLevel p_221769_, RandomSource p_221770_, BlockPos p_221771_, BlockState p_221772_) {
    }
}
