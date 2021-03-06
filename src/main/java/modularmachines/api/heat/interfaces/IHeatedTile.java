/**
* This file is created by wasliebob.
* Created on: 3 aug. 2014, at 14:56:22
* This file is part of Modular Machines (created by wasliebob)
*/
package modularmachines.api.heat.interfaces;

public interface IHeatedTile {
	public void addHeat(IHeatTransport te, int heat);
	public int getHeat(IHeatTransport te);
	public int getMaxHeat(IHeatTransport te);
	public boolean isFull(IHeatTransport te, int heat, int maxHeat);
	public boolean canReceive(IHeatTransport te, int heat);
	public int calculateSending(IHeatTransport te);
	public int calculateSending(IHeatedMachine te);
}