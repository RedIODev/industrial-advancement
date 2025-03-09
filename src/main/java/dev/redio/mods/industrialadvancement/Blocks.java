package dev.redio.mods.industrialadvancement;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.mods.industrialadvancement.blocks.BlockCrudOil;
import dev.redio.mods.industrialadvancement.blocks.BlockQuartzSand;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class Blocks {
    public static BlockQuartzSand quartz_sand;
    public static Fluid crud_oil = new Fluid("crud_oil");
    public static BlockCrudOil crud_oil_block;

    public static final List<Block> blocks = new ArrayList<Block>();

    public static void registerBlocks() {
        FluidRegistry.registerFluid(crud_oil);
        blocks.add(quartz_sand = new BlockQuartzSand());
        blocks.add(crud_oil_block = new BlockCrudOil(crud_oil, Material.water));

        for (Block block : blocks) {
            GameRegistry.registerBlock(block, block.getUnlocalizedName());
        }
    }
}
