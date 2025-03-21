package dev.redio.industrialadvancement.core.util;


import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
public class BucketHandler {

    private static BucketHandler INSTANCE;
    public Map<Block, Item> buckets = new HashMap<Block, Item>();

    public static BucketHandler getInstance() {
        return (INSTANCE == null) ? (INSTANCE = new BucketHandler()) : INSTANCE; 
    }

    private BucketHandler() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {
            ItemStack result = fillCustomBucket(event.world, event.target);
            
            if (result == null)
                    return;

            event.result = result;
            event.setResult(Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {

            Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

            Item bucket = buckets.get(block);
            if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
                    world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
                    return new ItemStack(bucket);
            } else
                    return null;

    }
}
