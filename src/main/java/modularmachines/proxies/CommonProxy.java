/**
* This file is created by wasliebob.
* Created on: 3 aug. 2014, at 14:56:22
* This file is part of Modular Machines (created by wasliebob)
*/
package modularmachines.proxies;

import net.minecraft.world.World;

public class CommonProxy{
	public void load(){
		registerPackets();
        registerParticles();
        render();
        bindKeys();
	}
	
	public void registerPackets(){

	}
	
    public void registerParticles(){}
	public void render(){}
	public void spawnParticle(World world, String particle, int minX, int minY, int minZ, int maxX, int maxY, int maxZ){}
	public void spawnSound(World worldObj, int xCoord, int yCoord, int zCoord, String id){}
	public void bindKeys(){}
	
	public boolean renderView(){
		return false;
	}
}