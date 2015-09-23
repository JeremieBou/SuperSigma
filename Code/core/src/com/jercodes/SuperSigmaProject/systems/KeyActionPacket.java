package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Entity;

public class KeyActionPacket extends ActionPacket{
	public int key;
	public int keyMode;
	
	public KeyActionPacket(Action action, int key, int keyMode) {
		this(action, null, key, keyMode);
	}
	
	public KeyActionPacket(Action action, Entity entity, int key, int keyMode) {
		super(action, entity);
		this.key = key;
		this.keyMode = keyMode;
	}
	
}
