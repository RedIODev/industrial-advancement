package dev.redio.mods.industrialadvancement.items;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class ItemCrudOilBucket extends ItemBucket {

    public ItemCrudOilBucket(Block arg0) {
        super(arg0);
        setContainerItem(Items.bucket);
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("crud_oil_bucket");
    }
    
}
