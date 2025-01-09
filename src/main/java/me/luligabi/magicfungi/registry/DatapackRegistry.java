package me.luligabi.magicfungi.registry;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.glyph.GlyphData;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

@EventBusSubscriber(modid = MagicFungi.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DatapackRegistry {
    public static final ResourceKey<Registry<GlyphData>> GLYPHS = ResourceKey.createRegistryKey(MagicFungi.createID("glyphs"));

    @SubscribeEvent
    public static void registerCustomPacks(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(GLYPHS, GlyphData.CODEC, GlyphData.CODEC);
    }
}
