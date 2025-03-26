package dev.redio.industrialadvancement.core.registry;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import dev.redio.industrialadvancement.core.proxy.ProxyCommon;
import dev.redio.industrialadvancement.core.registry.RegistryGame;
import dev.redio.industrialadvancement.core.util.TierItem;
import ic2.core.IC2;
import ic2.core.ISubModul;

@Mod(modid = RegistryGame.MODID, version = RegistryGame.VERSION, name = RegistryGame.NAME, dependencies = RegistryGame.DEPENDENCIES)
public class RegistryGame {
    public static final String MODID = "industrialadvancement";
    public static final String VERSION = "0.0.1";
    public static final String NAME = "Industrial Advancement";
    public static final String DEPENDENCIES = "after:IC2";

    
    @Mod.Instance
    public static RegistryGame instance;
    
    @SidedProxy(clientSide = "dev.redio.industrialadvancement.core.proxy.ProxyClient", 
    serverSide = "dev.redio.industrialadvancement.core.proxy.ProxyCommon")
    public static ProxyCommon proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        // order sensitive creative tabs > fluids > blocks > items > tile >
        RegistryCreativeTab.registerCreativeTabs();
        RegistryFluid.registerFluids();
        RegistryBlock.registerBlocks();
        RegistryItem.registerItems();
        proxy.registerTileEntities();
        loadSubModule(new dev.redio.industrialadvancement.nerIntegration.SubModul());
        loadSubModule(new dev.redio.industrialadvancement.neiIntegration.SubModul());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        RegistryGenerator.registerGenerators();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }

    private void loadSubModule(ISubModul plugin) {
        if (Boolean.parseBoolean(IC2.config.get("modules", plugin.getConfigName(), true).getString()) && plugin.canLoad() && plugin.supportsSide(FMLCommonHandler.instance().getEffectiveSide())) {
            IC2.modul.put(plugin.getModulName(), plugin);
        }
    }
}
