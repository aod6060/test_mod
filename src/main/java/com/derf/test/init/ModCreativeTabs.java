package com.derf.test.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModCreativeTabs {
	
	public static CreativeTabs creativeTabs = null;
	
	private static List<Item> items = new ArrayList<>();
	private static List<Block> blocks = new ArrayList<>();
	
	public static void add(Item item)
	{
		items.add(item);
	}
	
	public static void add(Block block)
	{
		blocks.add(block);
	}
	
	public static void create()
	{
		creativeTabs = new CreativeTabs("mod_tab") {
			@Override
			public ItemStack getTabIconItem() {
				// TODO Auto-generated method stub
				return new ItemStack(ModItems.CRYSTAL);
			}
			
		};
	}
	
	public static void register()
	{
		items.forEach(i -> i.setCreativeTab(creativeTabs));
		blocks.forEach(b -> b.setCreativeTab(creativeTabs));
	}
}
