package com.example.examplemod.Init.specialitems;

import com.example.examplemod.GUI.GUIscreenASM;
import com.example.examplemod.Init.ModItems;
import com.example.examplemod.Main;
import com.example.examplemod.Reference;
import com.example.examplemod.util.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;


public class Tome extends Item implements IHasModel {
    public Tome() {
        setMaxStackSize(1);
        setUnlocalizedName(Reference.tomeInGameName);
        setRegistryName(Reference.tomeRegName);
        setCreativeTab(CreativeTabs.MISC);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (worldIn.isRemote) {
            Minecraft.getMinecraft().displayGuiScreen(new GUIscreenASM());
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
