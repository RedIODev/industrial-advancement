package dev.redio.industrialadvancement.core.generator;

import cpw.mods.fml.common.IWorldGenerator;

public interface IWeightedWorldGenerator extends IWorldGenerator {
    int generationWeight();
}
