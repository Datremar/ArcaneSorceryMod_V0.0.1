package com.example.examplemod.world;

import com.example.examplemod.Reference;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class WorldRegistry {

    public static void MainRegistry() {
        registerWorlds();
    }

    public static final int dimensionID = Reference.dimensionID;
    public static final DimensionType LIBRARY = DimensionType.register(Reference.worldLibrary, Reference.worldLibraryPostalThing, dimensionID, WorldLibrary.class, false);

    private static void registerWorlds() {
        DimensionManager.registerDimension(dimensionID, LIBRARY);
    }
}
