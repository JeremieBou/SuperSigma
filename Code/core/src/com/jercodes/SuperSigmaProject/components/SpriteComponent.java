package com.jercodes.SuperSigmaProject.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteComponent extends Component{
	private Sprite sprite;

	public SpriteComponent(Sprite sprite) {
		this.sprite = sprite;
	}

	public Sprite getSprite() {
		return sprite;
	}
}
