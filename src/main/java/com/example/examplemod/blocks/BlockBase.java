package com.example.examplemod.blocks;

import com.example.examplemod.Init.ModBlocks;
import com.example.examplemod.Init.ModItems;
import com.example.examplemod.Main;
import com.example.examplemod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(Material blockMaterialIn, String regName, String inGameName, CreativeTabs creativeTabs, float hardness) {
        super(blockMaterialIn);
        setRegistryName(regName);
        setUnlocalizedName(inGameName);
        setHardness(hardness);
        setCreativeTab(creativeTabs);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
