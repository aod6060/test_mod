package com.derf.test.block;

import java.util.Objects;

import com.derf.test.Loader;
import com.derf.test.init.ModCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class ModBlock extends Block {

	public ModBlock(String name, Material material, MapColor mapColor) {
		super(material, mapColor);
		setBlockName(this, name);
		ModCreativeTabs.add(this);
		
		this.setHardness(1.0f);
		this.setResistance(1.0f);
	}

	public ModBlock(String name, Material material)
	{
		this(name, material, material.getMaterialMapColor());
	}
	
	/**
	 * Set the registry name of {@code block} to {@code name} and the translation key to the full registry name.
	 * @param block The Block
	 * @param name The Block's Name
	 */
	public static void setBlockName(final Block block, final String name)
	{
		block.setRegistryName(Loader.modid, name);
		final ResourceLocation registryName = Objects.requireNonNull(block.getRegistryName());
		block.setUnlocalizedName(registryName.toString());
	}
}
