package com.decoBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = DecoBlocks.MODID, version = DecoBlocks.VERSION)

/* * * * * * * * * * * * * * * * * * * * * * * * * * * *\
 * This is the pain-in-my-butt code that finally works.*
 * Just need to play with the .json files a little.    *
 * Remember that many elements in the .json files are  *
 * case-sensitive.                                     *
\* * * * * * * * * * * * * * * * * * * * * * * * * * * */

//Be sure to look over the .json files
//minecraftbyexample was a big help in figuring this out

public class DecoBlocks {
	public static final String MODID = "decoBlocks";
	public static final String VERSION = "0.1a";
	
	public static Block bcp;
	
	EventHandler eh;
	
	@EventHandler
	public void preinit(FMLInitializationEvent e){
		
		bcp = new BlockCobblePlank();
		GameRegistry.registerBlock(bcp, "cobblePlank");
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e){

		//picking up how to render our lovely block
		if(e.getSide()==Side.CLIENT){
			RenderItem ri = Minecraft.getMinecraft().getRenderItem();
			ri.getItemModelMesher().register(Item.getItemFromBlock(bcp), 0, new ModelResourceLocation(MODID+":"+((BlockCobblePlank)bcp).getName(), "inventory"));
		}
		
		//Recipe for our combination of cobblestone and wood planks, other wood coming soon
		GameRegistry.addRecipe(new ItemStack(bcp,6), new Object[]{
			"CCC",
			"PPP",
			'C', Blocks.cobblestone,
			'P', Blocks.planks,
		});
		
	}

}
