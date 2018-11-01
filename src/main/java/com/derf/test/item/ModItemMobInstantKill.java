package com.derf.test.item;

import java.util.ArrayList;
import java.util.List;

import com.derf.test.Logger;
import com.derf.test.util.ModUtils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class ModItemMobInstantKill extends ModItem {
	private List<Class<? extends Entity>> entityClasses = new ArrayList<>();
	
	public ModItemMobInstantKill() {
		super("mob_instant_kill");
		this.setMaxStackSize(16);
		entityClasses.add(EntityMob.class);
		entityClasses.add(EntitySlime.class);
		entityClasses.add(EntityGhast.class);
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		World world = entityItem.world;
		
		if(entityItem.getAge() > 0)
		{
			entityItem.setNoDespawn();
		}
		
		if(!world.isRemote)
		{
			AxisAlignedBB box = ModUtils.createBox(entityItem, 4.0f, 2.0f, 4.0f);
			
			entityClasses.forEach(ec -> {
				List<Entity> entities = ModUtils.getEntityWithinAABB(world, ec, box);
				
				entities.forEach(e -> {
					e.onKillCommand();
				});
			});
		}
		
		return super.onEntityItemUpdate(entityItem);
	}

	
	
}
