package me.luligabi.magicfungi.glyph;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

public record GlyphCost(Optional<Float> exhaustion, Optional<ItemStack> stack, Optional<Holder<MobEffect>> mobEffect, int cooldown) {
    public static final Codec<GlyphCost> CODEC = RecordCodecBuilder.create(func -> func.group(
            Codec.FLOAT.optionalFieldOf("exhaustion").forGetter(GlyphCost::exhaustion),
            ItemStack.CODEC.optionalFieldOf("item").forGetter(GlyphCost::stack),
            MobEffect.CODEC.optionalFieldOf("mob_effect").forGetter(GlyphCost::mobEffect),
            ExtraCodecs.POSITIVE_INT.optionalFieldOf("cooldown", 0).forGetter(GlyphCost::cooldown)
    ).apply(func, GlyphCost::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, GlyphCost> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.FLOAT.apply(ByteBufCodecs::optional), GlyphCost::exhaustion,
            ItemStack.STREAM_CODEC.apply(ByteBufCodecs::optional), GlyphCost::stack,
            MobEffect.STREAM_CODEC.apply(ByteBufCodecs::optional), GlyphCost::mobEffect,
            ByteBufCodecs.INT, GlyphCost::cooldown,
            GlyphCost::new
    );
}
