package com.derf.test.item;

import java.util.Objects;

import com.derf.test.Loader;
import com.derf.test.init.ModCreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ModItem extends Item 
{
	public ModItem(final String name)
	{
		setItemName(this, name);
		ModCreativeTabs.add(this);
	}
	
	/**
	 * Set the registry name {@code item} to {@code name} and the unlocalized name.
	 * 
	 * @param item the item
	 * @param name the item's name
	 */
	public static void setItemName(final Item item, final String name)
	{
		item.setRegistryName(Loader.modid, name);
		final ResourceLocation registryName = Objects.requireNonNull(item.getRegistryName());
		item.setUnlocalizedName(registryName.toString());
	}
	
}
