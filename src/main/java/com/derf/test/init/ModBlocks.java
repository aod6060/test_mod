package com.derf.test.init;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.derf.test.Loader;
import com.derf.test.block.ModBlock;
import com.derf.test.block.ModBlockEventTests;
import com.derf.test.block.ModBlockOre;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Loader.modid)
public class ModBlocks 
{
	// Crystal Block
	public static final ModBlock CRYSTAL_BLOCK = null;
	// Crystal Ore
	public static final ModBlockOre CRYSTAL_ORE = null;
	// Burnt Crystal Block
	public static final ModBlock BURNT_CRYSTAL_BLOCK = null;
	// Block Event Tests
	public static final ModBlockEventTests BLOCK_EVENT_TESTS = null;
	
	public static List<Block> getBlocks()
	{
		return Arrays.asList(
				CRYSTAL_BLOCK,
				CRYSTAL_ORE,
				BURNT_CRYSTAL_BLOCK,
				BLOCK_EVENT_TESTS
		);
	}
	
	public static void initStage()
	{
		CRYSTAL_ORE.setDrop(ModItems.CRYSTAL);
	}
	
	@Mod.EventBusSubscriber(modid=Loader.modid)
	public static class RegistrationHandler
	{
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> e)
		{
			final IForgeRegistry<Block> registry = e.getRegistry();
			
			final Block[] blocks = {
					new ModBlock("crystal_block", Material.ROCK),
					new ModBlockOre("crystal_ore", 2, 5),
					new ModBlock("burnt_crystal_block", Material.ROCK),
					new ModBlockEventTests()
			};
			
			
			Arrays.asList(blocks).forEach(b -> registry.register(b));
			
			registerTileEntities();
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> e)
		{
			final IForgeRegistry<Item> registry = e.getRegistry();
			
			final ItemBlock[] items = {
					new ItemBlock(CRYSTAL_BLOCK),
					new ItemBlock(CRYSTAL_ORE),
					new ItemBlock(BURNT_CRYSTAL_BLOCK),
					new ItemBlock(BLOCK_EVENT_TESTS)
			};
			
			Arrays.asList(items).forEach(i -> {
				final Block block = i.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name.", block);
				registry.register(i.setRegistryName(registryName));
				ITEM_BLOCKS.add(i);
			});
		}
		
		private static void registerTileEntities() {
		}
	}
}
