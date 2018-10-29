package com.derf.test.util;

import net.minecraft.util.text.TextComponentString;

public class TextCompFactory {
	
	public static TextComponentString createTCS(String msg)
	{
		return new TextComponentString(msg);
	}
}
