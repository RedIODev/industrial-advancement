package dev.redio.industrialadvancement.core.block.ore;

import java.util.Random;

import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockDrenchedStone extends Block implements DefaultTextureName {

    public static final String NAME = "drenched_stone";
    private static final float HARDNESS = 1.0F;
    private static final float RESISTANCE = 9.0F;
    private static final String TOOL = "pickaxe";
    private static final int MINING_LEVEL = 2;

    public BlockDrenchedStone() {
        super(Material.rock);
        setCreativeTab(RegistryCreativeTab.base_tab);
        setBlockName(NAME);
        setHardness(HARDNESS);
        setStepSound(Block.soundTypePiston);
        setResistance(RESISTANCE);
        setHarvestLevel(TOOL, MINING_LEVEL);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return null;
    }
    
}
