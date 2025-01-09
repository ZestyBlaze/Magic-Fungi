package me.luligabi.magicfungi.util;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ConversionParams;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

@SuppressWarnings("unchecked")
public class SpellExecutionUtil {
    public static boolean executeEntityConversion(LivingEntity usedOn, EntityType<?> target, EntityType<?> result, Holder<SoundEvent> soundEvent) {
        if (!usedOn.getType().equals(target)) return false;
        ((Mob)usedOn).convertTo((EntityType<Mob>) result, ConversionParams.single((Mob) usedOn, true, true), (mob) -> {});
        usedOn.discard();
        usedOn.playSound(soundEvent.value());
        return true;
    }
}
