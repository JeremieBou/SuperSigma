package com.jercodes.SuperSigmaProject.systems;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.jercodes.SuperSigmaProject.Assets;

public class CursorSystem extends BaseSystem {
	
	public CursorSystem(){
		Gdx.graphics.setCursor(Gdx.graphics.newCursor(Assets.cursor, 16, 16));
	}
	
	protected void processSystem() {
		//Gdx.input.setCursorPosition(Gdx.input.getX(), Gdx.input.getX());		
	}
}
