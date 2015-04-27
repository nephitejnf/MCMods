package com.link2o1o.improvtools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SharpenedSword extends ImprovItemSword{
	private final static String NAME = "sharpenedSword";
	public SharpenedSword(ToolMaterial material) {
		super(NAME + "_" + material, material);
	}
	public String getName() {
		// TODO Auto-generated method stub
		return NAME;
	}
	
}
