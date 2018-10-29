package com.example.examplemod.Init;

import com.example.examplemod.world.biome.LibraryBiome;
import org.lwjgl.Sys;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {

        public static final Biome LIBRARY = new LibraryBiome();

        public static void registerBiomes()
        {
            initBiome(LIBRARY, "Library", BiomeType.WARM, Type.DRY, Type.MAGICAL, Type.RARE);
        }

        private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
        {
            biome.setRegistryName(name);
            ForgeRegistries.BIOMES.register(biome);
            System.out.println("Biome Registered");
            BiomeDictionary.addTypes(biome, types);
            BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
            BiomeManager.addSpawnBiome(biome);
            System.out.println("Biome Added");
            return biome;
        }
}
