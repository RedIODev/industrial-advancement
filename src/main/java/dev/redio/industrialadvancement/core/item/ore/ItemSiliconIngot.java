package dev.redio.industrialadvancement.core.item.ore;

import java.util.List;

import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.registry.RegistryItem;
import dev.redio.industrialadvancement.core.registry.RegistryRecipe;
import dev.redio.industrialadvancement.core.util.AddsRecipe;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import dev.redio.industrialadvancement.core.util.TierItem;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import ic2.core.BasicMachineRecipeManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSiliconIngot extends Item implements AddsRecipe, DefaultTextureName, TierItem {
    public static final String NAME = "silicon_ingot";
    public static final int MAX_TIER = 4;

    public ItemSiliconIngot() {
        setCreativeTab(RegistryCreativeTab.base_tab);
        setUnlocalizedName(NAME);
        setHasSubtypes(true);
        setMaxStackSize(16);
    }

    @Override
    public void registerRecipes() {
        ItemStack result = new ItemStack(this);
        setDamage(result, getMaxDamage());
        Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(RegistryItem.silicon)),
        null, result);

        for (int i = 0; i < MAX_TIER; i++) {
            RegistryRecipe.purifier.putIfAbsent(i, new BasicMachineRecipeManager());
            IMachineRecipeManager manager = RegistryRecipe.purifier.get(i);
            for (int j = 0; j <= i; j++) {
                manager.addRecipe(new RecipeInputItemStack(new ItemStack(this, 1, j)), null, new ItemStack(this, 1, i+1));
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerHolding, List lineStrings, boolean p_77624_4_) {
        addTierInformation(stack, lineStrings);
    }

    @Override
    public int getTier(ItemStack stack) {
        return stack.getItemDamage();
    }

    @Override
    public void setTier(ItemStack stack, int tier) {
        stack.setItemDamage(tier);
    }

    @Override
    public int getMaxTier() {
        return MAX_TIER;
    }
    
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List itemList) {
        for (int i = 0; i < MAX_TIER+1; i++) {
            itemList.add(new ItemStack(this, 1, i));
        }
    }

    

   
}
