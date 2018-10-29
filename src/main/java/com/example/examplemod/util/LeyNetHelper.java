package com.example.examplemod.util;

import com.example.examplemod.Init.ModBlocks;
import com.example.examplemod.blocks.LeyNode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LeyNetHelper {

    int n = 0;


    public static void attachNode(World world, BlockPos pos) {

    }

//    public static boolean isAttachableTo(BlockPos pos1, BlockPos pos2, World world) {
//
//        ModBlocks.ley_node
//
//        return ;
//    }

    public BlockPos scanForNodes(int r, BlockPos pos, World world, LeyNode leyNode) {

        BlockPos posBlock;

        for (int i = pos.getX(); i < r; i++) {
            for (int j = pos.getY(); j < r; j++) {
                for (int k = pos.getZ(); k < r; k++) {
                    if (world.getBlockState(pos) == ModBlocks.ley_node) {
                        posBlock = new BlockPos(i,j,k);
//                        leyNode.getLeynodesAround().add(posBlock);
                    }
                }
            }
        }

        return pos;
    }

}
