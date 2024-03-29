package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.jercodes.SuperSigmaProject.EntityFactory;
import com.jercodes.SuperSigmaProject.components.tools.BalisticComponent;
import com.jercodes.SuperSigmaProject.components.tools.ProjectileComponent;

public class BalisticSystem extends EntitySystem {
	private int totalShots = 0;
	private Timer rateOfFireTimer;
	private final EntityFactory entityFactory;
	
	@SuppressWarnings("unchecked")
	public BalisticSystem(EntityFactory entityFactory) {
		super(Aspect.all(BalisticComponent.class));			
		
		rateOfFireTimer = new Timer();
		this.entityFactory = entityFactory;
	}

	
	
	public void shoot(Entity tool, Vector2 pos, float angle){
		Entity weapon = tool;
		float speed = this.world.getMapper(BalisticComponent.class).get(tool).getLaunchSpeed();
		ProjectileComponent.Type type = this.world.getMapper(BalisticComponent.class).get(tool).getProjectileType();
		entityFactory.createBullet(pos, speed, angle, type);
		totalShots++;
		System.out.println(totalShots);
		
		shootWait(weapon);
	}
	
	protected void shootWait(Entity tool){
		float timeToWait = 1/this.world.getMapper(BalisticComponent.class).get(tool).getRateOfFire();

		this.world.getMapper(BalisticComponent.class).get(tool).setWaitingForCoolDown(true);
		
		ShootWaitTask swt = new ShootWaitTask(tool);
		rateOfFireTimer.clear();
		rateOfFireTimer.scheduleTask(swt, timeToWait);
	}

	protected void processSystem() {
		// TODO Auto-generated method stub
		
	}	
}