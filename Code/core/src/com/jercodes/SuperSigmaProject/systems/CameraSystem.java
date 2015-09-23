package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jercodes.SuperSigmaProject.components.CameraComponent;
import com.jercodes.SuperSigmaProject.components.TransformComponent;

public class CameraSystem extends EntityProcessingSystem{
	private SpriteBatch batch;
		
	public CameraSystem(SpriteBatch batch) {
		super(Aspect.getAspectForAll(CameraComponent.class));		
		
		this.batch = batch;		
	}
	
	public void initialize(){
		super.initialize();
	}
	
	
	public void process(Entity entity) {
		CameraComponent cam = this.world.getMapper(CameraComponent.class).get(entity);
		
		if(cam.getTarget() == null){
			return;
		}
		
		TransformComponent targetTransform = this.world.getMapper(TransformComponent.class).get(cam.getTarget());
		
		
		if(targetTransform == null){
			return;
		}
		
		cam.getCamera().position.x = targetTransform.getPos().x + targetTransform.getDimensions().x;
		cam.getCamera().position.y = targetTransform.getPos().y + targetTransform.getDimensions().y;		
		cam.getCamera().update();

		batch.setProjectionMatrix(cam.getCamera().combined);
		
		cam.getMapRenderer().setView(cam.getCamera());
		
		
	}	
}
