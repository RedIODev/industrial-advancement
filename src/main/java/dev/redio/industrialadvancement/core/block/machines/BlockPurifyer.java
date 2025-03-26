package dev.redio.industrialadvancement.core.block.machines;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dev.redio.industrialadvancement.core.proxy.ProxyClient;
import dev.redio.industrialadvancement.core.registry.RegistryBlock;
import dev.redio.industrialadvancement.core.registry.RegistryCreativeTab;
import dev.redio.industrialadvancement.core.registry.RegistryGame;
import dev.redio.industrialadvancement.core.util.ItemUtil;
import dev.redio.industrialadvancement.core.tile.TileEntityPurifyer;
import ic2.core.IC2;
import ic2.core.IHasGui;
import ic2.core.Ic2Items;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.util.RotationHelper;

public class BlockPurifyer extends BlockContainer {

    public static final String NAME = "purifyer";

    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon front;
    @SideOnly(Side.CLIENT)
    private IIcon bottom;

    private static boolean isActiveStatic;
    private final boolean isActive;
    private static TileEntity oldTileEntity = null;

    private static final Random random = new Random();

    public BlockPurifyer(boolean active) {
        super(Material.iron);
        if (!active) {
            setCreativeTab(RegistryCreativeTab.base_tab);
        }
        if (active) {
            setLightLevel(13);
        }
        setBlockName(NAME + (active ? "_active": ""));
        isActive = active;
        this.setStepSound(soundTypeMetal);
        
    }

    class Sides {
        public static final int BOTTOM = 0;
        public static final int TOP = 1;
        public static final int BACK = 2;
        public static final int FRONT = 3;
        public static final int LEFT = 4;
        public static final int RIGHT = 5;

    }

    int[][] ROTATION = new int[][]{
        {0,1,2,3,4,5},
        {0,1, 4,5,3,2},
        {0,1,5,4,2,3},
        {2, 3, 1, 0, 4,5},
        {3,2,0,1,4,5},
        {0,1,3,2,4,5},
    };

    class Meta {
        public static final int UP = 0;
        public static final int DOWN = 1;
        public static final int NORTH= 2;
        public static final int SOUTH= 3;
        public static final int WEST= 4;
        public static final int EAST = 5;
        
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        String baseTextureName = ItemUtil.textureName(NAME);
        blockIcon = iconRegister.registerIcon(baseTextureName + "_side");
        top = iconRegister.registerIcon(baseTextureName + (isActive ? "_top_active" : "_top"));
        front = iconRegister.registerIcon(baseTextureName + (isActive ? "_front_active" : "_front"));
        bottom = iconRegister.registerIcon(baseTextureName + "_bottom");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch (ROTATION[meta%6][side]) { //+3
            case Sides.BOTTOM:
                return bottom;
            case Sides.TOP:
                return top;
                case Sides.FRONT:
                return front;
            case Sides.BACK:
            case Sides.LEFT:
            case Sides.RIGHT:
            default:
                return blockIcon;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if (player.isSneaking()) {
         return false;
      } else {

         TileEntity te = world.getTileEntity(x, y, z);

         return te instanceof IHasGui && (!IC2.platform.isSimulating() || 
         IC2.platform.launchGui(player, (IHasGui)te));
      }
    }
    
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return Ic2Items.machine.getItem();
    }



    @Override
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        // TODO MAYBE CHANGE DEPENDING ON BEHAIVIOR
        return super.getItem(p_149694_1_, p_149694_2_, p_149694_3_, p_149694_4_);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        if (world.isRemote) return;
        direction(world, x, y, z);
    }

    

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        if (oldTileEntity != null) {
            return oldTileEntity;
        }
        return new TileEntityPurifyer();
    }

    private void direction(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            byte b0 = 3;//3

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;//3
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;//2
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;//5
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;//4
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLivingBase entity, ItemStack stack) {
        int direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        
        switch (direction) {
            case 0:
                world.setBlockMetadataWithNotify(x, y, z, 5, 2);    //2
                break;
                case 1:
                world.setBlockMetadataWithNotify(x, y, z, 2, 2); //5
                break;
                case 2:
                world.setBlockMetadataWithNotify(x, y, z, 0, 2);    //3
                break;
                case 3:
                world.setBlockMetadataWithNotify(x, y, z, 1, 2);    //4
                break;
        }

        if (stack.hasDisplayName()) {
            ((TileEntityPurifyer)world.getTileEntity(x, y, z)).setInventoryName(stack.getDisplayName());
        }
    }

    public static void updateBlockState(boolean active, World world, int x, int y, int z) {
         int direction = world.getBlockMetadata(x, y, z);
        TileEntity entity = world.getTileEntity(x, y, z);
         isActiveStatic = true;
         oldTileEntity = entity;
         Block newBlock = active ? RegistryBlock.purifyerActive: RegistryBlock.purifyer;
         world.setBlock(x, y, z, newBlock, direction, 2);
         isActiveStatic = false;
         world.setBlockMetadataWithNotify(x, y, z, direction, 2);
         
         if (entity != null) {
             entity.validate();
             world.setTileEntity(x, y, z, entity);
            }
        oldTileEntity = null;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
        if (isActiveStatic) {
            //super.breakBlock(world, x, y, z, block, meta);
            return;
        } 
        TileEntityPurifyer tilePurifyer = (TileEntityPurifyer)world.getTileEntity(x, y, z);
        if (tilePurifyer == null) return;
        for (int i = 0; i < tilePurifyer.getSizeInventory(); i++) {
            ItemStack stack = tilePurifyer.getStackInSlot(i);
            if (stack == null) continue;
            float speedX = random.nextFloat() * 0.6F + 0.1F;
            float speedY = random.nextFloat() * 0.6F + 0.1F;
            float speedZ = random.nextFloat() * 0.6F + 0.1F;

            while (stack.stackSize > 0) {
                int itemsDropped = random.nextInt(21) + 10;
                if (itemsDropped > stack.stackSize) 
                    itemsDropped = stack.stackSize;
                stack.stackSize -= itemsDropped;
                EntityItem item = new EntityItem(world, x+speedX, y+speedY, z+speedZ,
                    new ItemStack(stack.getItem(), itemsDropped, stack.getItemDamage()));
                
                if (stack.hasTagCompound())
                    item.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());

                item.motionX = random.nextGaussian()* 0.025F;
                item.motionY = random.nextGaussian()* 0.125F;
                item.motionZ = random.nextGaussian()* 0.025F;
                world.spawnEntityInWorld(item);
            }
        }
        world.func_147453_f(x, y, z, block);
        super.breakBlock(world, x, y, z, block, meta);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (!isActive) return;
        int direction = world.getBlockMetadata(x, y, z);
        float motionX = x + 0.5F;
        float motionX2 = random.nextFloat() * 0.3F /16.0F;
        float motionY = y + random.nextFloat() * 6.0F /16.0F;
        float motionZ = z + 0.5F;
        float motionZ2 = random.nextFloat() * 0.3F /16.0F;

        switch (direction) {
            case 2:
            case 3:
            case 4:
            case 5:
                world.spawnParticle("smoke", motionX-motionZ2, motionY, motionZ + motionX2, 0, 0, 0);
                break;
        }

        if (direction == 4) {
            world.spawnParticle("smoke", motionX-motionZ2, motionY, motionZ + motionX2, 0, 0, 0);
        }
    }

    
}
