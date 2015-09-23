package com.jercodes.SuperSigmaProject.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class TransformComponent extends Component{
	private Vector2 pos = new Vector2(0, 0);
	private Vector2 dimensions = new Vector2(0, 0);
	private float angle = 0.0f;
	
	public TransformComponent(Vector2 pos, Vector2 dimensions,  float angle){
		this.pos = pos;
		this.dimensions = dimensions;
		this.angle = angle;
	}
	
	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}

	public Vector2 getDimensions() {
		return dimensions;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
}
