package com.jercodes.SuperSigmaProject.systems;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;
import com.jercodes.SuperSigmaProject.Assets;

public class CursorSystem extends VoidEntitySystem {
	
	public CursorSystem(){
		Gdx.input.setCursorImage(Assets.cursor, 16, 16);
	}
	
	protected void processSystem() {
		//Gdx.input.setCursorPosition(Gdx.input.getX(), Gdx.input.getX());		
	}
}
