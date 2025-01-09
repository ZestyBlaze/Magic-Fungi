package me.luligabi.magicfungi.data.provider;

import me.luligabi.magicfungi.MagicFungi;
import me.luligabi.magicfungi.data.Glyphs;
import me.luligabi.magicfungi.registry.DatapackRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class MagicFungiDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(DatapackRegistry.GLYPHS, Glyphs::bootstrap);

    public MagicFungiDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MagicFungi.MODID));
    }
}
