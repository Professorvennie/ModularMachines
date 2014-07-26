package modularmachines.items;

import modularmachines.api.classes.TileInteracting;
import modularmachines.api.guide.IGuided;
import modularmachines.api.main.MMInteractingUpgrades;
import modularmachines.api.upgrades.IInteractingAction;
import modularmachines.blocks.guis.guide.GuiEntry;
import modularmachines.main.MM;
import modularmachines.main.init.MMTabs;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import wasliecore.helpers.Utils;
import cpw.mods.fml.common.registry.GameRegistry;

public class MMItemGuide extends Item{
	public MMItemGuide() {
		setMaxStackSize(1);
		setUnlocalizedName(MM.modName.toLowerCase() + "." + "item" + "." + "guide");
		setCreativeTab(MMTabs.tabMain);
		GameRegistry.registerItem(this, this.getUnlocalizedName());
	}

	@Override
    public void registerIcons(IIconRegister ir){
        itemIcon = ir.registerIcon(MM.modName.toLowerCase() + ":" + "guide");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(!player.isSneaking()){
			player.openGui(MM.instance, 3, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		}else{
			Block block = Utils.getTargetBlock(player);
			if(block != null && block instanceof IGuided){
				TileEntity te = Utils.getTargetTile(player);
				IGuided guided = (IGuided)block;
				if(te != null && te instanceof TileInteracting){
					TileInteracting ti = (TileInteracting)te;
					ForgeDirection dir = ForgeDirection.getOrientation(Utils.getTargetBlockSide(player));
					if(dir == ti.upgradeSide){
						IInteractingAction action = MMInteractingUpgrades.getUpgrade(ti.upgrade).action;
						if(action != null && action instanceof IGuided){
							String key = ((IGuided)action).getKey();
							if(key != null){
								Minecraft.getMinecraft().displayGuiScreen(new GuiEntry(key, player, 0));
							}else{
								openGuide(guided, player);
							}
						}else{
							openGuide(guided, player);
						}
					}else{
						openGuide(guided, player);
					}
				}else{
					openGuide(guided, player);
				}
			}
		}
		return stack;
    }
	
	public void openGuide(IGuided guided, EntityPlayer player){
		if(guided.getKey() != null)
			Minecraft.getMinecraft().displayGuiScreen(new GuiEntry(guided.getKey(), player, 0));
	}
}