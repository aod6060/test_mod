package com.derf.test.item;

import java.util.ArrayList;
import java.util.List;

import com.derf.test.util.ModUtils;
import com.derf.test.util.Vec3;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class ModItemThrowMagnetAnimal extends ModItem {
	
	
	private List<Class<? extends Entity>> entityClasses = new ArrayList<>();
	private float range = 64.0f;
	private float strength = 0.9f;
	
	public ModItemThrowMagnetAnimal() {
		super("throw_magnet_animal");
		this.setMaxStackSize(16);
		this.entityClasses.add(EntityAnimal.class);
		this.entityClasses.add(EntityVillager.class);
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
			AxisAlignedBB box = ModUtils.createBox(entityItem, this.range);
			
			Vec3 pp = new Vec3(
					(float)entityItem.posX, 
					(float)entityItem.posY, 
					(float)entityItem.posZ);
			
			this.entityClasses.forEach(ec -> {
				List<Entity> entities = ModUtils.getEntityWithinAABB(world, ec, box);
				
				entities.forEach(e -> {
					Vec3 v = new Vec3(
							(float)e.posX, 
							(float)e.posY, 
							(float)e.posZ);
					
					Vec3 delta = pp.sub(v);
					delta = delta.normalize();
					delta = delta.mul(this.strength);
					
					e.motionX += delta.getX();
					e.motionY += delta.getY();
					e.motionZ += delta.getZ();
				});
			});
		}
		
		return super.onEntityItemUpdate(entityItem);
	}
	
	
}
