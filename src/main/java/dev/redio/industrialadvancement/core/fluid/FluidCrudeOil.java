package dev.redio.industrialadvancement.core.fluid;

import net.minecraftforge.fluids.Fluid;

public class FluidCrudeOil extends Fluid {

    public static final String NAME = "crude_oil";

    public FluidCrudeOil() {
        super(NAME);
        setViscosity(3000);
        setDensity(860);
    }
    
}
