package dev.redio.industrialadvancement.core.item.ore;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.industrialadvancement.core.registry.RegisterCreativeTab;
import dev.redio.industrialadvancement.core.registry.RegistryItem;
import dev.redio.industrialadvancement.core.util.Craftable;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSiliconGraphiteBlend extends Item implements Craftable, DefaultTextureName {

    public static final String NAME = "silicon_graphite_blend";

    public ItemSiliconGraphiteBlend() {
        setCreativeTab(RegisterCreativeTab.base_tab);
        setUnlocalizedName(NAME);
    }

    @Override
    public void registerRecipes() {
        GameRegistry.addShapelessRecipe(new ItemStack(this, 4), 
        RegistryItem.siliconDust, RegistryItem.siliconDust, RegistryItem.siliconDust, RegistryItem.graphiteDust);
    }
    
}
