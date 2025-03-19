package dev.redio.industrialadvancement.core.util;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EasyCreativeTab extends CreativeTabs {
    private final String iconModId;
    private final String iconItemName;

    public EasyCreativeTab(int tabId, String name, String iconModId, String iconItemName) {
            super(tabId, name);
            this.iconItemName = iconItemName;
            this.iconModId = iconModId;
        }

    public EasyCreativeTab(String name, String modId, String iconItemName) {
        super(name);
        this.iconItemName = iconItemName;
        this.iconModId = modId;
    }
    
    @Override
    public Item getTabIconItem() {
        Item result = GameRegistry.findItem(iconModId, "item." + iconItemName);
        if (result == null) { //Fallback
            result = Items.apple;
        }
        return new ItemStack(result).getItem();
    }
}
