/**
* This file is created by wasliebob.
* Created on: 3 aug. 2014, at 14:56:22
* This file is part of Modular Machines (created by wasliebob)
*/
package modularmachines.events;

import modularmachines.blocks.guis.GuiWarningScreen;
import modularmachines.main.MM;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MMEventStartup {    
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void displayWarning(GuiOpenEvent e){
		if(e.gui instanceof GuiMainMenu && MM.isUnstable){
            e.gui = new GuiWarningScreen(e.gui);
            MinecraftForge.EVENT_BUS.unregister(this);
		}
	}
}