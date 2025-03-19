package dev.redio.industrialadvancement.core.item.ore;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.industrialadvancement.core.registry.RegisterCreativeTab;
import dev.redio.industrialadvancement.core.util.Craftable;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import ic2.core.Ic2Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGraphiteDust extends Item implements Craftable, DefaultTextureName {

    public static final String NAME = "graphite_dust";

    public ItemGraphiteDust() {
        setCreativeTab(RegisterCreativeTab.base_tab);
        setUnlocalizedName(NAME);
    }

    @Override
    public void registerRecipes() {
        GameRegistry.addSmelting(new ItemStack(Ic2Items.coalDust.getItem(), 4), new ItemStack(this), 0.2F);
    }
    
}
