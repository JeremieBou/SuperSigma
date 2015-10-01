package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jercodes.SuperSigmaProject.components.PhysicsComponent;
import com.jercodes.SuperSigmaProject.components.TransformComponent;

public class TransformSystem extends EntityProcessingSystem {
	@SuppressWarnings("unchecked")
	public TransformSystem() {
		super(Aspect.all(TransformComponent.class, PhysicsComponent.class));
	}

	protected void process(Entity e) {
		PhysicsComponent p = e.getComponent(PhysicsComponent.class);
		TransformComponent t = e.getComponent(TransformComponent.class);


		if(p.getBody() != null){
			t.setAngle(p.getBody().getAngle());
			t.setPos(p.getBody().getPosition().cpy().scl(PhysicsComponent.phys2Pixel).sub(
					t.getDimensions().cpy().scl(0.5f)));

		}
	}
}
