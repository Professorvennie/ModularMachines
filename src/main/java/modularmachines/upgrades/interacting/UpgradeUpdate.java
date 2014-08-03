/**
* This file is created by wasliebob.
* Created on: 3 aug. 2014, at 14:56:22
* This file is part of Modular Machines (created by wasliebob)
*/
package modularmachines.upgrades.interacting;

import modularmachines.api.classes.TileInteracting;
import modularmachines.api.guide.IGuided;
import modularmachines.api.misc.helpers.DirectionHelper;
import modularmachines.api.upgrades.IInteractingAction;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wasliecore.helpers.MathHelper;

public class UpgradeUpdate implements IInteractingAction, IGuided{
	public UpgradeUpdate(){
		time = MathHelper.secondToTick(1);
	}
	public int time;
	
	@Override
	public void onUpdate(TileInteracting ti) {
		if(time > 0)
			time--;
	
		if(time <= 0){
			doStuff(ti);
			time = MathHelper.secondToTick(1);
		}
	}
	
	public void doStuff(TileInteracting ti){
		World world = ti.getWorldObj();
		int x = ti.xCoord;
		int y = ti.yCoord;
		int z = ti.zCoord;
		Block oBlock = DirectionHelper.getBlock(world, x, y, z, ti.output);
		if(oBlock != null && oBlock != Blocks.air){
			int oX = DirectionHelper.getX(x, ti.output);
			int oY = DirectionHelper.getY(y, ti.output);;
			int oZ = DirectionHelper.getZ(z, ti.output);;
			world.markBlockForUpdate(oX, oY, oZ);
		}
	}

	@Override
	public void onActivate(TileInteracting ti, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActivateClick(TileInteracting ti, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActivateWithItem(TileInteracting ti, ItemStack held,
			EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActivateWithProgrammer(TileInteracting ti, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increaseHeat(TileInteracting ti, int heat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseHeat(TileInteracting ti, int heat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasRequired(TileInteracting ti) {
		return ti.output != null;
	}
	
	@Override
	public String getKey() {
		return "Upgrade: Update";
	}
}