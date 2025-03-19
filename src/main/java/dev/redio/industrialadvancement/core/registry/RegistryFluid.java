package dev.redio.industrialadvancement.core.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import dev.redio.industrialadvancement.core.fluid.FluidCrudeOil;

public class RegistryFluid {

    public static FluidCrudeOil crude_oil;

    public static final List<Fluid> fluids = new ArrayList<Fluid>();
    
    public static void registerFluids() {
        fluids.add(crude_oil = new FluidCrudeOil());

        for (Fluid fluid: fluids) {
            FluidRegistry.registerFluid(fluid);
        }
    }
}
