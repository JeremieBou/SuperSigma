package com.jercodes.SuperSigmaProject.components.tools;

import com.artemis.Component;

public class ReloadableComponent extends Component{
	private float reloadTime;
	private boolean isReloading = false;
	
	public ReloadableComponent(float reloadTime) {
		this.reloadTime = reloadTime;
	}
	
	public float getReloadTime() {
		return reloadTime;
	}
	
	public boolean isReloading() {
		return isReloading;
	}
}
