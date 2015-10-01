package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.utils.IntBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.jercodes.SuperSigmaProject.components.PhysicsComponent;

public class PhysicsSystem extends EntitySystem {
	//Combine physics system and box2D system
	private World box2DWorld;
	
	@SuppressWarnings("unchecked")
	public PhysicsSystem(World box2DWorld) {
		super(Aspect.all(PhysicsComponent.class));
		this.box2DWorld = box2DWorld;
	}
	
	protected void processEntities(IntBag entities){
		//TODO FIXED TIME STEP
		box2DWorld.step(Gdx.app.getGraphics().getDeltaTime(), 6, 2);
	}
	
	private Body getBody(Entity e){
		return world.getMapper(PhysicsComponent.class).get(e).getBody();
	}
	
	public void startMoveUp(Entity e){
		Body b = getBody(e);
		b.setLinearVelocity(b.getLinearVelocity().x, world.getMapper(PhysicsComponent.class).get(e).getMovementSpeed());
	}
	
	public void startMoveDown(Entity e){
		Body b = getBody(e);
		b.setLinearVelocity(b.getLinearVelocity().x, world.getMapper(PhysicsComponent.class).get(e).getMovementSpeed() * -1);
	}
	
	public void startMoveRight(Entity e){
		Body b = getBody(e);

		b.setLinearVelocity(world.getMapper(PhysicsComponent.class).get(e).getMovementSpeed(), b.getLinearVelocity().y);
	}
	
	public void startMoveLeft(Entity e){
		Body b = getBody(e);
		
		b.setLinearVelocity(world.getMapper(PhysicsComponent.class).get(e).getMovementSpeed() * -1, b.getLinearVelocity().y);
	}
	
	public void stopMoveUp(Entity e){
		Body b = getBody(e);
		b.setLinearVelocity(b.getLinearVelocity().x, 0);
	}
	
	public void stopMoveDown(Entity e){
		Body b = getBody(e);
		b.setLinearVelocity(b.getLinearVelocity().x, 0);
	}
	
	public void stopMoveRight(Entity e){
		Body b = getBody(e);
		b.setLinearVelocity(0, b.getLinearVelocity().y);
	}
	
	public void stopMoveLeft(Entity e){
		Body b = getBody(e);
		b.setLinearVelocity(0, b.getLinearVelocity().y);
	}

	public World getBox2DWorld() {
		return box2DWorld;
	}

	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub
		
	}

}
