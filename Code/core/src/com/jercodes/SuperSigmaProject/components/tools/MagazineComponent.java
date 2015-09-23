package com.jercodes.SuperSigmaProject.components.tools;

import com.artemis.Component;

public class MagazineComponent extends Component{
	private int magazine;
	private int magazineCapacity;
	
	public MagazineComponent(int magazine, int magazineCapacity) {
		this.magazine = magazine;
		this.magazineCapacity = magazineCapacity;
	}
	
	public int getMagazine() {
		return magazine;
	}
	
	public void shoot(){
		shoot(1);
	}
	
	public void shoot(int numberOfShots) {
		if(magazine >= numberOfShots){
			this.magazine -= numberOfShots;
		}
	}
	
	public boolean isEmpty(){
		return magazine == 0;
	}
	
	public int getMagazineCapacity() {
		return magazineCapacity;
	}
}
