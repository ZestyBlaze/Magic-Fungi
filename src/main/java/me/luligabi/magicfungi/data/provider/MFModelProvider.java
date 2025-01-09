package me.luligabi.magicfungi.data.provider;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.client.property.MushroomTypeProperty;
import me.luligabi.magicfungi.registry.BlockRegistry;
import me.luligabi.magicfungi.registry.ItemRegistry;
import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MFModelProvider extends ModelProvider {
    public MFModelProvider(PackOutput output) {
        super(output, MagicFungi.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        createCrossBlockWithDefaultItem(blockModels, BlockRegistry.IMPETUS_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED, "cutout");
        createCrossBlockWithDefaultItem(blockModels, BlockRegistry.CLYPEUS_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED, "cutout");
        createCrossBlockWithDefaultItem(blockModels, BlockRegistry.UTILIS_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED, "cutout");
        createCrossBlockWithDefaultItem(blockModels, BlockRegistry.VIVIFICA_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED, "cutout");
        createCrossBlockWithDefaultItem(blockModels, BlockRegistry.MORBUS_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED, "cutout");

        createGlyphItem(itemModels, ItemRegistry.GLYPH.get());
    }

    private void createCrossBlockWithDefaultItem(BlockModelGenerators blockModels, Block block, BlockModelGenerators.PlantType plantType, String renderType) {
        blockModels.registerSimpleFlatItemModel(block);
        this.createCrossBlock(blockModels, block, plantType, renderType);
    }

    private void createCrossBlock(BlockModelGenerators blockModels, Block block, BlockModelGenerators.PlantType plantType, String renderType) {
        TextureMapping texturemapping = plantType.getTextureMapping(block);
        ResourceLocation resourcelocation = plantType.getCross().extend().renderType(renderType).build().create(block, texturemapping, blockModels.modelOutput);
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, resourcelocation));
    }

    private void createGlyphItem(ItemModelGenerators itemModels, Item glyphItem) {
        ItemModel.Unbaked itemModel$plain = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(glyphItem));
        ItemModel.Unbaked itemModel$impetus = ItemModelUtils.plainModel(itemModels.generateLayeredItem(
                ModelLocationUtils.getModelLocation(glyphItem, "_impetus"),
                ModelLocationUtils.getModelLocation(glyphItem),
                ModelLocationUtils.getModelLocation(glyphItem, "_impetus"))
        );
        ItemModel.Unbaked itemModel$clypeus = ItemModelUtils.plainModel(itemModels.generateLayeredItem(
                ModelLocationUtils.getModelLocation(glyphItem, "_clypeus"),
                ModelLocationUtils.getModelLocation(glyphItem),
                ModelLocationUtils.getModelLocation(glyphItem, "_clypeus"))
        );
        ItemModel.Unbaked itemModel$utilis = ItemModelUtils.plainModel(itemModels.generateLayeredItem(
                ModelLocationUtils.getModelLocation(glyphItem, "_utilis"),
                ModelLocationUtils.getModelLocation(glyphItem),
                ModelLocationUtils.getModelLocation(glyphItem, "_utilis"))
        );
        ItemModel.Unbaked itemModel$vivifica = ItemModelUtils.plainModel(itemModels.generateLayeredItem(
                ModelLocationUtils.getModelLocation(glyphItem, "_vivifica"),
                ModelLocationUtils.getModelLocation(glyphItem),
                ModelLocationUtils.getModelLocation(glyphItem, "_vivifica")));
        ItemModel.Unbaked itemModel$morbus = ItemModelUtils.plainModel(itemModels.generateLayeredItem(
                ModelLocationUtils.getModelLocation(glyphItem, "_morbus"),
                ModelLocationUtils.getModelLocation(glyphItem),
                ModelLocationUtils.getModelLocation(glyphItem, "_morbus"))
        );

        itemModels.itemModelOutput
                .accept(
                        glyphItem,
                        ItemModelUtils.select(new MushroomTypeProperty(),
                                itemModel$plain,
                                ItemModelUtils.when(MushroomType.IMPETUS, itemModel$impetus),
                                ItemModelUtils.when(MushroomType.CLYPEUS, itemModel$clypeus),
                                ItemModelUtils.when(MushroomType.UTILIS, itemModel$utilis),
                                ItemModelUtils.when(MushroomType.VIVIFICA, itemModel$vivifica),
                                ItemModelUtils.when(MushroomType.MORBUS, itemModel$morbus)
                        )
                );
    }
}
