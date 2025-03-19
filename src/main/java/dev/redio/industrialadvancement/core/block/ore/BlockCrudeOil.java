package dev.redio.industrialadvancement.core.block.ore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dev.redio.industrialadvancement.core.registry.RegistryFluid;
import dev.redio.industrialadvancement.core.registry.RegistryGame;
import dev.redio.industrialadvancement.core.util.ItemUtil;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockCrudeOil extends BlockFluidClassic {

    public static final String NAME = "crude_oil";

    @SideOnly(Side.CLIENT)
    private IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    private IIcon flowingIcon;

    public BlockCrudeOil() {
        super(RegistryFluid.crude_oil, Material.water);
        setBlockName(NAME);
        
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon: flowingIcon;
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        String textureName = ItemUtil.textureName(NAME);
        stillIcon = register.registerIcon(textureName + "_still");
        flowingIcon = register.registerIcon(textureName + "_flow");
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
