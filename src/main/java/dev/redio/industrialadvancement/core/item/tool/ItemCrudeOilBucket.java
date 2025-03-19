package dev.redio.industrialadvancement.core.item.tool;

import dev.redio.industrialadvancement.core.registry.RegisterCreativeTab;
import dev.redio.industrialadvancement.core.registry.RegistryBlock;
import dev.redio.industrialadvancement.core.registry.RegistryFluid;
import dev.redio.industrialadvancement.core.util.BucketHandler;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class ItemCrudeOilBucket extends ItemBucket implements DefaultTextureName {

    public static final String NAME = "bucket_crude_oil";

    public ItemCrudeOilBucket() {
        super(RegistryBlock.crude_oil_block);
        setContainerItem(Items.bucket);
        setCreativeTab(RegisterCreativeTab.base_tab);
        setUnlocalizedName(NAME);
        BucketHandler.getInstance().buckets.put(RegistryBlock.crude_oil_block, this);

        FluidContainerRegistry.registerFluidContainer(RegistryFluid.crude_oil, new ItemStack(this),
                new ItemStack(Items.bucket));
    }
    
}
