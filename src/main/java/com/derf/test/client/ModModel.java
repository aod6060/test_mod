package com.derf.test.client;

import java.util.ArrayList;
import java.util.List;

import com.derf.test.Loader;
import com.derf.test.init.ModBlocks;
import com.derf.test.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import scala.actors.threadpool.Arrays;

@Mod.EventBusSubscriber(value=Side.CLIENT, modid=Loader.modid)
public class ModModel {
	
	public static ModModel INSTANCE = new ModModel();
	
	private ModModel() {}
	
	@SubscribeEvent
	public static void registerAllModels(final ModelRegistryEvent e)
	{
		INSTANCE.registerBlockModels();
		INSTANCE.registerItemModels();
	}

	private void registerBlockModels() {
		ModBlocks.getBlocks().forEach(i -> regRender(i, i.getRegistryName().toString()));
	}

	private void registerItemModels() 
	{
		ModItems.getItems().forEach(i -> regRender(i, i.getRegistryName().toString()));
	}
	
	private void regRender(Item item, int meta, String name)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, "inventory"));
	}
	
	private void regRender(Item item, String name)
	{
		regRender(item, 0, name);
	}
	
	private void regRender(Block block, int meta, String name)
	{
		regRender(Item.getItemFromBlock(block), meta, name);
	}
	
	private void regRender(Block block, String name)
	{
		regRender(block, 0, name);
	}
}
