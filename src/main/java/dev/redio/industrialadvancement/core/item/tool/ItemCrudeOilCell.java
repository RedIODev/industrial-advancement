package dev.redio.industrialadvancement.core.item.tool;

import dev.redio.industrialadvancement.core.registry.RegistryBlock;
import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.registry.RegistryFluid;
import dev.redio.industrialadvancement.core.registry.RegistryItem;
import dev.redio.industrialadvancement.core.util.BucketHandler;
import dev.redio.industrialadvancement.core.util.AddsRecipe;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.Ic2Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class ItemCrudeOilCell extends Item implements AddsRecipe, DefaultTextureName {

    public static final String NAME = "crude_oil_cell";

    public ItemCrudeOilCell() {
        setContainerItem(Ic2Items.cell.getItem());
        setCreativeTab(RegistryCreativeTab.base_tab);
        setUnlocalizedName(NAME);
        setMaxStackSize(16);
    }

    @Override
    public void registerRecipes() {
        Recipes.extractor.addRecipe(new RecipeInputItemStack(new ItemStack(RegistryItem.rockyOilCell)),
        null, new ItemStack(this), Ic2Items.scrap);
    }
    
}
