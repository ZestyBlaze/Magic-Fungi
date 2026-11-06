package me.luligabi.magicfungi.item.glyph.morbus;

import me.luligabi.magicfungi.item.glyph.AbstractGlyphItem;
import me.luligabi.magicfungi.util.ActionType;
import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CorrumpereGlyphItem extends AbstractGlyphItem {
    public CorrumpereGlyphItem(Properties properties) {
        super(properties);
    }

    @Override
    public MushroomType getMushroomType() {
        return MushroomType.MORBUS;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ZOMBIE_VILLAGER_CONVERTED;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ENTITY;
    }

    @Override
    public void executeBlockGlyph(Player player, ItemStack itemStack) {}

    @Override
    public void executeEntityGlyph(Player player, ItemStack itemStack, LivingEntity interactionTarget) {

    }
}
