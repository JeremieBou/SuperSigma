package com.jercodes.SuperSigmaProject.components.life;

import com.artemis.Component;

public class MPComponent extends Component{
	private float maxMP;
	private float currentMP;
	private float MPChangeRate;
	
	public MPComponent(float maxMP){
		this.maxMP = maxMP;
		this.currentMP = maxMP;
		this.MPChangeRate = 0;
	}

	public float getMaxMP() {
		return maxMP;
	}

	public float getCurrentMP() {
		return currentMP;
	}

	public float getMPChangeRate() {
		return MPChangeRate;
	}
	
	
	
}
