package me.luligabi.magicfungi;

import dev.teamcitrus.citruslib.tab.TabFillingRegistry;
import me.luligabi.magicfungi.registry.BlockRegistry;
import me.luligabi.magicfungi.registry.ComponentRegistry;
import me.luligabi.magicfungi.registry.ItemRegistry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MagicFungi.MODID)
public class MagicFungi {
    public static final String MODID = "magicfungi";
    public static final Logger LOGGER = LogManager.getLogger();

    public MagicFungi(IEventBus bus, ModContainer modContainer) {
        BlockRegistry.BLOCKS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        ItemRegistry.CREATIVE_TABS.register(bus);
        ComponentRegistry.COMPONENTS.register(bus);

        bus.register(this);
    }

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            TabFillingRegistry.register(ItemRegistry.MF_TAB.getKey(), ItemRegistry.GLYPH.get());
        });
    }

    public static ResourceLocation createID(String id) {
        return ResourceLocation.fromNamespaceAndPath(MODID, id);
    }
}
