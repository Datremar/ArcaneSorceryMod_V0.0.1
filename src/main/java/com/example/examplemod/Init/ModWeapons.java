package com.example.examplemod.Init;

import java.util.ArrayList;
import java.util.List;

import com.example.examplemod.Init.specialitems.ConstellationStuff;
import com.example.examplemod.Init.specialitems.TestStuff;
import com.example.examplemod.Items.WeaponBase;
import com.example.examplemod.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ModWeapons {
	public static final List<ItemSword> WEAPONS = new ArrayList<ItemSword>();

	public static final ItemSword moonSword = new WeaponBase(Item.ToolMaterial.DIAMOND, Reference.moonSwordRegName, CreativeTabs.COMBAT, 1, Reference.moonSwordInGameName, 12);
	public static final ItemSword arcenonStaff = new WeaponBase(Item.ToolMaterial.DIAMOND, Reference.arcenonStuffRegname, CreativeTabs.COMBAT, 1, Reference.arcenonStuffIngamename, 5);
	public static final TestStuff testStuff = new TestStuff();
	public static final ConstellationStuff constelStuff = new ConstellationStuff();
}
