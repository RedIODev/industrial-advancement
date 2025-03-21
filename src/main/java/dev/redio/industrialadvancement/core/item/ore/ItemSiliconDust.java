package dev.redio.industrialadvancement.core.item.ore;

import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.registry.RegistryBlock;
import dev.redio.industrialadvancement.core.util.AddsRecipe;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSiliconDust extends Item implements AddsRecipe, DefaultTextureName {

    public static final String NAME = "silicon_dust";

    public ItemSiliconDust() {
        setCreativeTab(RegistryCreativeTab.base_tab);
        setUnlocalizedName(NAME);
    }

    @Override
    public void registerRecipes() {
        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Item.getItemFromBlock(RegistryBlock.quartz_sand))),
        null, new ItemStack(this, 2));
    }
    
}
