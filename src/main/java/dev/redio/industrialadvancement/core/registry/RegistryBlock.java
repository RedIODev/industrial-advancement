package dev.redio.industrialadvancement.core.registry;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.industrialadvancement.core.block.ore.BlockCrudeOil;
import dev.redio.industrialadvancement.core.block.ore.BlockQuartzSand;
import dev.redio.industrialadvancement.core.util.Craftable;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import dev.redio.industrialadvancement.core.util.ItemUtil;
import net.minecraft.block.Block;

public class RegistryBlock {
    public static BlockQuartzSand   quartz_sand;
    public static BlockCrudeOil crude_oil_block;

    public static final List<Block> blocks = new ArrayList<Block>();

    public static void registerBlocks() {
        blocks.add(quartz_sand = new BlockQuartzSand());
        blocks.add(crude_oil_block = new BlockCrudeOil());

        for (Block block : blocks) {
            if (block instanceof Craftable) ((Craftable)block).registerRecipes();
            if (block instanceof DefaultTextureName) block.setBlockTextureName(ItemUtil.textureName(block.getUnlocalizedName().replaceFirst("^tile.", "")));
            GameRegistry.registerBlock(block, block.getUnlocalizedName());
        }
    }
}
