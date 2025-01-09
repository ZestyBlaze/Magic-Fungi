package me.luligabi.magicfungi.data;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.data.provider.EnUsProvider;
import me.luligabi.magicfungi.data.provider.MFModelProvider;
import me.luligabi.magicfungi.data.provider.MagicFungiDatapackProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = MagicFungi.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MagicFungiDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> providers = event.getLookupProvider();

        event.addProvider(new EnUsProvider(output));
        event.addProvider(new MFModelProvider(output));
        event.addProvider(new MagicFungiDatapackProvider(output, providers));
    }
}
