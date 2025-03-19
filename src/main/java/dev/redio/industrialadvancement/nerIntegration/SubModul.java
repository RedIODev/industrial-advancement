package dev.redio.industrialadvancement.nerIntegration;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import ic2.core.ISubModul;

public class SubModul implements ISubModul {
   public SubModul() {
   }

   public void afterItemLoad() {
   }

   public void beforeItemLoad() {
   }

   public boolean canLoad() {
      return Loader.isModLoaded("neresources");
   }

   public String getModulName() {
      return "Not Enough Resources IA-Addon";
   }

   public void onPostLoad() {
      NerPlugin.load();
   }

   public boolean supportsSide(Side arg0) {
      return true;
   }

   public String getConfigName() {
      return "NotEnoughResources";
   }
}
