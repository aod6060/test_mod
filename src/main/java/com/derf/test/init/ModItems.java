package com.derf.test.init;

import java.util.Arrays;
import java.util.List;

import com.derf.test.Loader;
import com.derf.test.item.ModItem;
import com.derf.test.item.ModItemAxe;
import com.derf.test.item.ModItemHoe;
import com.derf.test.item.ModItemPickaxe;
import com.derf.test.item.ModItemSpade;
import com.derf.test.item.ModItemSword;
import com.derf.test.item.ModItemTestEvents;
import com.derf.test.item.ModToolMaterials;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Loader.modid)
public class ModItems 
{
	// Crystal
	public static final ModItem CRYSTAL = null;
	// Burnt Crystal
	public static final ModItem BURNT_CRYSTAL = null;
	// Burnt Crystal Pickaxe
	public static final ModItemPickaxe BURNT_CRYSTAL_PICKAXE = null;
	// Burnt Crystal Spade
	public static final ModItemSpade BURNT_CRYSTAL_SPADE = null;
	// Burnt Crystal Axe
	public static final ModItemAxe BURNT_CRYSTAL_AXE = null;
	// Burnt Crystal Hoe
	public static final ModItemHoe BURNT_CRYSTAL_HOE = null;
	// Burnt Crystal Sword
	public static final ModItemSword BURNT_CRYSTAL_SWORD = null;
	// Item Test Events
	public static final ModItemTestEvents ITEM_TEST_EVENTS = null;
	
	public static List<Item> getItems()
	{
		return Arrays.asList(
				CRYSTAL,
				BURNT_CRYSTAL,
				BURNT_CRYSTAL_PICKAXE,
				BURNT_CRYSTAL_SPADE,
				BURNT_CRYSTAL_AXE,
				BURNT_CRYSTAL_HOE,
				BURNT_CRYSTAL_SWORD,
				ITEM_TEST_EVENTS
		);
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> e)
		{
			final Item[] items = {
					new ModItem("crystal"),
					new ModItem("burnt_crystal"),
					new ModItemPickaxe("burnt_crystal_pickaxe", ModToolMaterials.BURNT_TOOL_MATERIAL),
					new ModItemSpade("burnt_crystal_spade", ModToolMaterials.BURNT_TOOL_MATERIAL),
					new ModItemAxe("burnt_crystal_axe", ModToolMaterials.BURNT_TOOL_MATERIAL, 20.0f, 20.0f),
					new ModItemHoe("burnt_crystal_hoe", ModToolMaterials.BURNT_TOOL_MATERIAL),
					new ModItemSword("burnt_crystal_sword", ModToolMaterials.BURNT_TOOL_MATERIAL),
					new ModItemTestEvents()
			};
			
			final IForgeRegistry<Item> registry = e.getRegistry();
			
			Arrays.asList(items).forEach(i -> registry.register(i));
		}
	}
}
