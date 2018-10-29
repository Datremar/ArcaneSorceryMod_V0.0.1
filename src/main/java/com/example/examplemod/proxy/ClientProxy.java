package com.example.examplemod.proxy;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy{
	
    public void registerItemRenderer(Item item, int meta, String id) {
    	ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	public void registerWeaponRenderer(ItemSword itemSword, int meta, String id) {
    	ModelLoader.setCustomModelResourceLocation(itemSword, meta, new ModelResourceLocation(itemSword.getRegistryName(), id));
	}

	public void registerEntities() {
//		ModEntities.registerEntities();
	}
}
