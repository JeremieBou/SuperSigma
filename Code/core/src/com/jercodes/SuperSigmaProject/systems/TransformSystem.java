package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jercodes.SuperSigmaProject.components.PhysicsComponent;
import com.jercodes.SuperSigmaProject.components.TransformComponent;

public class TransformSystem extends EntityProcessingSystem {
	public TransformSystem() {
		super(Aspect.getAspectForAll(TransformComponent.class));
	}

	protected void process(Entity e) {
		if(world.getMapper(PhysicsComponent.class).has(e)){
			PhysicsComponent p = world.getMapper(PhysicsComponent.class).get(e);
			TransformComponent t = world.getMapper(TransformComponent.class).get(e);
			
			t.setAngle(p.getBody().getAngle());
			t.setPos(p.getBody().getPosition().cpy().scl(PhysicsComponent.phys2Pixel).sub(
					t.getDimensions().cpy().scl(0.5f)));		
		}
	}
}
