package com.example.examplemod.Init;

import com.example.examplemod.blocks.ArcaneSeal;
import com.example.examplemod.blocks.LeyNode;
import com.example.examplemod.blocks.TestBlock;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block test_block = new TestBlock();
    public static final Block arcane_seal = new ArcaneSeal();
    public static final Block ley_node = new LeyNode();
}
