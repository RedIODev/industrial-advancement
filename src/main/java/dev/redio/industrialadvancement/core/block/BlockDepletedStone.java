package dev.redio.industrialadvancement.core.block;

import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.util.AddsRecipe;
import dev.redio.industrialadvancement.core.util.DefaultTextureName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDepletedStone extends Block implements DefaultTextureName, AddsRecipe {

    public static final String NAME = "depleted_stone";
    private static final float HARDNESS = 1.5F;
    private static final float RESISTANCE = 10.0F;
    private static final String TOOL = "pickaxe";
    private static final int MINING_LEVEL = 0;

    public BlockDepletedStone() {
        super(Material.rock);
        setCreativeTab(RegistryCreativeTab.base_tab);
        setBlockName(NAME);
        setHardness(HARDNESS);
        setStepSound(Block.soundTypePiston);
        setResistance(RESISTANCE);
        setHarvestLevel(TOOL, MINING_LEVEL);
    }

    @Override
    public void registerRecipes() {
        
    }
    
}
