package com.link2o1o.improvtools;

import net.minecraft.item.ItemSword;

public class ImprovItemSword extends ItemSword{

	public ImprovItemSword(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("improvTools_" + unlocalizedName);
	}

}
