package me.luligabi.magicfungi.glyph;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import java.util.Map;
import java.util.Optional;

public record GlyphExecution(Optional<ConversionTag> conversionTag, Optional<ConversionType> conversionType) {
    public static final Codec<GlyphExecution> CODEC = RecordCodecBuilder.create(func -> func.group(
            ConversionTag.CODEC.optionalFieldOf("entity_tag_conversion").forGetter(GlyphExecution::conversionTag),
            ConversionType.CODEC.optionalFieldOf("entity_type_conversion").forGetter(GlyphExecution::conversionType)
    ).apply(func, GlyphExecution::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, GlyphExecution> STREAM_CODEC = StreamCodec.composite(
            ConversionTag.STREAM_CODEC.apply(ByteBufCodecs::optional), GlyphExecution::conversionTag,
            ConversionType.STREAM_CODEC.apply(ByteBufCodecs::optional), GlyphExecution::conversionType,
            GlyphExecution::new
    );

    public GlyphExecution(ConversionTag conversionTag) {
        this(Optional.of(conversionTag), Optional.empty());
    }

    public GlyphExecution(ConversionType conversion) {
        this(Optional.empty(), Optional.of(conversion));
    }

    public record ConversionTag(Map<TagKey<EntityType<?>>, EntityType<?>> conversionMap, Holder<SoundEvent> soundEvent) {
        public static final Codec<ConversionTag> CODEC = RecordCodecBuilder.create(func -> func.group(
                Codec.unboundedMap(TagKey.codec(Registries.ENTITY_TYPE), BuiltInRegistries.ENTITY_TYPE.byNameCodec()).fieldOf("conversions").forGetter(ConversionTag::conversionMap),
                SoundEvent.CODEC.optionalFieldOf("sound", Holder.direct(SoundEvents.ZOMBIE_VILLAGER_CONVERTED)).forGetter(ConversionTag::soundEvent)
        ).apply(func, ConversionTag::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ConversionTag> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.map(Object2ObjectOpenHashMap::new, TagKey.streamCodec(Registries.ENTITY_TYPE), ByteBufCodecs.registry(Registries.ENTITY_TYPE)), ConversionTag::conversionMap,
                SoundEvent.STREAM_CODEC, ConversionTag::soundEvent,
                ConversionTag::new
        );
    }

    public record ConversionType(Map<EntityType<?>, EntityType<?>> conversionMap, Holder<SoundEvent> soundEvent) {
        public static final Codec<ConversionType> CODEC = RecordCodecBuilder.create(func -> func.group(
                Codec.unboundedMap(BuiltInRegistries.ENTITY_TYPE.byNameCodec(), BuiltInRegistries.ENTITY_TYPE.byNameCodec()).fieldOf("conversions").forGetter(ConversionType::conversionMap),
                SoundEvent.CODEC.optionalFieldOf("sound", Holder.direct(SoundEvents.ZOMBIE_VILLAGER_CONVERTED)).forGetter(ConversionType::soundEvent)
        ).apply(func, ConversionType::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ConversionType> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.map(Object2ObjectOpenHashMap::new, ByteBufCodecs.registry(Registries.ENTITY_TYPE), ByteBufCodecs.registry(Registries.ENTITY_TYPE)), ConversionType::conversionMap,
                SoundEvent.STREAM_CODEC, ConversionType::soundEvent,
                ConversionType::new
        );
    }
}
