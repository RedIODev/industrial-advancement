package dev.redio.industrialadvancement.core.tile;

import java.util.List;

import dev.redio.industrialadvancement.core.registry.RegistryRecipe;
import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.RecipeOutput;
import ic2.api.tile.IRecipeMachine;
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
        return "dev.redio.industrialadvancement.core.gui.GuiPurifyer";
    
    }

    @Override
    public String getInventoryName() {
        return renamedTitle == null ? "Purifyer" : renamedTitle;
    }

    @Override
    public IMachineRecipeManager getRecipeList() {
        return RegistryRecipe.purifier;    
    }

    @Override
    public RecipeOutput getResultFor(ItemStack arg0, boolean arg1) {
        return RegistryRecipe.purifier.getOutputFor(arg0, arg1);    
    }

    public void setInventoryName(String displayName) {
        renamedTitle = displayName;
    }


   
    
}
