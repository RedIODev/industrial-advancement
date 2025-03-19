package dev.redio.industrialadvancement.core.util;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class EasyMaterial extends Material {

    public EasyMaterial(MapColor mapColor) {
        super(mapColor);
    }

    /**
     * Makes blocks with this material require the correct tool to be harvested.
     */
    public Material setRequiresTool() {
        return super.setRequiresTool();
    }

    /**
     * Set the canBurn bool to True and return the current object.
     */
    public Material setBurning() {
        return super.setBurning();
    }

    /**
     * This type of material can't be pushed, but pistons can move over it.
     */
    public Material setNoPushMobility() {
        return super.setNoPushMobility();
    }

    /**
     * This type of material can't be pushed, and pistons are blocked to move.
     */
    public Material setImmovableMobility() {
        return super.setImmovableMobility();
    }

    /**
     * @see #isAdventureModeExempt()
     */
    public Material setAdventureModeExempt() {
        return super.setAdventureModeExempt();
    }
    
}
