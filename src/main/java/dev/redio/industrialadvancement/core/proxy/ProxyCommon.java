package dev.redio.industrialadvancement.core.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.industrialadvancement.core.registry.RegistryGame;
import dev.redio.industrialadvancement.core.tile.TileEntityPurifyer;

public class ProxyCommon {
    
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityPurifyer.class, RegistryGame.MODID + "_tile_purifyer");
    }
}
