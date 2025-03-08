package dev.redio.mods.industrialadvancement.blocks;

import dev.redio.mods.industrialadvancement.IndustrialAdvancement;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockSilicon extends BlockFalling {

    private static class MaterialSilicon extends Material {
        public MaterialSilicon() {
            super(MapColor.sandColor);
            setRequiresTool();
        }
    }

    public BlockSilicon() {
        super(new MaterialSilicon());
        this.setBlockName("silicon");
        this.setBlockTextureName(IndustrialAdvancement.MODID + ":silicon");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(0.7F);
        this.setHarvestLevel("shovel",2);
        this.setStepSound(Block.soundTypeSand);
    }

    //set block entity drop to false
    protected void func_149829_a(EntityFallingBlock fallingBlock) {
        fallingBlock.field_145813_c = false;
    }
}
