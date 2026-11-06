package me.luligabi.magicfungi.recipe.glyph;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class GlyphRecipeSerializer implements RecipeSerializer<GlyphRecipe> {
    @Override
    public MapCodec<GlyphRecipe> codec() {
        return null;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, GlyphRecipe> streamCodec() {
        return null;
    }
}
