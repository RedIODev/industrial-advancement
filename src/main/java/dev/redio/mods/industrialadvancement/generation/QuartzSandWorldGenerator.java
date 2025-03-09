package dev.redio.mods.industrialadvancement.generation;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import dev.redio.mods.industrialadvancement.Blocks;
import dev.redio.mods.industrialadvancement.IndustrialAdvancement;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;

public class QuartzSandWorldGenerator implements IWorldGenerator {
    private static final int CHANCE = 10;
    private static final int MIN_HEIGHT = 50;
    private static final int MAX_HEIGHT = 70;
    private static final int MIN_SIZE = 5;
    private static final int MAX_SIZE = 10;

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId != 0) return;
        int vainsize = MIN_SIZE + random.nextInt(MAX_SIZE-MIN_SIZE);
        int heightRange = MAX_HEIGHT-MIN_HEIGHT;
        WorldGenMinable gen = new WorldGenMinable(Blocks.quartz_sand, vainsize, net.minecraft.init.Blocks.sand);
        for (int i = 0; i < CHANCE; i++) {
            int x = chunkX*16+ random.nextInt(16);
            int y = random.nextInt(heightRange)+MIN_HEIGHT;
            int z = chunkZ*16+ random.nextInt(16);
            gen.generate(world, random, x, y, z);
        }
    }
}
