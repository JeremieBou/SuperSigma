package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.jercodes.SuperSigmaProject.components.tools.MagazineComponent;
import com.jercodes.SuperSigmaProject.components.tools.ToolComponent;

public class MagazineSystem extends EntityProcessingSystem {

	@SuppressWarnings("unchecked")
	public MagazineSystem() {
		super(Aspect.all(MagazineComponent.class, ToolComponent.class));
	}

	@Override
	protected void process(Entity e) {
		if(e.getComponent(MagazineComponent.class).isEmpty()){
			e.getComponent(ToolComponent.class).setUsePrimary(false);
		}
	}
}
