package com.link2o1o.improvtools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PoisonSword extends ItemSword{
	//adds name for unlocalized
	private final static String NAME = "poison";
	//registers/sets sword
	public PoisonSword(ToolMaterial material){
		super(material);
		this.setUnlocalizedName("improvTools_" + NAME + "_" + material);
	}
	//get name
	public String getName(){
		return NAME;
	}
	//Applies poison to entity attacked
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		if (target instanceof EntityLivingBase){
			 EntityLivingBase entity1 = target;
			 entity1.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 3));
		 }
        stack.damageItem(1, attacker);
        return true;
    }
		 
}
