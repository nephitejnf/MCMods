package com.link2o1o.improvtools;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SharpenedSword extends ItemSword{
	NBTTagCompound nbt = new NBTTagCompound();
	//NBTTagCompound nbt2 = new NBTTagCompound();
	private int timer = 10;
	private int iTimer = timer;
	
	private final static String NAME = "sharpenedSword";
	//Here to allow for editing getDamageVsEntity
	ToolMaterial material;
	public SharpenedSword(ToolMaterial material) {
		super(material);
		this.material = material;
		this.setUnlocalizedName("improvTools_" + NAME + "_" + material);
	}
	public String getName() {
		return NAME;
	}
	//Applies sharpness 1 damage if Sharpness is in effect.
	@Override
	public float getDamageVsEntity()
    {
		if(nbt.getInteger("effectTimer") > 0){
			--timer;
			nbt.setInteger("effectTimer", timer);
			return this.material.getDamageVsEntity()+1.25F;
		}
		else
			return this.material.getDamageVsEntity();
    }
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player){
		//nbt2 = itemStack.getTagCompound();
		itemStack.setTagCompound(nbt);
		//nbt.setString("id", nbt2.getString("id"));
		//nbt.setByte("Count", (byte)itemStack.stackSize);
		//nbt.setShort("Damage", (short)itemStack.getItemDamage());
		nbt.setInteger("effectTimer", timer);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced){
		if(nbt != null && nbt.getInteger("effectTimer") > 0){
			tooltip.add(EnumChatFormatting.ITALIC + "Sharpened: " + nbt.getInteger("effectTimer"));
		}
	}
	//Supposed to update the tooltip information
	/*public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if(nbt != null && nbt.getInteger("effectTimer") > 0){
			List tooltip = null;
			boolean advanced = true;
			this.addInformation(stack, (EntityPlayer)entityIn, tooltip, advanced);
		}
	}
	*/
}
