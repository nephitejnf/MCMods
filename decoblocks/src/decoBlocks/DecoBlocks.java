package com.decoBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
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

@Mod(modid = DecoBlocks.MODID, name="Decoration Blocks and More", version = DecoBlocks.VERSION)

/* * * * * * * * * * * * * * * * * * * * * * * * * * * *\
 * This is the pain-in-my-butt code that finally works.*
 * Just need to play with the .json files a little.    *
 * Remember that many elements in the .json files are  *
 * case-sensitive.                                     *
\* * * * * * * * * * * * * * * * * * * * * * * * * * * */

//Be sure to look over the .json files
//minecraftbyexample was a big help in figuring this out

public class DecoBlocks {
	public static final String MODID = "decoblocks";
	public static final String VERSION = "0.1a";
	
	//public static Block bcp;
	public static Block plankBl;
	public static String blockName = "cobblePlank";
	public static String[] blockNames = {blockName+"oak",blockName+"spruce",blockName+"birch",blockName+"jungle",blockName+"acacia",blockName+"darkoak"};
	//public static String[] varNames = {"oak", "spruce", "birch", "jungle", "acacia", "darkoak"};
	
	EventHandler eh;
	
	@EventHandler
	public void preinit(FMLInitializationEvent e){
		
		//blockName = MODID+"_"+plankBl.getName();
		//bcp = new BlockCobblePlank();
		//GameRegistry.registerBlock(bcp, "cobblePlank");
		
		this.plankBl = (BlockCobblePlank)(new BlockCobblePlank().setUnlocalizedName("cobblePlank"));
		GameRegistry.registerBlock(plankBl, ItemCobbleBlockPlank.class, "cobblePlank");
		//ModelBakery.addVariantName(Item.getItemFromBlock(plankBl), blockNames);
		
		/*for(String tries : blockNames){
			
			GameRegistry.registerBlock(plankBl, tries);
		}*/
		
		if(e.getSide()==Side.CLIENT){
			Item itemBCP = GameRegistry.findItem("decoBlocks", blockName);
			ModelBakery.addVariantName(/*Item.getItemFromBlock(plankBl)*/itemBCP, MODID+":"+blockNames[0],MODID+":"+blockNames[1],MODID+":"+blockNames[2],MODID+":"+blockNames[3],MODID+":"+blockNames[4],MODID+":"+blockNames[5]);
			//ModelBakery.addVariantName(itemBCP, blockName+"_oak",blockName+"_spruce",blockName+"_birch",blockName+"_jungle",blockName+"_acacia",blockName+"_dark_oak");
		}
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e){

		//picking up how to render our lovely block
		if(e.getSide()==Side.CLIENT){
			final String inv = "inventory";
			RenderItem ri = Minecraft.getMinecraft().getRenderItem();
			//ri.getItemModelMesher().register(Item.getItemFromBlock(bcp), 0, new ModelResourceLocation(MODID+":"+((BlockCobblePlank)bcp).getName(), "inventory"));
			//plankBl = new BlockCobblePlank();
//			Item iBCP = Item.getItemFromBlock(plankBl);
			Item iBCP = GameRegistry.findItem("decoblocks", blockName);
			
			//ModelBakery.addVariantName(/*Item.getItemFromBlock(plankBl)*/iBCP, blockNames);
			//ModelResourceLocation itemMRL = new ModelResourceLocation(MODID+":");
			ModelResourceLocation itemMRL = new ModelResourceLocation("decoblocks"+":"+blockNames[0],inv);
			ri.getItemModelMesher().register(iBCP, BlockCobblePlank.EnumTypeWood.OAK.getMetaData(), itemMRL);
			
			itemMRL = new ModelResourceLocation("decoblocks"+":"+blockNames[1],inv);
			ri.getItemModelMesher().register(iBCP, BlockCobblePlank.EnumTypeWood.SPRUCE.getMetaData(), itemMRL);
			
			itemMRL = new ModelResourceLocation("decoblocks"+":"+blockNames[2],inv);
			ri.getItemModelMesher().register(iBCP, BlockCobblePlank.EnumTypeWood.BIRCH.getMetaData(), itemMRL);
			
			itemMRL = new ModelResourceLocation("decoblocks"+":"+blockNames[3],inv);
			ri.getItemModelMesher().register(iBCP, BlockCobblePlank.EnumTypeWood.JUNGLE.getMetaData(), itemMRL);
			
			itemMRL = new ModelResourceLocation("decoblocks"+":"+blockNames[4],inv);
			ri.getItemModelMesher().register(iBCP, BlockCobblePlank.EnumTypeWood.ACACIA.getMetaData(), itemMRL);
			
			itemMRL = new ModelResourceLocation("decoblocks"+":"+blockNames[5],inv);
			ri.getItemModelMesher().register(iBCP, BlockCobblePlank.EnumTypeWood.DARK_OAK.getMetaData(), itemMRL);
			
		}
		
		//Recipe for our combination of cobblestone and wood planks, other wood coming soon
		/*GameRegistry.addRecipe(new ItemStack(bcp,6), new Object[]{
			"CCC",
			"PPP",
			'C', Blocks.cobblestone,
			'P', Blocks.planks,
		});*/
		GameRegistry.addRecipe(new ItemStack(plankBl,6,BlockCobblePlank.EnumTypeWood.OAK.getMetaData()),
				new Object[] {
					"CCC",
					"OOO",
					'O', new ItemStack(Blocks.planks,1,0),
					'C', Blocks.cobblestone
		});
		
		GameRegistry.addRecipe(new ItemStack(plankBl,6,BlockCobblePlank.EnumTypeWood.SPRUCE.getMetaData()),
				new Object[] {
					"CCC",
					"SSS",
					'S', new ItemStack(Blocks.planks,1,1),
					'C', Blocks.cobblestone
		});
		
		GameRegistry.addRecipe(new ItemStack(plankBl,6,BlockCobblePlank.EnumTypeWood.BIRCH.getMetaData()),
				new Object[] {
					"CCC",
					"BBB",
					'B', new ItemStack(Blocks.planks,1,2),
					'C', Blocks.cobblestone
		});
		
		GameRegistry.addRecipe(new ItemStack(plankBl,6,BlockCobblePlank.EnumTypeWood.JUNGLE.getMetaData()),
				new Object[] {
					"CCC",
					"JJJ",
					'J', new ItemStack(Blocks.planks,1,3),
					'C', Blocks.cobblestone
		});
		
		GameRegistry.addRecipe(new ItemStack(plankBl,6,BlockCobblePlank.EnumTypeWood.ACACIA.getMetaData()),
				new Object[] {
					"CCC",
					"AAA",
					'A', new ItemStack(Blocks.planks,1,4),
					'C', Blocks.cobblestone
		});
		
		GameRegistry.addRecipe(new ItemStack(plankBl,6,BlockCobblePlank.EnumTypeWood.DARK_OAK.getMetaData()),
				new Object[] {
					"CCC",
					"DDD",
					'D', new ItemStack(Blocks.planks,1,5),
					'C', Blocks.cobblestone
		});
	}

}
