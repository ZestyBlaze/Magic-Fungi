package me.luligabi.magicfungi.util;

import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public enum MushroomType implements StringRepresentable {
    IMPETUS(ChatFormatting.RED),
    CLYPEUS(ChatFormatting.AQUA),
    UTILIS(ChatFormatting.LIGHT_PURPLE),
    VIVIFICA(ChatFormatting.GREEN),
    MORBUS(ChatFormatting.GRAY);

    private final ChatFormatting formatting;

    MushroomType(ChatFormatting formatting) {
        this.formatting = formatting;
    }

    public static final Codec<MushroomType> CODEC = StringRepresentable.fromValues(MushroomType::values);

    public static final StreamCodec<FriendlyByteBuf, MushroomType> STREAM_CODEC = NeoForgeStreamCodecs.enumCodec(MushroomType.class);

    public ChatFormatting getFormatting() {
        return formatting;
    }

    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public String getCapitalizedName() {
        return StringUtils.capitalize(getSerializedName());
    }
}
