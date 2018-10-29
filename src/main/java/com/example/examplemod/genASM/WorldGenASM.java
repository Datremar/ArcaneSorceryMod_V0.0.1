package com.example.examplemod.genASM;

import com.example.examplemod.Init.ModBlocks;
import com.example.examplemod.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenASM implements IWorldGenerator {

    BlockPos pos;
    WorldGenStructure genStructure;

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (random.nextInt((int) Math.pow(2,4)) == 0) {
            this.genStructure = new WorldGenStructure(Reference.towerName);
        }
    }

    private void setBlock (Random random, BlockPos pos, World world, int chunkX, int chunkZ, int x, int y, int z, IBlockState blockState) {
        pos = new BlockPos(chunkX * 16 + x, y, chunkZ * 16 + z);
        world.setBlockState(pos, blockState);

    }
}
