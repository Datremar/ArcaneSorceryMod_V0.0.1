package com.example.examplemod.proxy;


import com.example.examplemod.DataFixesManagerASM;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.util.datafix.DataFixer;

public class CommonProxy {

	public static DamageSource arcaneDamage = new DamageSource("asm.arcane").setMagicDamage();

	public static void createDataFixes() {
        DataFixesManagerASM.createFixer();
    }
	public void registerItemRenderer(Item item, int meta, String id) {}
	public void registerWeaponRenderer(ItemSword itemSword, int meta, String id) {}
	public void registerEntities() {}
}
