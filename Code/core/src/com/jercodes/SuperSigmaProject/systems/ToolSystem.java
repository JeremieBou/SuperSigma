package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jercodes.SuperSigmaProject.components.TransformComponent;
import com.jercodes.SuperSigmaProject.components.life.InventoryComponent;
import com.jercodes.SuperSigmaProject.components.tools.BalisticComponent;
import com.jercodes.SuperSigmaProject.components.tools.MagazineComponent;
import com.jercodes.SuperSigmaProject.components.tools.ToolComponent;

/**
 * @author jeremeboudreau
 *
 */
public class ToolSystem extends EntityProcessingSystem{
	
	@SuppressWarnings("unchecked")
	public ToolSystem() {
		super(Aspect.all(ToolComponent.class));	
		
	}

		
	protected void process(Entity entity) {
		
	}
	
	
	
	
	/**
	 * @param entity The owner of the tool
	 */
	public void usePrimary(Entity entity){
		Entity tool = null;
		
		InventoryComponent ic = entity.getComponent(InventoryComponent.class);
		
		if(ic != null){
			tool = ic.getEquiped();
		}
		
		if(tool != null){
			ToolComponent tc = tool.getComponent(ToolComponent.class);
			BalisticComponent bc = tool.getComponent(BalisticComponent.class);
			MagazineComponent mc = tool.getComponent(MagazineComponent.class);
			TransformComponent trc = entity.getComponent(TransformComponent.class);
			
			if(tc.canUsePrimary()){
				tc.setUsingPrimary(true);
				if(bc != null){
					if(!bc.isWaitingForCoolDown()){
						if(mc != null){
							mc.shoot();
						}
						
						world.getSystem(BalisticSystem.class).shoot(tool, 
								trc.getPos().cpy().add(trc.getDimensions().cpy().scl(0.5f)), 
								trc.getAngle());		
						
						world.getSystem(BalisticSystem.class).shootWait(tool);
					}
				}
			}
		}
	}
	
	public void stopPrimary(Entity entity){
		Entity tool = null;
		
		if(this.world.getMapper(InventoryComponent.class).has(entity)){
			tool = this.world.getMapper(InventoryComponent.class).get(entity).getEquiped();
		}
		
		if(tool != null){
			this.world.getMapper(ToolComponent.class).get(tool).setUsingPrimary(false);
			if(this.world.getMapper(BalisticComponent.class).has(tool)){			
				if(this.world.getMapper(BalisticComponent.class).get(tool).isSemiAutomatic()){
					this.world.getMapper(ToolComponent.class).get(tool).setUsePrimary(true);
				}				
			}
		}
	}	
}
