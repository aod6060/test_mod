package com.derf.test.item;

import java.util.Objects;

import com.derf.test.Loader;
import com.derf.test.init.ModCreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.util.ResourceLocation;

public class ModItemPickaxe extends ItemPickaxe {

	public ModItemPickaxe(String name, ToolMaterial material) {
		super(material);
		ModItem.setItemName(this, name);
		ModCreativeTabs.add(this);
	}
}
