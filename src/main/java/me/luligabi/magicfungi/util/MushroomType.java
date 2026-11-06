package me.luligabi.magicfungi.util;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;

public enum MushroomType implements StringRepresentable {
    IMPETUS(Component.translatable("mushroomType.magicfungi.impetus"), Component.translatable("mushroomType.magicfungi.impetus.stats"), "impetus"),
    CLYPEUS(Component.translatable("mushroomType.magicfungi.clypeus"), Component.translatable("mushroomType.magicfungi.clypeus.stats"), "clypeus"),
    UTILIS(Component.translatable("mushroomType.magicfungi.utilis"), Component.translatable("mushroomType.magicfungi.utilis.stats"), "utilis"),
    VIVIFICA(Component.translatable("mushroomType.magicfungi.vivifica"), Component.translatable("mushroomType.magicfungi.vivifica.stats"), "vivifica"),
    MORBUS(Component.translatable("mushroomType.magicfungi.morbus"), Component.translatable("mushroomType.magicfungi.morbus.stats"), "morbus"),

    // Unknown
    INCOGNITA(Component.translatable("mushroomType.magicfungi.incognita"), Component.translatable("mushroomType.magicfungi.incognita.stats"), "incognita");

    private final Component fancyName;
    private final Component statsName;
    private final String id;

    MushroomType(Component fancyName, Component statsName, String id) {
        this.fancyName = fancyName;
        this.statsName = statsName;
        this.id = id;
    }

    public Component getFancyName() {
        return fancyName;
    }

    public Component getStatsName() {
        return statsName;
    }

    public String getId() {
        return id;
    }

    public static ChatFormatting getLightColor(MushroomType mushroomType) {
        return switch (mushroomType) {
            case IMPETUS -> ChatFormatting.RED;
            case CLYPEUS -> ChatFormatting.AQUA;
            case UTILIS -> ChatFormatting.LIGHT_PURPLE;
            case VIVIFICA -> ChatFormatting.GREEN;
            case MORBUS -> ChatFormatting.GRAY;
            default -> ChatFormatting.WHITE;
        };
    }

    public static ChatFormatting getDarkColor(MushroomType mushroomType) {
        return switch (mushroomType) {
            case IMPETUS -> ChatFormatting.DARK_RED;
            case CLYPEUS -> ChatFormatting.DARK_AQUA;
            case UTILIS -> ChatFormatting.DARK_PURPLE;
            case VIVIFICA -> ChatFormatting.DARK_GREEN;
            case MORBUS -> ChatFormatting.DARK_GRAY;
            default -> ChatFormatting.WHITE;
        };
    }

    @Override
    public String getSerializedName() {
        return getId();
    }
}
