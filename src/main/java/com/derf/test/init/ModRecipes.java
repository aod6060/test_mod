package com.derf.test.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void registerRecipes()
	{
		addSmeltingReciples();
	}

	private static void addSmeltingReciples() {
		// Crystal to Burnt Crystal
		addSmelting(ModItems.CRYSTAL, new ItemStack(ModItems.BURNT_CRYSTAL), 0.35f);
		// Crystal Block to Burnt Crystal Block
		addSmelting(ModBlocks.CRYSTAL_BLOCK, new ItemStack(ModBlocks.BURNT_CRYSTAL_BLOCK), 1.0f);
	}
	
	
	private static void addSmelting(ItemStack input, ItemStack output, float xp)
	{
		GameRegistry.addSmelting(input, output, xp);
	}
	
	private static void addSmelting(Item item, ItemStack output, float xp)
	{
		addSmelting(new ItemStack(item), output, xp);
	}
	
	private static void addSmelting(Block block, ItemStack output, float xp)
	{
		addSmelting(Item.getItemFromBlock(block), output, xp);
	}
}
