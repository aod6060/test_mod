package com.derf.test.proxy;

import com.derf.test.Logger;
import com.derf.test.init.ModBlocks;
import com.derf.test.init.ModCreativeTabs;
import com.derf.test.init.ModItems;
import com.derf.test.init.ModRecipes;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ProxyCommon implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) 
	{
		//System.out.println("Common Proxy Pre Init");
		Logger.getLogger().info("Common Proxy Pre Init");
	}

	@Override
	public void init(FMLInitializationEvent e) 
	{
		//System.out.println("Common Proxy Init");
		Logger.getLogger().info("Common Proxy Init");
		ModItems.initStage();
		ModBlocks.initStage();
		ModCreativeTabs.create();
		ModCreativeTabs.register();
		ModRecipes.registerRecipes();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) 
	{
		//System.out.println("Common Proxy Post Init");
		Logger.getLogger().info("Common Proxy Post Init");
	}

}
