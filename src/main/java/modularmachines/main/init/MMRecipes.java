package modularmachines.main.init;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;

import modularmachines.api.main.MMApi;
import modularmachines.api.misc.InteractingUpgrade;
import modularmachines.api.misc.Upgrade;
import modularmachines.api.recipes.MMMaceratorRecipe;
import modularmachines.upgrades.base.UpgradeCharger;
import modularmachines.upgrades.base.UpgradeFurnace;
import modularmachines.upgrades.base.UpgradeMacerator;
import modularmachines.upgrades.interacting.UpgradeBreak;
import modularmachines.upgrades.interacting.UpgradeElevator;
import modularmachines.upgrades.interacting.UpgradeFertilize;
import modularmachines.upgrades.interacting.UpgradePlace;
import modularmachines.upgrades.interacting.UpgradeTransfer;
import modularmachines.upgrades.interacting.UpgradeVacuum;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import wasliecore.interfaces.IInitalization;

public class MMRecipes implements IInitalization{
	@Override
	public void preInit(){
	}
	
	@Override
	public void init(){}

	@Override
	public void postInit(){
		initCraftingRecipes();
		initFuels();
		initFluidFuels();
		initMaceratorRecipes();
		initUpgrades();
		initInteractingUpgrades();
	}
	
	public void initCraftingRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(MMBlocks.core_machine), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.gold_ingot,
			'Y', Items.redstone,
			'I', Blocks.iron_block});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMBlocks.core_interacting), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.gold_ingot,
			'Y', Items.redstone,
			'I', MMBlocks.core_machine});
		
		
		GameRegistry.addShapedRecipe(new ItemStack(MMBlocks.router), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Items.coal,
			'I', Blocks.redstone_block});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMBlocks.heater_fluid), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.lava_bucket,
			'Y', Items.diamond,
			'I', MMBlocks.router});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMBlocks.tank_potion), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.glass_bottle,
			'Y', Blocks.glass,
			'I', Items.diamond});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.input), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Items.redstone,
			'I', Items.gold_ingot});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.output), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.redstone,
			'Y', Items.iron_ingot,
			'I', Items.gold_ingot});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.screen), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.gold_ingot,
			'Y', Items.iron_ingot,
			'I', Blocks.glass});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.upgrade_furnace), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Items.redstone,
			'I', Blocks.coal_block});

		GameRegistry.addShapedRecipe(new ItemStack(MMItems.upgrade_charger), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Items.gold_ingot,
			'I', Blocks.redstone_block});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.wrench), new Object[]{
			"X X",
			"XYX",
			" X ",
			'X', Items.iron_ingot,
			'Y', Items.diamond});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.programmer), new Object[]{
			"XXX",
			"XYX",
			"XXX",
			'X', Items.iron_ingot,
			'Y', Blocks.glass});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.interacting_break), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Blocks.piston,
			'I', Blocks.redstone_block});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.interacting_elevator), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Blocks.piston,
			'I', Items.ender_pearl});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.interacting_fertilize), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Items.diamond,
			'I', new ItemStack(Items.dye, 1, 14)});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.interacting_place), new Object[]{
			"XYX",
			"YIY",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Blocks.piston,
			'I', Items.diamond});
		
		GameRegistry.addShapedRecipe(new ItemStack(MMItems.interacting_transfer), new Object[]{
			"XYX",
			"WIW",
			"XYX",
			'X', Items.iron_ingot,
			'Y', Items.ender_pearl,
			'W', Blocks.stone,
			'I', Items.diamond});
		
//		GameRegistry.addShapedRecipe(new ItemStack(MMItems.interacting_vacuum), new Object[]{
//			"XYX",
//			"WIW",
//			"XYX",
//			'X', Items.iron_ingot,
//			'Y', Items.ender_pearl,
//			'W', Items.gold_ingot,
//			'I', Blocks.hopper});
	}
	
	public void initMaceratorRecipes(){
		ArrayList<ItemStack> output;
		output = OreDictionary.getOres("dustIron");
		if(output != null && output.size() > 0){
			MMMaceratorRecipe.addRecipe(Items.iron_ingot, output.get(0));
			MMMaceratorRecipe.addRecipe(Item.getItemFromBlock(Blocks.iron_ore), new ItemStack(output.get(0).getItem(), 1, output.get(0).getItemDamage()));
		}
		
		output = OreDictionary.getOres("dustGold");
		if(output != null && output.size() > 0){
			MMMaceratorRecipe.addRecipe(Items.gold_ingot, output.get(0));
			MMMaceratorRecipe.addRecipe(Item.getItemFromBlock(Blocks.gold_ore), new ItemStack(output.get(0).getItem(), 1, output.get(0).getItemDamage()));
		}
		
		output = OreDictionary.getOres("dustDiamond");
		if(output != null && output.size() > 0){
			MMMaceratorRecipe.addRecipe(Items.diamond, output.get(0));
			MMMaceratorRecipe.addRecipe(Item.getItemFromBlock(Blocks.diamond_ore), new ItemStack(output.get(0).getItem(), 1, output.get(0).getItemDamage()));
		}
		
		output = OreDictionary.getOres("dustCoal");
		if(output != null && output.size() > 0){
			MMMaceratorRecipe.addRecipe(Items.coal, output.get(0));
			MMMaceratorRecipe.addRecipe(Item.getItemFromBlock(Blocks.coal_ore), new ItemStack(output.get(0).getItem(), 1, output.get(0).getItemDamage()));
		}
	}
	
	public void initFluidFuels(){
		MMApi.addHeatFuel(Blocks.lava, 10);
	}
	
	public void initFuels(){
		MMApi.addFuel(Items.coal, 10);
		MMApi.addFuel(Item.getItemFromBlock(Blocks.log), 5);
		MMApi.addFuel(Item.getItemFromBlock(Blocks.coal_block), 10*9);
	}
	
	public void initUpgrades(){
		MMApi.addUpgrade(MMItems.upgrade_furnace, new Upgrade(new UpgradeFurnace(10)));
		MMApi.addUpgrade(MMItems.upgrade_macerator, new Upgrade(new UpgradeMacerator(10)));
		MMApi.addUpgrade(MMItems.upgrade_charger, new Upgrade(new UpgradeCharger(10)));
	}
	
	public void initInteractingUpgrades(){
		MMApi.addInteractingUpgrade(MMItems.interacting_transfer, new InteractingUpgrade(new UpgradeTransfer()));
		MMApi.addInteractingUpgrade(MMItems.interacting_break, new InteractingUpgrade(new UpgradeBreak()));
		MMApi.addInteractingUpgrade(MMItems.interacting_vacuum, new InteractingUpgrade(new UpgradeVacuum()));
		MMApi.addInteractingUpgrade(MMItems.interacting_place, new InteractingUpgrade(new UpgradePlace()));
		MMApi.addInteractingUpgrade(MMItems.interacting_fertilize, new InteractingUpgrade(new UpgradeFertilize()));
		MMApi.addInteractingUpgrade(MMItems.interacting_elevator, new InteractingUpgrade(new UpgradeElevator()));
	}
}