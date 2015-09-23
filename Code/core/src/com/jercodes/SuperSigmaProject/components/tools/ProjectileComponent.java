package com.jercodes.SuperSigmaProject.components.tools;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class ProjectileComponent extends Component {
	public enum Type {
		TEST_BULLET
	}

	private float squareRange;
	private Vector2 originalPosition;
	
	public ProjectileComponent(float squareRange, Vector2 originalPosition) {
		this.squareRange = squareRange;
		this.originalPosition = originalPosition;
	}
	
	public float getSquareRange() {
		return squareRange;
	}
	
	public Vector2 getOriginalPosition() {
		return originalPosition;
	}
}
