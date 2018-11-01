package com.derf.test.block;

import com.derf.test.Logger;
import com.derf.test.util.TextCompFactory;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockEventTests extends ModBlock {

	public ModBlockEventTests() {
		super("block_event_tests", Material.ROCK);
	}

	@Override
	public void onBlockDestroyedByPlayer(
			World world, 
			BlockPos pos, 
			IBlockState state) {
		if(!world.isRemote)
		{
			Logger.getLogger().info("OnBlockDestroyByPlayer: " + pos);
		}
		super.onBlockDestroyedByPlayer(world, pos, state);
	}

	@Override
	public void onBlockAdded(
			World world, 
			BlockPos pos, 
			IBlockState state) {
		
		if(!world.isRemote)
		{
			Logger.getLogger().info("OnBlockAdded: " + pos);
		}
		super.onBlockAdded(world, pos, state);
	}

	@Override
	public void onBlockDestroyedByExplosion(
			World world, 
			BlockPos pos, 
			Explosion explosionIn) {
		
		if(!world.isRemote)
		{
			Logger.getLogger().info("OnBlockDestroyedByExplosion: " + pos);
		}
		super.onBlockDestroyedByExplosion(world, pos, explosionIn);
	}

	@Override
	public boolean onBlockActivated(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			EntityPlayer player,
			EnumHand hand, 
			EnumFacing facing, 
			float hitX, 
			float hitY, 
			float hitZ) {
		
		if(!world.isRemote)
		{
			player.sendMessage(TextCompFactory.createTCS("OnBlockActivated: " + pos));
			Logger.getLogger().info("OnBlockActivated: " + pos);
		}
		return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public void onEntityWalk(
			World world, 
			BlockPos pos, 
			Entity entity) {
		
		if(!world.isRemote)
		{
			entity.sendMessage(TextCompFactory.createTCS("OnEntityWalk: " + pos));
			Logger.getLogger().info("OnEntityWalk: " + pos);
		}
		super.onEntityWalk(world, pos, entity);
	}

	@Override
	public void onBlockClicked(
			World world, 
			BlockPos pos, 
			EntityPlayer player) {
		
		if(!world.isRemote)
		{
			player.sendMessage(TextCompFactory.createTCS("OnBlockClicked: " + pos));
			Logger.getLogger().info("OnBlockClicked: " + pos);
		}
		super.onBlockClicked(world, pos, player);
	}

	@Override
	public void onEntityCollidedWithBlock(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			Entity entity) {
		
		if(!world.isRemote)
		{
			entity.sendMessage(TextCompFactory.createTCS("OnEntityCollidedWithBlock: " + pos));
			Logger.getLogger().info("OnEntityCollidedWithBlock: " + pos);
		}
		super.onEntityCollidedWithBlock(world, pos, state, entity);
	}

	@Override
	public void onBlockPlacedBy(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			EntityLivingBase placer,
			ItemStack stack) {
		if(!world.isRemote)
		{
			placer.sendMessage(TextCompFactory.createTCS("OnBlockPlacedBy: " + pos));
			Logger.getLogger().info("OnBlockPlacedBy: " + pos);
		}
		super.onBlockPlacedBy(world, pos, state, placer, stack);
	}

	@Override
	public void onFallenUpon(
			World world, 
			BlockPos pos, 
			Entity entity, 
			float fallDistance) {
		if(!world.isRemote)
		{
			entity.sendMessage(TextCompFactory.createTCS("OnFallenUpon: " + pos));
			Logger.getLogger().info("OnFallenUpon: " + pos);
		}
		super.onFallenUpon(world, pos, entity, fallDistance);
	}

	@Override
	public void onLanded(
			World world, 
			Entity entity) {
		if(!world.isRemote)
		{
			entity.sendMessage(TextCompFactory.createTCS("OnLanded: "));
			Logger.getLogger().info("OnLanded: ");
		}
		super.onLanded(world, entity);
	}

	@Override
	public void onBlockHarvested(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			EntityPlayer player) {
		
		if(!world.isRemote)
		{
			player.sendMessage(TextCompFactory.createTCS("OnBlockHarvested: " + pos));
			Logger.getLogger().info("OnBlockHarvested: " + pos);
		}
		super.onBlockHarvested(world, pos, state, player);
	}

	@Override
	public void onBlockExploded(
			World world, 
			BlockPos pos, 
			Explosion explosion) {
		super.onBlockExploded(world, pos, explosion);
	}

	@Override
	public void onPlantGrow(
			IBlockState state, 
			World world, 
			BlockPos pos, 
			BlockPos source) {
		super.onPlantGrow(state, world, pos, source);
	}

	@Override
	public void onNeighborChange(
			IBlockAccess world, 
			BlockPos pos, 
			BlockPos neighbor) {
		
		Logger.getLogger().info("OnNeighborChange: pos=" + pos + ", neighbor=" + neighbor);
		
		super.onNeighborChange(world, pos, neighbor);
	}

	
	
}
