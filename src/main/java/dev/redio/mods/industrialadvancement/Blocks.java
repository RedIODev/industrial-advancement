package dev.redio.mods.industrialadvancement;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.mods.industrialadvancement.blocks.BlockQuartzSand;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Blocks {
    public static BlockQuartzSand quartz_sand;
    public static final List<Block> blocks = new ArrayList<Block>();

    public static void registerBlocks() {
        blocks.add(quartz_sand = new BlockQuartzSand());

        for (Block block : blocks) {
            GameRegistry.registerBlock(block, block.getUnlocalizedName());
        }
    }
}
