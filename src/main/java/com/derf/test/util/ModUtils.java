package com.derf.test.util;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class ModUtils {
	public static AxisAlignedBB createBox(Entity entity, float range)
	{
		float half = range * 0.5f;
		
		AxisAlignedBB box = new AxisAlignedBB(
				entity.posX - half,
				entity.posY - half,
				entity.posZ - half,
				entity.posX + half,
				entity.posY + half,
				entity.posZ + half
		);
		
		return box;
	}
	
	public static AxisAlignedBB createBox(Entity entity, float xSize, float ySize, float zSize)
	{
		Vec3 size = new Vec3(xSize, ySize, zSize);
		
		Vec3 halfSize = size.mul(0.5f);
		
		AxisAlignedBB box = new AxisAlignedBB(
				entity.posX - halfSize.getX(),
				entity.posY - halfSize.getY(),
				entity.posZ - halfSize.getZ(),
				entity.posX + halfSize.getX(),
				entity.posY + halfSize.getY(),
				entity.posZ + halfSize.getZ()
		);
		
		return box;
	}
	
	public static List<Entity> getEntityWithinAABB(World world, Class<? extends Entity> clz, AxisAlignedBB box)
	{
		List<Entity> temp;
		temp = world.getEntitiesWithinAABB(clz, box);
		return temp;
	}
}
