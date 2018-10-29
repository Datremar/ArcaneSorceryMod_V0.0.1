package com.example.examplemod.Init;

import java.util.ArrayList;
import java.util.List;

import com.example.examplemod.Init.specialitems.Tome;
import com.example.examplemod.Items.ItemBase;
import com.example.examplemod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item moonShard = new ItemBase(Reference.moonShardRegName, Reference.moonShardInGameName, CreativeTabs.MATERIALS);
	public static final Item arcaneEssence = new ItemBase(Reference.arcaneEssenceRegName, Reference.arcaneEssenceInGameName, CreativeTabs.MATERIALS);
	public static final Tome arcaneTome = new Tome();

}
