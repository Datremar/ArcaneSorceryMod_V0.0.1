package com.example.examplemod.world.biome;

import net.minecraft.world.biome.Biome;

public class LibraryBiome extends Biome {

    public LibraryBiome() {
        super(new BiomeProperties("Library").setBaseHeight(1.5F).setHeightVariation(1.2F).setTemperature(0.6F).setRainDisabled().setWaterColor(16711680));
    }
}
