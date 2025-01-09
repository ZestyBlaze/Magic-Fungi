package me.luligabi.magicfungi.data;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.glyph.GlyphData;
import me.luligabi.magicfungi.registry.DatapackRegistry;
import me.luligabi.magicfungi.glyph.GlyphExecution;
import me.luligabi.magicfungi.util.ActionType;
import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class Glyphs {
    //Utilis
    public static final ResourceKey<GlyphData> PLUVIAM = key("pluviam");

    //Vivifica
    public static final ResourceKey<GlyphData> PUDICITIAM = key("pudicitiam");

    //Morbus
    public static final ResourceKey<GlyphData> PARASITUS = key("parasitus");

    public static void bootstrap(BootstrapContext<GlyphData> context) {
        context.register(PLUVIAM, new GlyphData("magicfungi.glyph.pluviam", MushroomType.UTILIS, ActionType.WORLD));

        Map<EntityType<?>, EntityType<?>> pudicitiam_convert_map = new HashMap<>();
        pudicitiam_convert_map.put(EntityType.ZOGLIN, EntityType.HOGLIN);
        pudicitiam_convert_map.put(EntityType.ZOMBIE_HORSE, EntityType.HORSE);
        pudicitiam_convert_map.put(EntityType.ZOMBIFIED_PIGLIN, EntityType.PIGLIN);
        pudicitiam_convert_map.put(EntityType.ZOMBIE_VILLAGER, EntityType.VILLAGER);
        context.register(PUDICITIAM, new GlyphData("magicfungi.glyph.pudicitiam", MushroomType.VIVIFICA, ActionType.ENTITY, new GlyphExecution(new GlyphExecution.ConversionType(pudicitiam_convert_map, Holder.direct(SoundEvents.ZOMBIE_VILLAGER_CONVERTED)))));
        context.register(PARASITUS, new GlyphData("magicfungi.glyph.parasitus", MushroomType.MORBUS, ActionType.ENTITY));
    }

    private static ResourceKey<GlyphData> key(String id) {
        return ResourceKey.create(DatapackRegistry.GLYPHS, MagicFungi.createID(id));
    }
}
