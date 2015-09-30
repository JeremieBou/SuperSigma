package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.World;
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
	
	public ToolSystem() {
		super(Aspect.all(ToolComponent.class));	
		//this.world = world;
		
	}

		
	protected void process(Entity entity) {
		if(this.world.getMapper(MagazineComponent.class).has(entity)){
			if(this.world.getMapper(MagazineComponent.class).get(entity).isEmpty()){
				this.world.getMapper(ToolComponent.class).get(entity).setUsePrimary(false);
			}
		}
	}
	
	
	
	
	/**
	 * @param entity The owner of the tool
	 */
	public void usePrimary(Entity entity){
		Entity tool = null;
		if(this.world.getMapper(InventoryComponent.class).has(entity)){
			tool = this.world.getMapper(InventoryComponent.class).get(entity).getEquiped();
		}
		
		if(tool != null){
			if(this.world.getMapper(ToolComponent.class).get(tool).canUsePrimary()){
				this.world.getMapper(ToolComponent.class).get(tool).setUsingPrimary(true);
				if(this.world.getMapper(BalisticComponent.class).has(tool)){
					if(!this.world.getMapper(BalisticComponent.class).get(tool).isWaitingForCoolDown()){
						if(this.world.getMapper(MagazineComponent.class).has(tool)){
							this.world.getMapper(MagazineComponent.class).get(tool).shoot();
						}
						
						world.getSystem(BalisticSystem.class).shoot(tool, 
								this.world.getMapper(TransformComponent.class).get(entity).getPos().cpy()
									.add(this.world.getMapper(TransformComponent.class).get(entity).getDimensions().cpy().scl(0.5f)), 
								this.world.getMapper(TransformComponent.class).get(entity).getAngle()						
								);		
						
						
						//engine.getSystem(BalisticSystem.class).shootWait(tool);
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
