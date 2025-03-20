package dev.redio.industrialadvancement.core.generator;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import dev.redio.industrialadvancement.core.registry.RegistryBlock;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class GeneratorDrenchedStone implements IWorldGenerator {

        public static final int CHANCE = 8;
    public static final int MIN_HEIGHT = 0;
    public static final int MAX_HEIGHT = 40;
    public static final int MIN_SIZE = 8;
    public static final int MAX_SIZE = 20;

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
            IChunkProvider chunkProvider) {
        if (world.provider.dimensionId != 0)
            return;
        int vainsize = MIN_SIZE + random.nextInt(MAX_SIZE - MIN_SIZE);
        int heightRange = MAX_HEIGHT - MIN_HEIGHT;
        WorldGenMinable gen = new WorldGenMinable(RegistryBlock.drenchedStone, vainsize, Blocks.stone);
        for (int i = 0; i < CHANCE; i++) {
            int x = chunkX * 16 + random.nextInt(16);
            int y = random.nextInt(heightRange) + MIN_HEIGHT;
            int z = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, x, y, z);
        }
    }
    
}
