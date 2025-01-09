package me.luligabi.magicfungi.client.property;

import com.mojang.serialization.MapCodec;
import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.registry.ComponentRegistry;
import me.luligabi.magicfungi.util.MushroomType;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class MushroomTypeProperty implements SelectItemModelProperty<MushroomType> {
    public static final ResourceLocation MUSHROOM = MagicFungi.createID("mushroom_type");
    public static final MapCodec<MushroomTypeProperty> CODEC = MapCodec.unit(new MushroomTypeProperty());
    public static final Type<MushroomTypeProperty, MushroomType> TYPE = SelectItemModelProperty.Type.create(CODEC, MushroomType.CODEC);

    @Override
    public MushroomType get(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i, ItemDisplayContext itemDisplayContext) {
        return itemStack.get(ComponentRegistry.GLYPH_DATA).mushroom();
    }

    @Override
    public Type<? extends SelectItemModelProperty<MushroomType>, MushroomType> type() {
        return TYPE;
    }
}
