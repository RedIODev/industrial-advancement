package dev.redio.industrialadvancement.core.tile;

import java.util.List;

import dev.redio.industrialadvancement.core.block.machines.BlockPurifyer;
import dev.redio.industrialadvancement.core.item.ItemFilterMeshUpgrade;
import dev.redio.industrialadvancement.core.registry.RegistryRecipe;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.RecipeOutput;
import ic2.api.tile.IRecipeMachine;
import ic2.core.BasicMachineRecipeManager;
import ic2.core.block.machine.tileentity.TileEntityElectricMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPurifyer extends TileEntityElectricMachine {

    private String renamedTitle;

    public TileEntityPurifyer() {
            super(3, 32, 1000, 511);
            
        }

    
    @Override
    public String getGuiClassName(EntityPlayer arg0) {
        return "gui.GuiPurifyer";
    
    }

    public ItemStack[] getUpgradeItems() {
        return new ItemStack[] {
            inventory[inventory.length-4], 
            inventory[inventory.length-3], 
            inventory[inventory.length-2], 
            inventory[inventory.length-1]
        };
    }

    public ItemStack getHighestFilterMeshUpgrade() {
        ItemStack result = null;
        for (ItemStack stack : getUpgradeItems()) {
            if (stack == null || !(stack.getItem() instanceof ItemFilterMeshUpgrade)) continue;
            ItemFilterMeshUpgrade upgrade = (ItemFilterMeshUpgrade) stack.getItem();
            if (result == null || upgrade.getDamage(stack) > upgrade.getDamage(result)) {
                result = stack;
            }
        }
        return result;
    }

    public int getMachineTier() {
        ItemStack upgradeItem = getHighestFilterMeshUpgrade();
        return (upgradeItem == null ? 1 : upgradeItem.getItemDamage()+2);
    }

    @Override
    public float getWrenchDropRate() {
        return 0.85F;
    }

    @Override
    public String getInventoryName() {
        String tier = " Tier " + getMachineTier();
        return (renamedTitle == null ? "Purifyer" : renamedTitle) + tier;
    }

    @Override
    public void setActive(boolean active) {
        if (this.prevActive != active) {
            BlockPurifyer.updateBlockState(active, worldObj, xCoord, yCoord, zCoord);
        }
        super.setActive(active);
    }
    @Override
    public void updateEntity() {
        super.updateEntity();
        //BlockPurifyer.updateBlockState(getActive(), worldObj, xCoord, yCoord, zCoord);
        
    }

    @Override
    public IMachineRecipeManager getRecipeList() {
        RegistryRecipe.purifier.putIfAbsent(getMachineTier()-1, new BasicMachineRecipeManager());   
        return RegistryRecipe.purifier.get(getMachineTier()-1);
    }

    @Override
    public RecipeOutput getResultFor(ItemStack arg0, boolean arg1) {
        return getRecipeList().getOutputFor(arg0, arg1);  
    }

    public void setInventoryName(String displayName) {
        renamedTitle = displayName;
    }


   
    
}
