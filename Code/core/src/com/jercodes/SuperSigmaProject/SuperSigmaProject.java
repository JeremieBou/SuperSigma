package com.jercodes.SuperSigmaProject;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SuperSigmaProject extends Game {
	public SpriteBatch batcher;
	
	@Override
	public void create () {
		batcher = new SpriteBatch();
		Settings.load();
		Assets.load();
		
		setScreen(new GameScreen(this));
	}
	
	public void dispose(){
		super.dispose();
		Assets.dispose();
	}
}
