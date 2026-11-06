package me.luligabi.magicfungi.util;

import net.minecraft.network.chat.Component;

public enum ActionType {
    BLOCK(Component.translatable("actionType.magicfungi.block")),
    ENTITY(Component.translatable("actionType.magicfungi.entity")),
    PLAYER(Component.translatable("actionType.magicfungi.player")),
    WORLD(Component.translatable("actionType.magicfungi.world")),
    UNKNOWN(Component.translatable("actionType.magicfungi.unknown"));

    private final Component translatableText;

    ActionType(Component translatableText) {
        this.translatableText = translatableText;
    }

    public Component getTranslatableText() {
        return translatableText;
    }
}
