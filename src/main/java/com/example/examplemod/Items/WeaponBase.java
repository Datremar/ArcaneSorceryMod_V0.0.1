package com.example.examplemod.Items;



import com.example.examplemod.Init.ModWeapons;
import com.example.examplemod.Main;
import com.example.examplemod.Reference;
import com.example.examplemod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class WeaponBase  extends ItemSword implements IHasModel {

    public WeaponBase(ToolMaterial material, String weaponRegistryName, CreativeTabs creativeTabs, int maxStackSize, String weaponInGameName, int maxDamage) {
        super(material);
        setRegistryName(Reference.MOD_ID , weaponRegistryName);
        setCreativeTab(creativeTabs);
        setMaxStackSize(maxStackSize);
        setUnlocalizedName(weaponInGameName);
        setMaxDamage(maxDamage);

        ModWeapons.WEAPONS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerWeaponRenderer(this, 0, "inventory");
    }
}
