package com.derf.test.block;

import com.derf.test.tileentity.ModTileEntityTestTileEntity;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockTestTileEntity extends ModBlockContainer {

	public ModBlockTestTileEntity() {
		super("test_tile_entity", Material.ROCK);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new ModTileEntityTestTileEntity();
	}

}
