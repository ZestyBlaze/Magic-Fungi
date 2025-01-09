package me.luligabi.magicfungi.util;

import net.minecraft.ChatFormatting;

public class ColorUtil {
    public static ChatFormatting getPairedColor(ChatFormatting color) {
        return switch (color) {
            case BLACK -> null;
            case DARK_BLUE -> null;
            case DARK_GREEN -> null;
            case DARK_AQUA -> null;
            case DARK_RED -> null;
            case DARK_PURPLE -> null;
            case GOLD -> null;
            case GRAY -> ChatFormatting.DARK_GRAY;
            case DARK_GRAY -> null;
            case BLUE -> null;
            case GREEN -> ChatFormatting.DARK_GREEN;
            case AQUA -> ChatFormatting.BLUE;
            case RED -> ChatFormatting.DARK_RED;
            case LIGHT_PURPLE -> ChatFormatting.DARK_PURPLE;
            case YELLOW -> null;
            case WHITE -> null;
            case OBFUSCATED -> null;
            case BOLD -> null;
            case STRIKETHROUGH -> null;
            case UNDERLINE -> null;
            case ITALIC -> null;
            case RESET -> null;
        };
    }
}
