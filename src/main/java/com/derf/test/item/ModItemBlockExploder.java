package com.derf.test.item;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModItemBlockExploder extends ModItem {

	
	private int numExplosions = 5;
	
	public ModItemBlockExploder() {
		super("block_exploder");
	}

	@Override
	public EnumActionResult onItemUse(
			EntityPlayer player, 
			World world, 
			BlockPos pos, 
			EnumHand hand,
			EnumFacing facing, 
			float hitX, 
			float hitY, 
			float hitZ) {
		
		
		if(!world.isRemote)
		{
			float maxOffset = 3.0f;
			float half = maxOffset * 0.5f;
			
			float posX = pos.getX();
			float posY = pos.getY();
			float posZ = pos.getZ();
			
			Random rand = new Random();
			
			for(int i = 0; i < this.numExplosions; i++)
			{
				float offsetX = rand.nextFloat() * maxOffset - half;
				float offsetY = rand.nextFloat() * maxOffset - half;
				float offsetZ = rand.nextFloat() * maxOffset - half;
				
				player.world.createExplosion(null, posX + offsetX, posY + offsetY, posZ + offsetZ, 2.0f, true);
			}
			return EnumActionResult.SUCCESS;
		}
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if(!player.world.isRemote)
		{
			Random rand = new Random();
			
			float maxOffset = 3.0f;
			float half = maxOffset * 0.5f;
			
			float posX = (float) entity.posX;
			float posY = (float) entity.posY;
			float posZ = (float) entity.posZ;
			
			for(int i = 0; i < this.numExplosions; i++)
			{
				float offsetX = rand.nextFloat() * maxOffset - half;
				float offsetY = rand.nextFloat() * maxOffset - half;
				float offsetZ = rand.nextFloat() * maxOffset - half;
				
				player.world.createExplosion(entity, posX + offsetX, posY + offsetY, posZ + offsetZ, 2.0f, true);
			}
			
		}
		return super.onLeftClickEntity(stack, player, entity);
	}
	
	
}
