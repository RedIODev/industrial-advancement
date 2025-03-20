package dev.redio.industrialadvancement.core.item;

import dev.redio.industrialadvancement.core.registry.RegistryBlock;
import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.util.AddsRecipe;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import ic2.core.Ic2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemRockyOilCell extends Item implements AddsRecipe, DefaultTextureName {

    public static final String NAME = "rocky_oil_cell";

    public ItemRockyOilCell() {
        setCreativeTab(RegistryCreativeTab.base_tab);
        setUnlocalizedName(NAME);
        setMaxStackSize(16);
    }

    @Override
    public void registerRecipes() {
        //Recipes..addRecipe(new RecipeInputItemStack(new ItemStack(RegistryBlock.drenchedStone)), new RecipeInputItemStack(Ic2Items.cell), new ItemStack(this));
    }
    
}
