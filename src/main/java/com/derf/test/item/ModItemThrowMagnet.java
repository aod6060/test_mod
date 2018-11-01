package com.derf.test.item;

import java.util.ArrayList;
import java.util.List;

import com.derf.test.init.ModItems;
import com.derf.test.util.ModUtils;
import com.derf.test.util.Vec3;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class ModItemThrowMagnet extends ModItem {
	
	private List<Item> filter = new ArrayList<>();
	
	private float range = 32.0f;
	private float strength = 0.8f;
	
	public ModItemThrowMagnet() {
		super("throw_magnet");
		this.setMaxStackSize(16);
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
			//entityItem.ticksExisted = 0;
			AxisAlignedBB box = ModUtils.createBox(entityItem, this.range);
			
			Vec3 pp = new Vec3(
					(float)entityItem.posX, 
					(float)entityItem.posY, 
					(float)entityItem.posZ);
			
			
			List<Entity> entities = ModUtils.getEntityWithinAABB(world, EntityItem.class,  box);
			
			
			entities.forEach(e -> {
				if(e instanceof EntityItem)
				{
					EntityItem i = (EntityItem)e;
					
					if(this.isFilter(i))
					{
						Vec3 v = new Vec3(
								(float)i.posX, 
								(float)i.posY, 
								(float)i.posZ);
						
						Vec3 delta = pp.sub(v);
						delta = delta.normalize();
						delta = delta.mul(this.strength);
						
						i.motionX += delta.getX();
						i.motionY += delta.getY();
						i.motionZ += delta.getZ();
					}
				}
			});
			
		}
		
		return super.onEntityItemUpdate(entityItem);
	}
	
	public void addItem(Item item)
	{
		this.filter.add(item);
	}
	
	private boolean isFilter(EntityItem stack)
	{
		boolean b = true;
		
		for(Item i : filter)
		{
			b = b && (i != stack.getItem().getItem());
		}
		
		return b;
	}
}
