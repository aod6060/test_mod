package com.derf.test.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockOre extends ModBlock {

	private Item drop = null;
	private int expMin = 0;
	private int expMax = 0;
	
	public ModBlockOre(String name, int expMin, int expMax) {
		super(name, Material.ROCK);
		this.expMin = expMin;
		this.expMax = expMax;
	}
	
	public void setDrop(Item item)
	{
		this.drop = item;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.drop;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return this.expMin + random.nextInt(this.expMax - this.expMin);
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		//return super.getExpDrop(state, world, pos, fortune);
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		return MathHelper.getInt(rand, this.expMin, this.expMax);
	}
	
}
