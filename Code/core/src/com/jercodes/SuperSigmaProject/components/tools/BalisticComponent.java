package com.jercodes.SuperSigmaProject.components.tools;

import com.artemis.Component;

public class BalisticComponent extends Component{
	private boolean isSemiAutomatic;
	private float rateOfFire;//bullets per second
	private float launchSpeed;
	private ProjectileComponent.Type projectileType;
	private boolean waitingForCoolDown = false;
	
	public BalisticComponent(boolean isSemiAutomatic, float rateOfFire,	float launchSpeed, ProjectileComponent.Type projectileType) {
		this.isSemiAutomatic = isSemiAutomatic;
		this.rateOfFire = rateOfFire;
		this.launchSpeed = launchSpeed;
		this.projectileType = projectileType;
	}

	public boolean isSemiAutomatic() {
		return isSemiAutomatic;
	}

	public float getRateOfFire() {
		return rateOfFire;
	}

	public float getLaunchSpeed() {
		return launchSpeed;
	}

	public ProjectileComponent.Type getProjectileType() {
		return projectileType;
	}

	public boolean isWaitingForCoolDown() {
		return waitingForCoolDown;
	}

	public void setWaitingForCoolDown(boolean waitingForCoolDown) {
		this.waitingForCoolDown = waitingForCoolDown;
	}

}
