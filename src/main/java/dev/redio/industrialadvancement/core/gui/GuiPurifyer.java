package dev.redio.industrialadvancement.core.gui;

import org.lwjgl.opengl.GL11;

import dev.redio.industrialadvancement.core.registry.RegistryGame;
import ic2.core.block.machine.container.ContainerElectricMachine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiPurifyer extends GuiContainer {
    public ContainerElectricMachine container;
    public GuiPurifyer(ContainerElectricMachine container) {
        super(container);
        this.container = container;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.renderEngine.bindTexture(new ResourceLocation(RegistryGame.MODID, "textures/gui/purifyer.png"));
      int j = (this.width - this.xSize) / 2;
      int k = (this.height - this.ySize) / 2;
      this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);
      int chargeLevel = (int)(14.0F * this.container.tileEntity.getChargeLevel());
      int progress = (int)(24.0F * this.container.tileEntity.getProgress());
      if (chargeLevel > 0) {
         this.drawTexturedModalRect(j + 56, k + 36 + 14 - chargeLevel, 176, 14 - chargeLevel, 14, chargeLevel);
      }

      if (progress > 0) {
         this.drawTexturedModalRect(j + 79, k + 34, 176, 14, progress + 1, 16);
      }
    }
    
}
