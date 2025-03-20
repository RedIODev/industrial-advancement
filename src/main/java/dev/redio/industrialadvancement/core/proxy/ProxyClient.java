package dev.redio.industrialadvancement.core.proxy;

import cpw.mods.fml.client.FMLClientHandler;
import dev.redio.industrialadvancement.core.proxy.ProxyCommon;
import ic2.core.ContainerIC2;
import ic2.core.IHasGui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class ProxyClient extends ProxyCommon {
    
    public boolean launchGuiClient(EntityPlayer player, IHasGui inventory) {
        ContainerIC2 container = inventory.getGuiContainer(player);
        Class containerClass = container.getClass();

        GuiScreen screen;
        try {
            screen = (GuiScreen)Class.forName(inventory.getGuiClassName(player))
                .getConstructor(containerClass)
                .newInstance(containerClass.cast(container));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        FMLClientHandler.instance().displayGuiScreen(player, screen);
        return true;
    }//Send correct Gui package from BlockMultiID over platform(server) to network manager to platform (client)
}
