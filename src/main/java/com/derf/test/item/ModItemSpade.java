package com.derf.test.item;

import java.util.Objects;

import com.derf.test.Loader;
import com.derf.test.init.ModCreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;

public class ModItemSpade extends ItemSpade {

	public ModItemSpade(String name, ToolMaterial material) {
		super(material);
		ModItem.setItemName(this, name);
		ModCreativeTabs.add(this);
	}

}
