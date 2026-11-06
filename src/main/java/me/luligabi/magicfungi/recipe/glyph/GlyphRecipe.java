package me.luligabi.magicfungi.recipe.glyph;

import me.luligabi.magicfungi.screenhandler.SimpleCraftingInventory;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class GlyphRecipe implements Recipe<SimpleCraftingInventory> {
    private final Ingredient inputA;
    private final Ingredient inputB;
    private final Ingredient inputC;
    private final Ingredient inputD;
    private final ItemStack outputStack;
    private final Identifier identifier;
    private final NonNullList<Ingredient> inputs;

    public GlyphRecipe(Ingredient inputA, Ingredient inputB, Ingredient inputC, Ingredient inputD, ItemStack outputStack, Identifier identifier) {
        this.inputA = inputA;
        this.inputB = inputB;
        this.inputC = inputC;
        this.inputD = inputD;
        this.outputStack = outputStack;
        this.identifier = identifier;
        this.inputs = NonNullList.of(Ingredient.of(), inputA, inputB, inputC, inputD);
    }

    public Ingredient getInputA() {
        return inputA;
    }

    public Ingredient getInputB() {
        return inputB;
    }

    public Ingredient getInputC() {
        return inputC;
    }

    public Ingredient getInputD() {
        return inputD;
    }

    public NonNullList<Ingredient> getInputs() {
        return inputs;
    }

    @Override
    public boolean matches(SimpleCraftingInventory inventory, Level level) {
        if (inventory.size() < 5) return false;
        return inputA.test(inventory.getItem(0)) &&
                inputB.test(inventory.getItem(1)) &&
                inputC.test(inventory.getItem(2)) &&
                inputD.test(inventory.getItem(3));
    }

    @Override
    public ItemStack assemble(SimpleCraftingInventory itemStacks, HolderLookup.Provider provider) {
        return outputStack.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<SimpleCraftingInventory>> getSerializer() {
        return null;
    }

    public static class Type implements RecipeType<GlyphRecipe> {
        private Type() {}
        public static final GlyphRecipe.Type INSTANCE = new GlyphRecipe.Type();

        public static final String ID = "glyph_carving";
    }

    @Override
    public RecipeType<? extends Recipe<SimpleCraftingInventory>> getType() {
        return Type.INSTANCE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public PlacementInfo placementInfo() {
        return null;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }
}
