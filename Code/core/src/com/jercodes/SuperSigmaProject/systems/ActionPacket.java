package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Entity;


public class ActionPacket {
	public static enum Action{
		 MOVE_UP,
		 MOVE_DOWN,
		 MOVE_RIGHT,
		 MOVE_LEFT,
		 STOP_MOVE_UP,
		 STOP_MOVE_DOWN,
		 STOP_MOVE_RIGHT,
		 STOP_MOVE_LEFT,
		 HANDHELD_MAIN,
		 HANDHELD_SECONDARY,
		 STOP_HANDHELD_MAIN,
		 STOP_HANDHELD_SECONDARY,
		
		 EXIT_GAME,
		 DEBUG_MODE
	}
	
	private Action action;
	private Entity entity;
	
	
	public ActionPacket(Action action, Entity entity){
		this.action = action;
		this.entity = entity;
	}


	public Action getAction() {
		return action;
	}


	public Entity getEntity() {
		return entity;
	}
	
	public void setEntity(Entity newEntity){
		this.entity = newEntity;
	}
	
}
