package dev.redio.mods.industrialadvancement.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dev.redio.mods.industrialadvancement.IndustrialAdvancement;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockCrudOil extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    private IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    private IIcon flowingIcon;

    public BlockCrudOil(Fluid fluid, Material material) {
        super(fluid, material);
        // setCreativeTab(CreativeTabs.tabMisc);
        setBlockName("crud_oil_source");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon: flowingIcon;
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(IndustrialAdvancement.MODID + ":crud_oil_still");
        flowingIcon = register.registerIcon(IndustrialAdvancement.MODID + ":crud_oil_flowing");
    }

    @Override
        public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
                if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
                return super.canDisplace(world, x, y, z);
        }
       
        @Override
        public boolean displaceIfPossible(World world, int x, int y, int z) {
                if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
                return super.displaceIfPossible(world, x, y, z);
        }
    
}
