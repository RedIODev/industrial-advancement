package dev.redio.industrialadvancement.core.util;

import java.util.List;

import dev.redio.industrialadvancement.core.registry.RegistryGame;
import net.minecraft.item.ItemStack;

public class ItemUtil {
    public static String textureName(String name) {
        return RegistryGame.MODID + ":" + name;
    }

    public static boolean containsItemStack(List<ItemStack> list, ItemStack stack) {
        for (ItemStack listStack: list) {
            if (ItemStack.areItemStacksEqual(listStack, stack)) {
                return true;
            }
         }
         return false;
    }
}
