package me.luligabi.magicfungi.data.provider;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.HashSet;
import java.util.Set;

public class EnUsProvider extends LanguageProvider {
    public EnUsProvider(PackOutput output) {
        super(output, MagicFungi.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        Set<DeferredHolder<Block, ? extends Block>> registrar = new HashSet<>(BlockRegistry.BLOCKS.getEntries());

        registrar.forEach(blockDeferredHolder -> {
            String name = blockDeferredHolder.get().getDescriptionId().replaceFirst("block\\.magicfungi\\.", "");
            name = toTitleCase(name, "_");
            add(blockDeferredHolder.get().getDescriptionId(), name);
        });

        add("itemGroup.magicfungi", "Magic Fungi");
        add("magicfungi.glyph", "%s Glyph");
        add("magicfungi.glyph.type", "Type: %s");
        add("magicfungi.glyph.action_type", "Action Type: %s");
        add("magicfungi.glyph.pluviam", "Pluviam");
        add("magicfungi.glyph.pudicitiam", "Pudicitiam");
        add("magicfungi.glyph.parasitus", "Parasitus");
        add("magicfungi.tooltip.hold_shift", "Hold Shift to View Glyph Stats");
        add("magicfungi.tooltip.no_execution", "This Glyph has no Spell Execution Written for it");
    }

    private String toTitleCase(String givenString, String regex) {
        String[] stringArray = givenString.split(regex);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            stringBuilder.append(Character.toUpperCase(string.charAt(0))).append(string.substring(1)).append(regex);
        }
        return stringBuilder.toString().trim().replaceAll(regex, " ").substring(0, stringBuilder.length() - 1);
    }
}
