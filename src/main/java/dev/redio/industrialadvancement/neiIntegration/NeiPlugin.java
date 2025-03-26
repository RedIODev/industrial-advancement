package dev.redio.industrialadvancement.neiIntegration;

import codechicken.nei.api.API;
import dev.redio.industrialadvancement.core.registry.RegistryRecipe;
import ic2.core.gui.GuiPurifyer;


public class NeiPlugin {
    public NeiPlugin() {
    }
 
    public static void init() {
        // for (int i = 0; i < RegistryRecipe.purifier.size(); i++) {
        //     API.registerRecipeHandler(new PurifyerRecipeHandler(i));
        //     API.registerUsageHandler(new PurifyerRecipeHandler(i));
        // }
       

        API.registerRecipeHandler(new PurifyerRecipeHandler());
        API.registerUsageHandler(new PurifyerRecipeHandler());
       API.registerGuiOverlay(GuiPurifyer.class, "purifyer", 5, 11);
       
    }
 }
 