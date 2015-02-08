/*
 * Unused at the moment.
 */
package com.link2o1o.improvtools;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public abstract class ApplyEffect extends EntityLivingBase {
	private final Map activePotionsMap = Maps.newHashMap();

	public ApplyEffect(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void addPotionEffect(PotionEffect effectOnHit){
		if (this.isPotionApplicable(effectOnHit))
        {
            if (this.activePotionsMap.containsKey(Integer.valueOf(effectOnHit.getPotionID())))
            {
				ItemStack stoneSword = new ItemStack(Items.stone_sword);
				if(this.getHeldItem() == stoneSword){
					((PotionEffect)this.activePotionsMap.get(Integer.valueOf(effectOnHit.getPotionID()))).combine(effectOnHit);
					this.onChangedPotionEffect((PotionEffect)this.activePotionsMap.get(Integer.valueOf(effectOnHit.getPotionID())), true);
				}
            }
            else
            {
                this.activePotionsMap.put(Integer.valueOf(effectOnHit.getPotionID()), effectOnHit);
                this.onNewPotionEffect(effectOnHit);
            }
        }
	}
		
}
