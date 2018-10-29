package com.derf.test.item;

import com.derf.test.Logger;
import com.derf.test.util.TextCompFactory;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ModItemTestEvents extends ModItem {

	public ModItemTestEvents() {
		super("item_test_events");
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
			player.sendMessage(TextCompFactory.createTCS("OnItemUse"));
		}
		
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(
			World world, 
			EntityPlayer player, 
			EnumHand hand) {
		if(!world.isRemote)
		{
			player.sendMessage(TextCompFactory.createTCS("OnItemRightClick"));
		}
		
		return super.onItemRightClick(world, player, hand);
	}

	@Override
	public ItemStack onItemUseFinish(
			ItemStack stack, 
			World world, 
			EntityLivingBase entityLiving) {
		if(!world.isRemote)
		{
			entityLiving.sendMessage(TextCompFactory.createTCS("OnItemUseFinish"));
		}
		return super.onItemUseFinish(stack, world, entityLiving);
	}

	@Override
	public boolean onBlockDestroyed(
			ItemStack stack, 
			World world, 
			IBlockState state, 
			BlockPos pos,
			EntityLivingBase entityLiving) {
		if(!world.isRemote)
		{
			entityLiving.sendMessage(TextCompFactory.createTCS("OnBlockDestroyed"));
		}
		return super.onBlockDestroyed(stack, world, state, pos, entityLiving);
	}

	@Override
	public void onUpdate(
			ItemStack stack,
			World world, 
			Entity entity, 
			int itemSlot, 
			boolean isSelected) {
		
		// Wont spam text message use logger instead...
		if(!world.isRemote)
		{
			//Logger.getLogger().info("OnUpdate");
		}
		super.onUpdate(stack, world, entity, itemSlot, isSelected);
	}

	@Override
	public void onCreated(
			ItemStack stack, 
			World world, 
			EntityPlayer player) {
		
		if(!world.isRemote)
		{
			player.sendMessage(TextCompFactory.createTCS("OnCreate"));
		}
		super.onCreated(stack, world, player);
	}

	@Override
	public void onPlayerStoppedUsing(
			ItemStack stack, 
			World world, 
			EntityLivingBase entityLiving, 
			int timeLeft) {
		
		if(!world.isRemote)
		{
			entityLiving.sendMessage(TextCompFactory.createTCS("OnPlayerStoppedUsing"));
		}
		super.onPlayerStoppedUsing(stack, world, entityLiving, timeLeft);
	}

	@Override
	public boolean onDroppedByPlayer(
			ItemStack item, 
			EntityPlayer player) {
		player.sendMessage(TextCompFactory.createTCS("OnDroppedByPlayer"));
		return super.onDroppedByPlayer(item, player);
	}

	@Override
	public EnumActionResult onItemUseFirst(
			EntityPlayer player, 
			World world, 
			BlockPos pos, 
			EnumFacing side, 
			float hitX,
			float hitY, 
			float hitZ, 
			EnumHand hand) {
		
		if(!world.isRemote)
		{
			player.sendMessage(TextCompFactory.createTCS("OnItemUseFirst"));
		}
		return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand);
	}

	@Override
	public boolean onBlockStartBreak(
			ItemStack itemstack, 
			BlockPos pos, 
			EntityPlayer player) {
		return super.onBlockStartBreak(itemstack, pos, player);
	}

	@Override
	public void onUsingTick(
			ItemStack stack, 
			EntityLivingBase player, 
			int count) {
		super.onUsingTick(stack, player, count);
	}

	@Override
	public boolean onLeftClickEntity(
			ItemStack stack, 
			EntityPlayer player, 
			Entity entity) {
		return super.onLeftClickEntity(stack, player, entity);
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		return super.onEntityItemUpdate(entityItem);
	}

	@Override
	public void onArmorTick(
			World world, 
			EntityPlayer player, 
			ItemStack itemStack) {
		super.onArmorTick(world, player, itemStack);
	}

	@Override
	public boolean onEntitySwing(
			EntityLivingBase entityLiving, 
			ItemStack stack) {
		return super.onEntitySwing(entityLiving, stack);
	}

	@Override
	public void onHorseArmorTick(
			World world, 
			EntityLiving horse, 
			ItemStack armor) {
		super.onHorseArmorTick(world, horse, armor);
	}
	
	
	
}
