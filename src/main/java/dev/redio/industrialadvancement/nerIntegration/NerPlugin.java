package dev.redio.industrialadvancement.nerIntegration;

import dev.redio.industrialadvancement.core.generator.GeneratorQuartzSand;
import dev.redio.industrialadvancement.core.registry.RegistryBlock;
import ic2.core.IC2;
import ic2.core.Ic2Items;
import neresources.api.distributions.DistributionCustom;
import neresources.api.distributions.DistributionSquare;
import neresources.api.distributions.DistributionUnderWater;
import neresources.api.messages.RegisterOreMessage;
import neresources.registry.OreRegistry;
import net.minecraft.item.ItemStack;

public class NerPlugin {
   public NerPlugin() {
   }

   public static void load() {
    //   float density = IC2.oreDensityFactor;
    //   int baseScale = Math.round(64.0F * density);
    //   float chance;
    //   if (IC2.enableWorldGenOreCopper && Ic2Items.copperOre != null) {
    //      chance = (float)(15 * (baseScale / 64) * 10) / 15104.0F;
    //      RegisterOreMessage mes = new RegisterOreMessage(Ic2Items.copperOre.copy(), new DistributionSquare(10, 60, chance), 9127187, new ItemStack[0]);
    //      OreRegistry.registerOre(mes);
    //    }
    float chance = (GeneratorQuartzSand.CHANCE*((GeneratorQuartzSand.MIN_SIZE+GeneratorQuartzSand.MAX_SIZE)/2.0F))/15104.0f;
    RegisterOreMessage mes = new RegisterOreMessage(new ItemStack(RegistryBlock.quartz_sand), 
        new DistributionSquare(GeneratorQuartzSand.MIN_HEIGHT, GeneratorQuartzSand.MAX_HEIGHT, chance));
    OreRegistry.registerOre(mes);
    //   RegisterOreMessage mes;
    //   int maxY;
    //   if (IC2.enableWorldGenOreTin && Ic2Items.tinOre != null) {
    //      chance = (float)(25 * (baseScale / 64) * 6) / 10240.0F;
    //      maxY = 40 * (baseScale / 64);
    //      mes = new RegisterOreMessage(Ic2Items.tinOre.copy(), new DistributionSquare(0, maxY, chance), 13882323, new ItemStack[0]);
    //      OreRegistry.registerOre(mes);
    //   }

    //   if (IC2.enableWorldGenOreCopper && Ic2Items.copperOre != null) {
    //      chance = (float)(20 * (baseScale / 64) * 3) / 16384.0F;
    //      maxY = 64 * (baseScale / 64);
    //      mes = new RegisterOreMessage(Ic2Items.uraniumOre.copy(), new DistributionSquare(10, maxY, chance), 25600, new ItemStack[0]);
    //      OreRegistry.registerOre(mes);
    //   }

   }
}