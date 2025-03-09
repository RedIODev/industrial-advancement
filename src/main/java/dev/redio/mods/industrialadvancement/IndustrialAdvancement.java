package dev.redio.mods.industrialadvancement;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.mods.industrialadvancement.Blocks;
import dev.redio.mods.industrialadvancement.CommonProxy;
import dev.redio.mods.industrialadvancement.IndustrialAdvancement;
import dev.redio.mods.industrialadvancement.generation.QuartzSandWorldGenerator;

@Mod(modid = IndustrialAdvancement.MODID, version = IndustrialAdvancement.VERSION, name = "Industrial Advancement")
public class IndustrialAdvancement {
    public static final String MODID = "industrialadvancement";
    public static final String VERSION = "0.0.1";
    
    @Mod.Instance
    public static IndustrialAdvancement instance;

    @SidedProxy(clientSide = "dev.redio.mods.industrialadvancement.ClientProxy", 
        serverSide = "dev.redio.mods.industrialadvancement.CommonProxy")
    public static CommonProxy proxy;

    public static QuartzSandWorldGenerator worldGenerator = new QuartzSandWorldGenerator();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Blocks.registerBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(worldGenerator, 0);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
