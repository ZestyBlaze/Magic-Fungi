package me.luligabi.magicfungi.screenhandler;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class SimpleCraftingInventory implements Container, RecipeInput {
    NonNullList<ItemStack> stacks;
    AbstractContainerMenu screenHandler;

    public SimpleCraftingInventory(AbstractContainerMenu screenHandler, int size) {
        this.screenHandler = screenHandler;
        stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    }

    @Override
    public int getContainerSize() {
        return this.stacks.size();
    }

    @Override
    public boolean isEmpty() {
        return this.stacks.isEmpty();
    }

    @Override
    public ItemStack getItem(int i) {
        return this.stacks.get(i);
    }

    @Override
    public ItemStack removeItem(int i, int i1) {
        ItemStack itemStack = ContainerHelper.removeItem(this.stacks, i, i1);

        if (!itemStack.isEmpty()) {
            this.screenHandler.slotsChanged(this);
        }

        return itemStack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        return ContainerHelper.takeItem(this.stacks, i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        this.stacks.set(i, itemStack);
        this.screenHandler.slotsChanged(this);
    }

    @Override
    public void setChanged() {
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public int size() {
        return this.stacks.size();
    }

    @Override
    public void clearContent() {
        this.stacks.clear();
    }
}
