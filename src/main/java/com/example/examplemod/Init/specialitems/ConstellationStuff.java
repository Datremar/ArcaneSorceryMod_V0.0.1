package com.example.examplemod.Init.specialitems;

import com.example.examplemod.Init.ModWeapons;
import com.example.examplemod.Main;
import com.example.examplemod.Reference;
import com.example.examplemod.entities.missiles.Blast;
import com.example.examplemod.util.IHasModel;
import com.example.examplemod.util.ISpecialItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ConstellationStuff extends ItemSword implements IHasModel, ISpecialItem {
    public ConstellationStuff() {
        super(ToolMaterial.DIAMOND);
        setMaxDamage(4);
        setCreativeTab(CreativeTabs.COMBAT);
        setRegistryName(Reference.constellStuffRegName);
        setUnlocalizedName(Reference.constellStuffInGameName);
        setMaxStackSize(1);

        ModWeapons.WEAPONS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerWeaponRenderer(this, 0, "inventory");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        Blast blast = new Blast(worldIn, playerIn);
        worldIn.spawnEntity(blast);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return EnumActionResult.SUCCESS;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return false;
    }
}
