package dev.redio.industrialadvancement.core.registry;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import dev.redio.industrialadvancement.core.generator.GeneratorDrenchedStone;
import dev.redio.industrialadvancement.core.generator.GeneratorQuartzSand;
import dev.redio.industrialadvancement.core.generator.IWeightedWorldGenerator;

public class RegistryGenerator {

    public static GeneratorQuartzSand quartzSand;
    public static GeneratorDrenchedStone drenchedStone;

    public static final List<IWorldGenerator> generators = new ArrayList<IWorldGenerator>();

    public static void registerGenerators() {
        generators.add(quartzSand = new GeneratorQuartzSand());
        generators.add(drenchedStone = new GeneratorDrenchedStone());

        for (IWorldGenerator generator : generators) {
            int weight = 0;
            if (generator instanceof IWeightedWorldGenerator) {
                weight = ((IWeightedWorldGenerator)generator).generationWeight();
            }
            GameRegistry.registerWorldGenerator(generator, weight);
        }
    }
}
