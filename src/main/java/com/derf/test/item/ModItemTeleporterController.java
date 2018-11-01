package com.derf.test.item;

import com.derf.test.util.TextCompFactory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModItemTeleporterController extends ModItem {

	enum TeleporterControllerModes
	{
		TCM_STATUS,
		TCM_CHANGE_SLOT,
		TCM_SET_TELEPORT,
		TCM_TELEPORT
	};
	
	private int teleportSlotSize = 8;
	
	public ModItemTeleporterController() {
		super("teleporter_controller");
		this.setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(
			EntityPlayer player, 
			World world, 
			BlockPos pos, 
			EnumHand hand,
			EnumFacing facing, 
			float hitX, 
			float hitY, 
			float hitZ) {
		
		if(!world.isRemote)
		{
			ItemStack stack = player.getHeldItem(hand);
			
			this.configureStackNBT(stack);
			
			stack.getTagCompound().setBoolean("use", true);
			
			if(player.isSneaking())
			{
				//player.sendMessage(TextCompFactory.createTCS("OnItemUse: Sneaking"));
			}
			else
			{
				//player.sendMessage(TextCompFactory.createTCS("OnItemUse: Standing"));
			}
			
			return EnumActionResult.SUCCESS;
		}
		
		
		return super.onItemUse(player, world, pos, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(
			World world,
			EntityPlayer player, 
			EnumHand hand) {
		
		if(!world.isRemote)
		{
			ItemStack stack = player.getHeldItem(hand);
			
			this.configureStackNBT(stack);
			
			if(!stack.getTagCompound().getBoolean("use"))
			{
				if(player.isSneaking())
				{
					//player.sendMessage(TextCompFactory.createTCS("OnItemRightClick: Sneaking"));
				}
				else
				{
					//player.sendMessage(TextCompFactory.createTCS("OnItemRightClick: Standing"));
				}
			}
			
			stack.getTagCompound().setBoolean("use", false);
		}

		return super.onItemRightClick(world, player, hand);
	}

	private void configureStackNBT(ItemStack stack)
	{
		if(!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		
		if(!stack.getTagCompound().hasKey("use"))
		{
			stack.getTagCompound().setBoolean("use", false);
		}
		
		if(!stack.getTagCompound().hasKey("tl"))
		{
			NBTTagCompound tl = new NBTTagCompound();
			tl.setInteger("index", 0);
			
			NBTTagList list = new NBTTagList();
			
			for(int i = 0; i < this.teleportSlotSize; i++)
			{
				NBTTagCompound slot = new NBTTagCompound();
				slot.setInteger("x", Integer.MIN_VALUE);
				slot.setInteger("y", Integer.MIN_VALUE);
				slot.setInteger("z", Integer.MIN_VALUE);
				list.appendTag(slot);
			}
			
			tl.setTag("list", list);
			
			stack.getTagCompound().setTag("tl", tl);
		}
	}
	
}
