package com.derf.test.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ITeleporterControllerMode 
{
	void onItemUseSneak(
			ModItemTeleporterController controller,
			EntityPlayer player, 
			World world, 
			BlockPos pos, 
			EnumHand hand, 
			EnumFacing facing, 
			float hitX, 
			float hitY, 
			float hitZ);
	
	void onItemUseStand(
			ModItemTeleporterController controller,
			EntityPlayer player, 
			World world, 
			BlockPos pos, 
			EnumHand hand, 
			EnumFacing facing, 
			float hitX, 
			float hitY, 
			float hitZ);
	
	void onItemRightClickSneaking(
			ModItemTeleporterController controller,
			World world, 
			EntityPlayer player, 
			EnumHand hand);
	
	void onItemRightClickStanding(
			ModItemTeleporterController controller,
			World world,
			EntityPlayer player,
			EnumHand hand);
}
