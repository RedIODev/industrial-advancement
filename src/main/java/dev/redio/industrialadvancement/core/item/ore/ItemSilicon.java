package dev.redio.industrialadvancement.core.item.ore;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.registry.RegistryItem;
import dev.redio.industrialadvancement.core.util.AddsRecipe;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSilicon extends Item implements AddsRecipe, DefaultTextureName {

    public static final String NAME = "silicon";

    public ItemSilicon() {
        setCreativeTab(RegistryCreativeTab.base_tab);
        setUnlocalizedName(NAME);
    }

    @Override
    public void registerRecipes() {
        GameRegistry.addSmelting(RegistryItem.siliconGraphiteBlend, new ItemStack(this), 0.1F);
    }
}
