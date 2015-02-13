package com.decoBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCobblePlank extends Block {

	private String name = "cobblePlank";
	
	protected BlockCobblePlank() {
		//fun code that does cool things, I hope it is self explanatory
		super(Material.rock);
		setUnlocalizedName(DecoBlocks.MODID+"_"+name);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer(){
		return EnumWorldBlockLayer.SOLID;
	}
	
	//the point of this I am yet to figure out, but it makes it so
	//the name is unchangable, but readable (refer to name String)
	public String getName(){
		return name;
	}

}
