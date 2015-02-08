package com.link2o1o.improvtools;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

@Mod(modid = ImprovTools.MODID, version = ImprovTools.VERSION)
public class ImprovTools {
	public static final String MODID = "lk21_improvtools";
	public static final String VERSION = "0.01a";
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//Sets up poison sword
		PoisonSword poisonStoneSword = new PoisonSword();
		//Suppose to render the sword
		if(event.getSide() == Side.CLIENT){
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			renderItem.getItemModelMesher().register(poisonStoneSword, 0, new ModelResourceLocation(ImprovTools.MODID + ":" + ((PoisonSword)poisonStoneSword).getName(), "inventory"));
		}
		//The recipe for a sharpened stone sword
		ItemStack sharpenedStoneSword = new ItemStack(Items.stone_sword);
		sharpenedStoneSword.addEnchantment(Enchantment.sharpness, 1);
		GameRegistry.addShapelessRecipe(sharpenedStoneSword, new Object[]{
			new ItemStack(Items.stone_sword, 1), Items.flint
		});
		//A unbreaking 1 sword
		ItemStack toughenedStoneSword = new ItemStack(Items.stone_sword);
		toughenedStoneSword.addEnchantment(Enchantment.unbreaking, 1);
		GameRegistry.addShapelessRecipe(toughenedStoneSword, new Object[]{
			new ItemStack(Items.stone_sword, 1), Blocks.cobblestone
		});
	}
}
