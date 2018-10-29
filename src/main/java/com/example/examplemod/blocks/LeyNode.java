package com.example.examplemod.blocks;

import com.example.examplemod.Init.ModBlocks;
import com.example.examplemod.Init.ModItems;
import com.example.examplemod.Reference;
import com.example.examplemod.util.nodeProperites.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class LeyNode extends Block {

    protected static double a = 1.0d;
    protected static final AxisAlignedBB aabb = new AxisAlignedBB(a, a, a, a, a, a);
    protected Random random;
    protected int rad;
    protected ArrayList<BlockPos> positions = new ArrayList<>(1);
    protected Properties props;

    public LeyNode() {
        super(Material.GLASS);
        setResistance(10f);
        setBlockUnbreakable();
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setLightLevel(3f);
        setRegistryName(Reference.leyNodeRegName);
        setUnlocalizedName(Reference.leyNodeInGameName);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        random = new Random();
        rad = 64;
        props = new Properties();

        props.getFel();
    }

    //Field: Radius, Exp like power

    public int getRad() {
        return rad;
    }

    public ArrayList<BlockPos> scanNodes (int rad, BlockPos pos, World world) {


        BlockPos posBlock;

        for (int i = pos.getX(); i < getRad(); i++) {
            for (int j = pos.getY(); j < getRad(); j++) {
                for (int k = pos.getZ(); k < getRad(); k++) {
                    if (world.getBlockState(pos) == ModBlocks.ley_node) {
                        posBlock = new BlockPos(i,j,k);
                        positions.add(posBlock);
                    }
                }
            }
        }

        return positions;
    }

    @Override
    public boolean canSpawnInBlock() {
        return true;
    }

    @Override
    public boolean isTranslucent(IBlockState state) {
        return true;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return aabb;
    }
}
