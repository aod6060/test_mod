package com.derf.test.block;

import com.derf.test.init.ModCreativeTabs;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public abstract class ModBlockContainer extends BlockContainer {

	public ModBlockContainer(String name, Material materialIn, MapColor mapColor) {
		super(materialIn, mapColor);
		ModBlock.setBlockName(this, name);
		ModCreativeTabs.add(this);
		
		this.setHardness(1.0f);
		this.setResistance(1.0f);
	}
	
	public ModBlockContainer(String name, Material material)
	{
		this(name, material, material.getMaterialMapColor());
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	
}
