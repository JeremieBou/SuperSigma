package com.jercodes.SuperSigmaProject.components.life;

import com.artemis.Component;

public class HPComponent extends Component{
	private float maxHP;
	private float currentHP;
	private float HPChangeRate;
	
	public HPComponent(float maxHP){
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.HPChangeRate = 0;
	}

	public float getMaxHP() {
		return maxHP;
	}

	public float getCurrentHP() {
		return currentHP;
	}

	public float getHPChangeRate() {
		return HPChangeRate;
	}
	
	
	
}
