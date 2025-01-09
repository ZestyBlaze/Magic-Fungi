package me.luligabi.magicfungi.registry;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.block.mushroom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MagicFungi.MODID);

    public static final DeferredBlock<Block> IMPETUS_MUSHROOM = BLOCKS.register("impetus_mushroom", () -> new ImpetusMushroomPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED).noCollission().instabreak().sound(SoundType.GRASS).setId(createKey("impetus_mushroom"))));

    public static final DeferredBlock<Block> CLYPEUS_MUSHROOM = BLOCKS.register("clypeus_mushroom", () -> new ClypeusMushroomPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.GRASS).setId(createKey("clypeus_mushroom"))));

    public static final DeferredBlock<Block> UTILIS_MUSHROOM = BLOCKS.register("utilis_mushroom", () -> new UtilisMushroomPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).noCollission().instabreak().sound(SoundType.GRASS).setId(createKey("utilis_mushroom"))));

    public static final DeferredBlock<Block> VIVIFICA_MUSHROOM = BLOCKS.register("vivifica_mushroom", () -> new VivificaMushroomPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).noCollission().instabreak().sound(SoundType.GRASS).setId(createKey("vivifica_mushroom"))));

    public static final DeferredBlock<Block> MORBUS_MUSHROOM = BLOCKS.register("morbus_mushroom", () -> new MorbusMushroomPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).noCollission().instabreak().sound(SoundType.GRASS).setId(createKey("morbus_mushroom"))));

    private static ResourceKey<Block> createKey(String id) {
        return ResourceKey.create(Registries.BLOCK, MagicFungi.createID(id));
    }
}
