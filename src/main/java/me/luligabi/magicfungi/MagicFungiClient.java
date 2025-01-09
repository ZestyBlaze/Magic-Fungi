package me.luligabi.magicfungi;

import me.luligabi.magicfungi.client.property.MushroomTypeProperty;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterSelectItemModelPropertyEvent;

@EventBusSubscriber(modid = MagicFungi.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MagicFungiClient {
    @SubscribeEvent
    public static void registerSelectItemModels(RegisterSelectItemModelPropertyEvent event) {
        event.register(MushroomTypeProperty.MUSHROOM, MushroomTypeProperty.TYPE);
    }
}
