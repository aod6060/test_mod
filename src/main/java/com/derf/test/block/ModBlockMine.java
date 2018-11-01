package com.derf.test.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ModBlockMine extends ModBlock {

	private float strength = 2.0f;
	private boolean isSmoking = true;
	
	public ModBlockMine() {
		super("mine", Material.ROCK);
	}

	@Override
	public void onBlockDestroyedByPlayer(
			World world, 
			BlockPos pos, 
			IBlockState state) {
		super.onBlockDestroyedByPlayer(world, pos, state);
		
		this.explode(world, pos);
	}

	@Override
	public void onBlockDestroyedByExplosion(
			World world, 
			BlockPos pos, 
			Explosion explosionIn) {
		super.onBlockDestroyedByExplosion(world, pos, explosionIn);
		this.explode(world, pos);
	}

	@Override
	public void onEntityWalk(
			World world, 
			BlockPos pos, 
			Entity entityIn) {
		super.onEntityWalk(world, pos, entityIn);
		this.explode(world, pos);
	}

	@Override
	public void onEntityCollidedWithBlock(
			World world, 
			BlockPos pos, 
			IBlockState state, 
			Entity entityIn) {
		super.onEntityCollidedWithBlock(world, pos, state, entityIn);
		this.explode(world, pos);
	}

	@Override
	public void onFallenUpon(
			World world, 
			BlockPos pos, 
			Entity entityIn, 
			float fallDistance) {
		super.onFallenUpon(world, pos, entityIn, fallDistance);
		this.explode(world, pos);
	}

	private void explode(World world, BlockPos pos)
	{
		if(!world.isRemote)
		{
			world.createExplosion(
					null, 
					pos.getX(), 
					pos.getY(), 
					pos.getZ(), 
					this.strength, 
					this.isSmoking);
		}
	}
}
