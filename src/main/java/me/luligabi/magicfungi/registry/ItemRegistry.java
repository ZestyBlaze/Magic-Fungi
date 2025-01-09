package me.luligabi.magicfungi.registry;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.item.GlyphItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MagicFungi.MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MagicFungi.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MF_TAB = CREATIVE_TABS.register("magic_fungi", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.magicfungi"))
            .icon(ItemRegistry.VIVIFICA_MUSHROOM.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> ItemRegistry.ITEMS.getEntries().forEach(i -> {
                if (!(i.get() instanceof GlyphItem))
                    output.accept(i.get());
            }))
            .build()
    );

    public static final DeferredItem<BlockItem> IMPETUS_MUSHROOM = ITEMS.registerSimpleBlockItem(BlockRegistry.IMPETUS_MUSHROOM);
    public static final DeferredItem<BlockItem> CLYPEUS_MUSHROOM = ITEMS.registerSimpleBlockItem(BlockRegistry.CLYPEUS_MUSHROOM);
    public static final DeferredItem<BlockItem> UTILIS_MUSHROOM = ITEMS.registerSimpleBlockItem(BlockRegistry.UTILIS_MUSHROOM);
    public static final DeferredItem<BlockItem> VIVIFICA_MUSHROOM = ITEMS.registerSimpleBlockItem(BlockRegistry.VIVIFICA_MUSHROOM);
    public static final DeferredItem<BlockItem> MORBUS_MUSHROOM = ITEMS.registerSimpleBlockItem(BlockRegistry.MORBUS_MUSHROOM);

    public static final DeferredItem<GlyphItem> GLYPH = ITEMS.register("glyph_item", () -> new GlyphItem(new Item.Properties().setId(createKey("glyph_item"))));

    private static ResourceKey<Item> createKey(String id) {
        return ResourceKey.create(Registries.ITEM, MagicFungi.createID(id));
    }
}
