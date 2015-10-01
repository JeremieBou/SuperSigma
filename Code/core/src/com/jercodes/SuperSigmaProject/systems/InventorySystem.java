package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jercodes.SuperSigmaProject.components.life.InventoryComponent;
import com.jercodes.SuperSigmaProject.components.tools.BalisticComponent;
import com.jercodes.SuperSigmaProject.components.tools.ToolComponent;
import com.jercodes.api.Listener;
import com.jercodes.api.Signal;

public class InventorySystem extends EntityProcessingSystem {
	
	private Signal<ActionPacket> controllerSystemSignal;
	
	@SuppressWarnings("unchecked")
	public InventorySystem(Listener<ActionPacket> controllerListener) {
		super(Aspect.all(InventoryComponent.class));
		
		controllerSystemSignal = new Signal<ActionPacket>();
		controllerSystemSignal.add(controllerListener);
	}

	@Override
	protected void process(Entity entity) {
		Entity tool = this.world.getMapper(InventoryComponent.class).get(entity).getEquiped();
	
		if(this.world.getMapper(ToolComponent.class).get(tool).isUsingPrimary()){
			if(this.world.getMapper(BalisticComponent.class).has(tool)){
				if(!this.world.getMapper(BalisticComponent.class).get(tool).isSemiAutomatic()){
					controllerSystemSignal.dispatch(new ActionPacket(ActionPacket.Action.HANDHELD_MAIN, entity));
				}
			}
		}
		
	}

}
