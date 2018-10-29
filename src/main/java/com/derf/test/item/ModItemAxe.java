package com.derf.test.item;

import java.util.Objects;

import com.derf.test.Loader;
import com.derf.test.init.ModCreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.util.ResourceLocation;

public class ModItemAxe extends ItemAxe {

	public ModItemAxe(String name, ToolMaterial material, float damage, float speed) {
		super(material, damage, speed);
		ModItem.setItemName(this, name);
		ModCreativeTabs.add(this);
	}
	
}
