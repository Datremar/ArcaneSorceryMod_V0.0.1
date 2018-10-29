package com.example.examplemod.world;

import com.example.examplemod.Init.ModBlocks;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import java.util.Random;

public class LibraryTeleporter extends Teleporter {

    private final WorldServer world;
    private final Random random;
    private final Long2ObjectMap<PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap(4096);

    public LibraryTeleporter(WorldServer worldIn) {
        super(worldIn);
        this.world = worldIn;
        this.random = new Random(worldIn.getSeed());
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        if (this.world.provider.getDimensionType().getId() != 1) {
            if (!this.placeInExistingPortal(entityIn, rotationYaw)) {
                this.makePortal(entityIn);
                this.placeInExistingPortal(entityIn, rotationYaw);
            }
        } else {
            int i = MathHelper.floor(entityIn.posX);
            int j = MathHelper.floor(entityIn.posY) - 1;
            int k = MathHelper.floor(entityIn.posZ);
            boolean flag = true;

            buildPortal(i, j, k, flag);

            entityIn.setLocationAndAngles((double) i, (double) j, (double) k, entityIn.rotationYaw, 0.0F);
            entityIn.motionX = 0.0D;
            entityIn.motionY = 0.0D;
            entityIn.motionZ = 0.0D;

        }
    }

    @Override
    public boolean makePortal(Entity entityIn) {
        buildPortal((int)entityIn.posX, (int)entityIn.posY, (int)entityIn.posZ, true);
        return true;
    }

    private void buildPortal(int x, int y, int z, boolean flag) {
        this.world.setBlockState(new BlockPos(x, y, z), flag ? ModBlocks.test_block.getDefaultState() : Blocks.AIR.getDefaultState());
    }

    private boolean func_180265_a(BlockPos pos) {
        return !this.world.isAirBlock(pos) || !this.world.isAirBlock(pos.up());
    }

    public void removeStalePortalLocations(long worldTime)
    {
        if (worldTime % 100L == 0L)
        {
            long i = worldTime - 300L;
            ObjectIterator<PortalPosition> objectiterator = this.destinationCoordinateCache.values().iterator();

            while (objectiterator.hasNext())
            {
                Teleporter.PortalPosition teleporter$portalposition = (Teleporter.PortalPosition)objectiterator;

                if (teleporter$portalposition == null || teleporter$portalposition.lastUpdateTime < i)
                {
                    objectiterator.remove();
                }
            }
        }
    }

    public class PortalPosition extends BlockPos
    {
        public long lastUpdateTime;

        public PortalPosition(BlockPos pos, long lastUpdate)
        {
            super(pos.getX(), pos.getY(), pos.getZ());
            this.lastUpdateTime = lastUpdate;
        }
    }
}
