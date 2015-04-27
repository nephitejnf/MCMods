package com.link2o1o.improvtools;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
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
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = ImprovTools.MODID, version = ImprovTools.VERSION)
public class ImprovTools {
	public static final String MODID = "improvTools";
	public static final String VERSION = "0.01a";
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		//A Stone sharpened material
		ToolMaterial SHARPENED_STONE = EnumHelper.addToolMaterial("S_STONE", 1, 131, 4.0F, 2.25F, 5);
		//New item Sharpened Sword, for Stone.
		SharpenedSword stoneSharpenedSword = new SharpenedSword(SHARPENED_STONE);
		GameRegistry.registerItem(stoneSharpenedSword, "sharpenedSword");
		
		//To prevent the server from rendering it.
		if(event.getSide() == Side.CLIENT){
			RenderItem rItem2 = Minecraft.getMinecraft().getRenderItem();
			rItem2.getItemModelMesher().register(stoneSharpenedSword, 0, new ModelResourceLocation(ImprovTools.MODID + ":" + stoneSharpenedSword.getName(), "inventory"));
		}
		//Sets up poison sword
		//PoisonSword poisonStoneSword = new PoisonSword();
		//Suppose to render the sword
		/*if(event.getSide() == Side.CLIENT){
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			renderItem.getItemModelMesher().register(poisonStoneSword, 0, new ModelResourceLocation(ImprovTools.MODID + ":" + ((PoisonSword)poisonStoneSword).getName(), "inventory"));
		}
		*/
		//The recipe for a sharpened stone sword
		ItemStack sharpenedStoneSword = new ItemStack(stoneSharpenedSword);
		GameRegistry.addShapelessRecipe(sharpenedStoneSword, new Object[]{
			new ItemStack(Items.stone_sword, 1), Items.flint
		});
		//A unbreaking 1 sword
		ItemStack toughenedStoneSword = new ItemStack(Items.stone_sword);
		toughenedStoneSword.addEnchantment(Enchantment.unbreaking, 1);
		GameRegistry.addShapelessRecipe(toughenedStoneSword, new Object[]{
			new ItemStack(Items.stone_sword, 1), Blocks.cobblestone
		});
		//Unbreaking 1 diamond pick
		ItemStack toughenedDiamondPick = new ItemStack(Items.diamond_pickaxe);
		toughenedDiamondPick.addEnchantment(Enchantment.unbreaking, 1);
		GameRegistry.addShapelessRecipe(toughenedDiamondPick, new Object[]{
			new ItemStack(Items.diamond_pickaxe, 1), Items.diamond
		});
		ItemStack toughenedIronChestplate = new ItemStack(Items.iron_chestplate);
		toughenedIronChestplate.addEnchantment(Enchantment.protection, 1);
		GameRegistry.addShapelessRecipe(toughenedIronChestplate, new Object[]{
				new ItemStack(Items.iron_chestplate, 1), Items.iron_ingot
		});
		ItemStack toughenedIronHelm = new ItemStack(Items.iron_helmet);
		toughenedIronHelm.addEnchantment(Enchantment.protection, 1);
		GameRegistry.addShapelessRecipe(toughenedIronHelm, new Object[]{
				new ItemStack(Items.iron_helmet, 1), Items.iron_ingot
		});
		ItemStack toughenedIronPants = new ItemStack(Items.iron_leggings);
		toughenedIronPants.addEnchantment(Enchantment.protection, 1);
		GameRegistry.addShapelessRecipe(toughenedIronPants, new Object[]{
				new ItemStack(Items.iron_leggings, 1), Items.iron_ingot
		});
		ItemStack toughenedIronBoots = new ItemStack(Items.iron_boots);
		toughenedIronBoots.addEnchantment(Enchantment.protection, 1);
		GameRegistry.addShapelessRecipe(toughenedIronBoots, new Object[]{
				new ItemStack(Items.iron_boots, 1), Items.iron_ingot
		});
		ItemStack greaterIronChestplate = new ItemStack(Items.iron_chestplate);
		greaterIronChestplate.addEnchantment(Enchantment.protection, 3);
		GameRegistry.addShapelessRecipe(greaterIronChestplate, new Object[]{
				new ItemStack(Items.iron_chestplate, 1), Items.diamond
		});
		ItemStack greaterIronHelm = new ItemStack(Items.iron_helmet);
		greaterIronHelm.addEnchantment(Enchantment.protection, 3);
		GameRegistry.addShapelessRecipe(greaterIronHelm, new Object[]{
				new ItemStack(Items.iron_helmet, 1), Items.diamond
		});
		ItemStack greaterIronPants = new ItemStack(Items.iron_leggings);
		greaterIronPants.addEnchantment(Enchantment.protection, 3);
		GameRegistry.addShapelessRecipe(greaterIronPants, new Object[]{
				new ItemStack(Items.iron_leggings, 1), Items.diamond
		});
		ItemStack greaterIronBoots = new ItemStack(Items.iron_boots);
		greaterIronBoots.addEnchantment(Enchantment.protection, 3);
		GameRegistry.addShapelessRecipe(greaterIronBoots, new Object[]{
				new ItemStack(Items.iron_boots, 1), Items.diamond
		});
		/*Unbreaking 8 diamond pick
		ItemStack reenforcedDiamondPick = new ItemStack(Items.diamond_pickaxe);
		reenforcedDiamondPick.addEnchantment(Enchantment.unbreaking, 8);
		GameRegistry.addShapelessRecipe(reenforcedDiamondPick, new Object[]{
			new ItemStack(Items.diamond_pickaxe, 1), Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond, Items.diamond
		});
		*/
	}
}
