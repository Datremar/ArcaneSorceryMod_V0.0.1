package com.example.examplemod.world;

import com.example.examplemod.Init.ModBiomes;
import com.example.examplemod.Reference;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldLibrary extends WorldProvider {

    public WorldLibrary() {
        this.biomeProvider = new BiomeProviderSingle(ModBiomes.LIBRARY);
    }

    @Override
    public DimensionType getDimensionType() {
        return WorldRegistry.LIBRARY;
    }

    @Override
    public int getDimension() {
        return Reference.dimensionID;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float par1, float par2) {
        return new Vec3d(0.6D, 0.0D, 0.6D);
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new LibraryChunkProvider(this.world, true, world.getSeed());
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean doesXZShowFog(int x, int z) {
        return super.doesXZShowFog(x, z);
    }
}
