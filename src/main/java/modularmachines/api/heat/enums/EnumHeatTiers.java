/**
* This file is created by wasliebob.
* Created on: 3 aug. 2014, at 14:56:22
* This file is part of Modular Machines (created by wasliebob)
*/
package modularmachines.api.heat.enums;

public enum EnumHeatTiers {
	T1(100), T2(250), T3(500), T4(750), T5(1000), CREATIVE(1000000000);
	private int value;
	
    private EnumHeatTiers(int heat) {
        this.setValue(heat);
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}