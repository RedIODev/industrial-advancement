package dev.redio.industrialadvancement.neiIntegration;

import ic2.api.recipe.IMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeOutput;
import ic2.core.gui.GuiPurifyer;
import ic2.neiIntegration.core.MachineRecipeHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.redio.industrialadvancement.core.registry.RegistryGame;
import dev.redio.industrialadvancement.core.registry.RegistryRecipe;
import dev.redio.industrialadvancement.core.util.ItemUtil;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class PurifyerRecipeHandler extends MachineRecipeHandler {

    public PurifyerRecipeHandler() {

    }

   public List<Class<? extends GuiContainer>> getRecipeTransferRectGuis() {
      List<Class<? extends GuiContainer>> list = new ArrayList<>();
      list.add(GuiPurifyer.class);
      //list.add(GuiRotary.class);
      return list;
   }

   public String getRecipeName() {
      return "Purifyer";
   }

   public String getRecipeId() {
      return RegistryGame.MODID + ".purifyer";
   }

   public String getGuiTexture() {
      return RegistryGame.MODID + ":textures/gui/purifyer.png";
   }

   public String getOverlayIdentifier() {
      return "purifyer";
   }

   public Map<IRecipeInput, RecipeOutput> getRecipeList() {
      //return RegistryRecipe.purifier.get(tier).getRecipes();
      return null;
   }

   @Override
   public void loadCraftingRecipes(String arg0, Object... results) {
      for (IMachineRecipeManager mrm : RegistryRecipe.purifier.values()) {
         for (Map.Entry<IRecipeInput, RecipeOutput> e: mrm.getRecipes().entrySet()) {
            if (results.length == 0 ||
               (results[0] instanceof ItemStack && ItemUtil.containsItemStack(e.getValue().items, (ItemStack)results[0]))) {
                  arecipes.add(new CachedIORecipe(e.getKey(), e.getValue()));
               }
         }
   }
   }

   @Override
   public void loadUsageRecipes(String inputId, Object... ingredients) {
      
      for (IMachineRecipeManager mrm : RegistryRecipe.purifier.values()) {
            for (Map.Entry<IRecipeInput, RecipeOutput> e: mrm.getRecipes().entrySet()) {
               if (ingredients.length == 0 ||
                  (ingredients[0] instanceof ItemStack && ItemUtil.containsItemStack(e.getKey().getInputs(), (ItemStack)ingredients[0]))) {
                     arecipes.add(new CachedIORecipe(e.getKey(), e.getValue()));
                  }
            }
      }
   }
}
