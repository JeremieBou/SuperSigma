package com.jercodes.SuperSigmaProject.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;

public class DebugRenderComponent extends Component{
	private Color debugColor;

	public DebugRenderComponent(Color debugColor) {
		this.debugColor = debugColor;
	}

	public Color getDebugColor() {
		return debugColor;
	}
	
	
}
