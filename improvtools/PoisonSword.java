package com.link2o1o.improvtools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PoisonSword extends Item{
	//adds name for unlocalized
	private final String name = "poison";
	//registers/sets sword
	public PoisonSword(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(ImprovTools.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabTools);
	}
	//get name
	public String getName(){
		return name;
	}
	//(supposed to) Applies poison to sword
	public boolean dealPoison(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving){
		par1ItemStack.damageItem(1, par3EntityLiving);
		par2EntityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 30, 0));
		return true;
	}
}
