package com.example.examplemod.blocks;

import com.example.examplemod.Init.ModBlocks;
import com.example.examplemod.Init.ModItems;
import com.example.examplemod.Reference;
import com.example.examplemod.world.LibraryTeleporter;
import com.example.examplemod.world.WorldRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TestBlock extends Block {
    public TestBlock() {
        super(Material.ROCK);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setLightLevel(0.5f);
        setHardness(1.0f);
        setRegistryName(Reference.test_blockRegName);
        setUnlocalizedName(Reference.test_blockInGameName);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return this.NULL_AABB;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (!entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && entityIn instanceof EntityPlayerMP)
        {
            EntityPlayerMP player = (EntityPlayerMP) entityIn;
            if(player.timeUntilPortal > 0) {
                player.timeUntilPortal = 10;
            } else if (player.dimension != WorldRegistry.dimensionID) {
                player.timeUntilPortal = 10;
                player.mcServer.getPlayerList().transferPlayerToDimension(player, WorldRegistry.dimensionID, new LibraryTeleporter(player.mcServer.getWorld(WorldRegistry.dimensionID)));
            } else {
                player.timeUntilPortal = 10;
                player.mcServer.getPlayerList().transferPlayerToDimension(player, 0, new LibraryTeleporter(player.mcServer.getWorld(WorldRegistry.dimensionID)));
            }
        }
    }


}
