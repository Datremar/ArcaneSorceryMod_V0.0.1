package com.example.examplemod;

import com.example.examplemod.entities.missiles.Blast;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.DataFixesManager;

public class DataFixesManagerASM extends DataFixesManager {

    public static DataFixer createFixer() {
        DataFixer datafixer = new DataFixer(1343);
        datafixer = new net.minecraftforge.common.util.CompoundDataFixer(datafixer);
//        Blast.registerFixes(datafixer);
        return datafixer;
    }
}
