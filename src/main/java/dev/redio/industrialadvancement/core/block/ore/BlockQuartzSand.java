package dev.redio.industrialadvancement.core.block.ore;

import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import dev.redio.industrialadvancement.core.util.EasyMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityFallingBlock;

public class BlockQuartzSand extends BlockFalling implements DefaultTextureName {

    public static final String NAME = "quartz_sand";
    public static final float HARDNESS = 0.7F;
    public static final String TOOL = "shovel";
    public static final int MINING_LEVEL = 2;
    public static final Material MATERIAL = new EasyMaterial(MapColor.sandColor).setRequiresTool();

    public BlockQuartzSand() {
        super(MATERIAL);
        this.setBlockName(NAME);
        setCreativeTab(RegistryCreativeTab.base_tab);
        this.setHardness(HARDNESS);
        this.setHarvestLevel(TOOL, MINING_LEVEL);
        this.setStepSound(Block.soundTypeSand);
    }

    //set block entity drop to false
    protected void func_149829_a(EntityFallingBlock fallingBlock) {
        fallingBlock.field_145813_c = false;
    }
}
