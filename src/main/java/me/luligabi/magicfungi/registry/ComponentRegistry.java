package me.luligabi.magicfungi.registry;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.glyph.GlyphData;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ComponentRegistry {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, MagicFungi.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<GlyphData>> GLYPH_DATA =
            COMPONENTS.registerComponentType("glyph_data", builder -> builder.persistent(GlyphData.CODEC).networkSynchronized(GlyphData.STREAM_CODEC));
}
