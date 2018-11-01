package com.derf.test.tileentity;

import com.derf.test.Logger;

import net.minecraft.util.ITickable;

public class ModTileEntityTestTileEntity extends ModTileEntity implements ITickable {
	@Override
	public void update() 
	{
		Logger.getLogger().info("Test Entity: " + pos);
	}
}
