package com.example.examplemod.blocks;

import com.example.examplemod.Init.ModBlocks;
import com.example.examplemod.Init.ModItems;
import com.example.examplemod.Reference;
import com.example.examplemod.entities.missiles.Test;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ArcaneSeal extends Block {
    public static final AxisAlignedBB aabb = new AxisAlignedBB(0.125d, 0d, 0.125d, 0.875d, 0.0625d, 0.875d);

    public ArcaneSeal() {
        super(Material.GLASS);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setLightLevel(0.5f);
        setHardness(1.0f);
        setRegistryName(Reference.arcaneSealRegName);
        setUnlocalizedName(Reference.arcaneSealInGameName);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return aabb;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        Test test = new Test(worldIn, pos.getX(), pos.getY(), pos.getZ());
        worldIn.spawnEntity(test);
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }
}
