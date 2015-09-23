package com.jercodes.SuperSigmaProject.components.tools;

import com.artemis.Component;

public class GunComponent extends Component{
	private int totalAmmo;
	private float recoil;	
	
	public GunComponent(int totalAmmo, float recoil) {
		super();
		this.totalAmmo = totalAmmo;
		this.recoil = recoil;
	}
	
	public int getTotalAmmo() {
		return totalAmmo;
	}
	
	public float getRecoil() {
		return recoil;
	}
}
