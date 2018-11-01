package com.derf.test.item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.derf.test.Logger;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ModItemPortableSpawner extends ModItem {
	
	private int spawnAmount = 100;
	
	public ModItemPortableSpawner() {
		super("portable_spawner");
		this.setMaxStackSize(16);
	}
	
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		
		if(!entity.world.isRemote)
		{
			NBTTagCompound tag = entity.serializeNBT();
			
			if(stack.getTagCompound() == null)
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			stack.getTagCompound().setTag("entity", tag);
			
		}
		return super.onLeftClickEntity(stack, player, entity);
	}


	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		World world = entityItem.world;
		
		if(entityItem.getAge() > 0)
		{
			entityItem.setNoDespawn();
		}
		
		if(!world.isRemote)
		{
			
			
			if(entityItem.getAge() % this.spawnAmount == 0)
			{
				if(entityItem.getItem().getTagCompound() != null && entityItem.getItem().getTagCompound().hasKey("entity")) {
					NBTTagCompound tag = entityItem.getItem().getTagCompound().getCompoundTag("entity");
					
					if(tag.hasKey("id"))
					{
						try {
							String id = tag.getString("id");
							Class<? extends Entity> entityClass = EntityList.getClassFromName(id);
							Constructor<? extends Entity> construct = entityClass.getConstructor(World.class);
							
							Entity entity = construct.newInstance(world);
							
							if(entity != null)
							{
								if(entity instanceof EntityAnimal)
								{
									EntityAnimal animal = (EntityAnimal)entity;
									animal.setGrowingAge(0);
									animal.setLocationAndAngles(entityItem.posX, entityItem.posY, entityItem.posZ, 0.0f, 0.0f);
									world.spawnEntity(animal);
								}
								else
								{
									entity.setLocationAndAngles(entityItem.posX, entityItem.posY, entityItem.posZ, 0, 0);
									world.spawnEntity(entity);
								}
							}
							
						} catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		return super.onEntityItemUpdate(entityItem);
	}
}
