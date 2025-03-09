package dev.redio.mods.industrialadvancement;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.mods.industrialadvancement.blocks.BlockCrudOil;
import dev.redio.mods.industrialadvancement.blocks.BlockQuartzSand;
import dev.redio.mods.industrialadvancement.items.ItemCrudOilBucket;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class Items {
    public static final List<Item> items = new ArrayList<Item>();
    public static ItemCrudOilBucket crud_oil_bucket;

    public static void registerItems() {
        items.add(crud_oil_bucket = new ItemCrudOilBucket(Blocks.crud_oil_block));
        BucketHandler.INSTANCE.buckets.put(Blocks.crud_oil_block, crud_oil_bucket);
        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        FluidContainerRegistry.registerFluidContainer(Blocks.crud_oil, new ItemStack(crud_oil_bucket),
                new ItemStack(net.minecraft.init.Items.bucket));

        for (Item item : items) {
            GameRegistry.registerItem(item, item.getUnlocalizedName());
        }
    }
}
