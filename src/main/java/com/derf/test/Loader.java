package com.derf.test;

import com.derf.test.proxy.IProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Loader.modid, name=Loader.name, version=Loader.version)
public class Loader 
{
	public static final String modid = "test";
	public static final String name = "Test";
	public static final String version = "1.0";
	
	@Instance(Loader.modid)
	public static Loader instance;
	
	@SidedProxy(clientSide="com.derf.test.proxy.ProxyClient", serverSide="com.derf.test.proxy.ProxyCommon")
	public static IProxy proxy;
	
	@EventHandler
	
	public void preInit(FMLPreInitializationEvent e)
	{
		Logger.create(e.getModLog());
		proxy.preInit(e);
		Logger.getLogger().info("PreInit: Test");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
		Logger.getLogger().info("Init: Test");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
		Logger.getLogger().info("PostInit: Test");
	}
}
