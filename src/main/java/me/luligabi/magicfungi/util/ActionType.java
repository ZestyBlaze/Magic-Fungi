package me.luligabi.magicfungi.util;

import com.mojang.serialization.Codec;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.StringRepresentable;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public enum ActionType implements StringRepresentable {
    BLOCK,
    ENTITY,
    WORLD;

    public static final Codec<ActionType> CODEC = StringRepresentable.fromValues(ActionType::values);
    public static final StreamCodec<FriendlyByteBuf, ActionType> STREAM_CODEC = NeoForgeStreamCodecs.enumCodec(ActionType.class);

    @Override
    public String getSerializedName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public String getCapitalizedName() {
        return StringUtils.capitalize(getSerializedName());
    }
}
