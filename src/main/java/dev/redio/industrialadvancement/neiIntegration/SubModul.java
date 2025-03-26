package dev.redio.industrialadvancement.neiIntegration;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import ic2.core.ISubModul;

public class SubModul implements ISubModul {
   public SubModul() {
   }

   public boolean canLoad() {
      return Loader.isModLoaded("NotEnoughItems");
   }

   public String getModulName() {
      return "Nei SubModul IA-Addon";
   }

   public boolean supportsSide(Side par1) {
      return par1.isClient();
   }

   public void beforeItemLoad() {
   }

   public void afterItemLoad() {
   }

   public void onPostLoad() {
      NeiPlugin.init();
   }

   public String getConfigName() {
      return "NotEnoughItems";
   }
}
