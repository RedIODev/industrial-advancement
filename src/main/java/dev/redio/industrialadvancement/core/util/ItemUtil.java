package dev.redio.industrialadvancement.core.util;

import dev.redio.industrialadvancement.core.registry.RegistryGame;

public class ItemUtil {
    public static String textureName(String name) {
        return RegistryGame.MODID + ":" + name;
    }
}
