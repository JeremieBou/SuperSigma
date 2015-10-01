package com.jercodes.SuperSigmaProject.managers;

import com.artemis.Aspect;
import com.artemis.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.IntMap;
import com.jercodes.SuperSigmaProject.components.InputControllableComponent;
import com.jercodes.SuperSigmaProject.systems.ActionPacket;
import com.jercodes.SuperSigmaProject.systems.ControllerSystem;
import com.jercodes.api.Signal;

public class InputManager extends EntitySystem implements InputProcessor{
	/**
	 * If activated when a key is pressed
	 */
	public static final int KEY_PRESSED = 0;

	/**
	 * If activated when a key is released
	 */
	public static final int KEY_RELEASED = 1;

	/**
	 * If activated when a mouse button is pressed 
	 */
	public static final int MOUSE_PRESSED = 2;

	/**
	 * If activated when a mouse button is released
	 */
	public static final int MOUSE_RELEASED = 3;

	private IntMap<ActionPacket> keyDownPackets;
	private IntMap<ActionPacket> keyUpPackets;
	private IntMap<ActionPacket> mouseDownPackets;
	private IntMap<ActionPacket> mouseUpPackets;

	private Signal<ActionPacket> controllerSystemSignal;


	@SuppressWarnings("unchecked")
	public InputManager(ControllerSystem control){
		super(Aspect.all(InputControllableComponent.class));

		keyDownPackets = new IntMap<ActionPacket>();
		keyUpPackets = new IntMap<ActionPacket>();

		mouseDownPackets = new IntMap<ActionPacket>();
		mouseUpPackets = new IntMap<ActionPacket>();

		controllerSystemSignal = new Signal<ActionPacket>();
		controllerSystemSignal.add(control);

		Gdx.input.setInputProcessor(this);
	}

	public void inserted(int id){
		super.inserted(id);

		InputControllableComponent input = this.world.getMapper(InputControllableComponent.class).get(id);

		for (int i = 0; i < input.getKeyActionArray().size; i++) {
			if(input.getKeyActionArray().get(i).getEntity() == null){
				input.getKeyActionArray().get(i).setEntity(world.getEntity(id));
			}

			if(input.getKeyActionArray().get(i).keyMode == KEY_PRESSED){
				keyDownPackets.put(input.getKeyActionArray().get(i).key, input.getKeyActionArray().get(i));
			}

			else if(input.getKeyActionArray().get(i).keyMode == KEY_RELEASED){
				keyUpPackets.put(input.getKeyActionArray().get(i).key, input.getKeyActionArray().get(i));									
			}

			else if(input.getKeyActionArray().get(i).keyMode == MOUSE_PRESSED){
				mouseDownPackets.put(input.getKeyActionArray().get(i).key, input.getKeyActionArray().get(i));					
			}

			else if(input.getKeyActionArray().get(i).keyMode == MOUSE_RELEASED){
				mouseUpPackets.put(input.getKeyActionArray().get(i).key, input.getKeyActionArray().get(i));					
			}
		}
	}

	public void removed(int id){
		super.removed(id);

		InputControllableComponent input = this.world.getMapper(InputControllableComponent.class).get(id);

		for (int i = 0; i < input.getKeyActionArray().size; i++) {
			if(input.getKeyActionArray().get(i).keyMode == KEY_PRESSED){
				keyDownPackets.remove(input.getKeyActionArray().get(i).key);
			}

			else if(input.getKeyActionArray().get(i).keyMode == KEY_RELEASED){
				keyUpPackets.remove(input.getKeyActionArray().get(i).key);									
			}

			else if(input.getKeyActionArray().get(i).keyMode == MOUSE_PRESSED){
				mouseDownPackets.remove(input.getKeyActionArray().get(i).key);					
			}

			else if(input.getKeyActionArray().get(i).keyMode == MOUSE_RELEASED){
				mouseUpPackets.remove(input.getKeyActionArray().get(i).key);					
			}
		}

	}

	public boolean keyDown(int keyCode) {
		if(keyDownPackets.containsKey(keyCode)){
			controllerSystemSignal.dispatch(keyDownPackets.get(keyCode));
		}	

		return false;
	}

	public boolean keyUp(int keyCode) {
		if(keyUpPackets.containsKey(keyCode)){
			controllerSystemSignal.dispatch(keyUpPackets.get(keyCode));
		}

		return false;
	}

	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(mouseDownPackets.containsKey(button)){
			controllerSystemSignal.dispatch(mouseDownPackets.get(button));
		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(mouseUpPackets.containsKey(button)){
			controllerSystemSignal.dispatch(mouseUpPackets.get(button));
		}

		return false;
	}


	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}	

	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub

	}
}
