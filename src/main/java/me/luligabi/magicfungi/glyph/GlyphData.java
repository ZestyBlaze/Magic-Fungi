package me.luligabi.magicfungi.glyph;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.luligabi.magicfungi.util.ActionType;
import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Rarity;

import java.util.Optional;

public record GlyphData(String id, MushroomType mushroom, ActionType action, Rarity rarity, Optional<GlyphExecution> execution, Optional<GlyphCost> cost) {
    public static final Codec<GlyphData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("name").forGetter(GlyphData::id),
            MushroomType.CODEC.fieldOf("mushroom").forGetter(GlyphData::mushroom),
            ActionType.CODEC.fieldOf("action").forGetter(GlyphData::action),
            Rarity.CODEC.optionalFieldOf("rarity", Rarity.COMMON).forGetter(GlyphData::rarity),
            GlyphExecution.CODEC.optionalFieldOf("execute").forGetter(GlyphData::execution),
            GlyphCost.CODEC.optionalFieldOf("cost").forGetter(GlyphData::cost)
    ).apply(instance, GlyphData::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, GlyphData> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, GlyphData::id,
            MushroomType.STREAM_CODEC, GlyphData::mushroom,
            ActionType.STREAM_CODEC, GlyphData::action,
            Rarity.STREAM_CODEC, GlyphData::rarity,
            GlyphExecution.STREAM_CODEC.apply(ByteBufCodecs::optional), GlyphData::execution,
            GlyphCost.STREAM_CODEC.apply(ByteBufCodecs::optional), GlyphData::cost,
            GlyphData::new
    );

    public GlyphData(String id, MushroomType mushroom, ActionType action, GlyphExecution execution) {
        this(id, mushroom, action, Rarity.COMMON, Optional.of(execution), Optional.empty());
    }

    public GlyphData(String id, MushroomType mushroom, ActionType action) {
        this(id, mushroom, action, Rarity.COMMON, Optional.empty(), Optional.empty());
    }
}
