package dev.redio.industrialadvancement.core.item.ore;

import java.util.List;

import dev.redio.industrialadvancement.core.registry.RegisterCreativeTab;
import dev.redio.industrialadvancement.core.registry.RegistryItem;
import dev.redio.industrialadvancement.core.util.Craftable;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSiliconIngot extends Item implements Craftable, DefaultTextureName {
    public static final String NAME = "silicon_ingot";

    public ItemSiliconIngot() {
        setCreativeTab(RegisterCreativeTab.base_tab);
        setUnlocalizedName(NAME);
        setMaxDamage(100);
        setMaxStackSize(1);
    }

    @Override
    public void registerRecipes() {
        ItemStack result = new ItemStack(this);
        setDamage(result, getMaxDamage());
        Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(RegistryItem.silicon)),
        null, result);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerHolding, List lineStrings, boolean p_77624_4_) {
        lineStrings.add("Tier: " + getTier(stack));
    }

    public int getTier(ItemStack stack) {
        return (int)((getMaxDamage() -stack.getItemDamage())/25);
    }
    
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List itemList) {
        itemList.add(new ItemStack(this, 1, getMaxDamage()));
        itemList.add(new ItemStack(this, 1));
    }
}
