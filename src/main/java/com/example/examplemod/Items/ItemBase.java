package com.example.examplemod.Items;

import com.example.examplemod.Init.ModItems;
import com.example.examplemod.Main;
import com.example.examplemod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String registryName, String inGameName, CreativeTabs creativeTabs) {
		setUnlocalizedName(inGameName);
		setRegistryName(registryName);
		setCreativeTab(creativeTabs);

		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
