package com.jercodes.SuperSigmaProject.systems;

import com.artemis.BaseSystem;
import com.badlogic.gdx.Gdx;
import com.jercodes.api.Listener;
import com.jercodes.api.Signal;

public class ControllerSystem extends BaseSystem implements Listener<ActionPacket>{
	//TODO does this need to be a system?
	public ControllerSystem(){
		super();
		setPassive(true);
	}
	
	protected void processSystem() {
				
	}

	public void receive(Signal<ActionPacket> signal, ActionPacket data) {
		ActionPacket action = (ActionPacket) data;

		if(action.getAction() == ActionPacket.Action.MOVE_UP){
			world.getSystem(PhysicsSystem.class).startMoveUp(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.MOVE_DOWN){
			world.getSystem(PhysicsSystem.class).startMoveDown(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.MOVE_RIGHT){
			world.getSystem(PhysicsSystem.class).startMoveRight(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.MOVE_LEFT){
			world.getSystem(PhysicsSystem.class).startMoveLeft(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.STOP_MOVE_UP){
			world.getSystem(PhysicsSystem.class).stopMoveUp(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.STOP_MOVE_DOWN){
			world.getSystem(PhysicsSystem.class).stopMoveDown(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.STOP_MOVE_RIGHT){
			world.getSystem(PhysicsSystem.class).stopMoveRight(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.STOP_MOVE_LEFT){
			world.getSystem(PhysicsSystem.class).stopMoveLeft(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.HANDHELD_MAIN){
			world.getSystem(ToolSystem.class).usePrimary(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.STOP_HANDHELD_MAIN){
			world.getSystem(ToolSystem.class).stopPrimary(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.HANDHELD_SECONDARY){
			//world.getSystem(ToolSystem.class).useSecondary(action.getEntity());
		}

		else if(action.getAction() == ActionPacket.Action.EXIT_GAME){
			Gdx.app.exit();
		}

	}
}
