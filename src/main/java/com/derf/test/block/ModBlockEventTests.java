package com.derf.test.block;

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
		
		super.onBlockDestroyedByPlayer(world, pos, state);
	}

	@Override
	public void onBlockAdded(
			World world, 
			BlockPos pos, 
			IBlockState state) {
		super.onBlockAdded(world, pos, state);
	}

	@Override
	public void onBlockDestroyedByExplosion(
			World world, 
			BlockPos pos, 
			Explosion explosionIn) {
		super.onBlockDestroyedByExplosion(world, pos, explosionIn);
	}

	@Override
	public boolean onBlockActivated(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			EntityPlayer playerIn,
			EnumHand hand, 
			EnumFacing facing, 
			float hitX, 
			float hitY, 
			float hitZ) {
		return super.onBlockActivated(world, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public void onEntityWalk(
			World world, 
			BlockPos pos, 
			Entity entityIn) {
		super.onEntityWalk(world, pos, entityIn);
	}

	@Override
	public void onBlockClicked(
			World world, 
			BlockPos pos, 
			EntityPlayer playerIn) {
		super.onBlockClicked(world, pos, playerIn);
	}

	@Override
	public void onEntityCollidedWithBlock(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			Entity entityIn) {
		super.onEntityCollidedWithBlock(world, pos, state, entityIn);
	}

	@Override
	public void onBlockPlacedBy(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			EntityLivingBase placer,
			ItemStack stack) {
		super.onBlockPlacedBy(world, pos, state, placer, stack);
	}

	@Override
	public void onFallenUpon(
			World world, 
			BlockPos pos, 
			Entity entityIn, 
			float fallDistance) {
		super.onFallenUpon(world, pos, entityIn, fallDistance);
	}

	@Override
	public void onLanded(
			World world, 
			Entity entityIn) {
		super.onLanded(world, entityIn);
	}

	@Override
	public void onBlockHarvested(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			EntityPlayer player) {
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
		super.onNeighborChange(world, pos, neighbor);
	}

	
	
}
