package com.jercodes.SuperSigmaProject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Array;
import com.jercodes.SuperSigmaProject.managers.InputManager;
import com.jercodes.SuperSigmaProject.systems.ActionPacket;
import com.jercodes.SuperSigmaProject.systems.KeyActionPacket;

/**
 * Where all the games settings are stored and where there handled
 * 
 * @author Jeremie Boudreau
 */

public class Settings {
	
	private static int screenWidth;
	private static int screenHeigth;
		
	private static Array<KeyActionPacket> playerKeyActionIds;
	private static Array<KeyActionPacket> globalKeyActionIds;
		
	public static void load(){
		screenWidth = Gdx.graphics.getWidth();
		screenHeigth = Gdx.graphics.getHeight();
		
		//load player keys
		playerKeyActionIds = new Array<KeyActionPacket>();
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.MOVE_UP, Keys.W, InputManager.KEY_PRESSED));		
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.MOVE_RIGHT, Keys.D, InputManager.KEY_PRESSED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.MOVE_DOWN, Keys.S, InputManager.KEY_PRESSED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.MOVE_LEFT, Keys.A, InputManager.KEY_PRESSED));
		
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_MOVE_UP, Keys.W, InputManager.KEY_RELEASED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_MOVE_RIGHT, Keys.D, InputManager.KEY_RELEASED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_MOVE_DOWN, Keys.S, InputManager.KEY_RELEASED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_MOVE_LEFT, Keys.A, InputManager.KEY_RELEASED));
		
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.HANDHELD_MAIN, Input.Buttons.LEFT, InputManager.MOUSE_PRESSED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.HANDHELD_SECONDARY, Input.Buttons.RIGHT, InputManager.MOUSE_PRESSED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_HANDHELD_MAIN, Input.Buttons.LEFT, InputManager.MOUSE_RELEASED));
		playerKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.STOP_HANDHELD_SECONDARY, Input.Buttons.RIGHT, InputManager.MOUSE_RELEASED));
		
		//load global keys
		globalKeyActionIds = new Array<KeyActionPacket>();
		globalKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.EXIT_GAME, Keys.ESCAPE, InputManager.KEY_PRESSED));
		globalKeyActionIds.add(new KeyActionPacket(ActionPacket.Action.DEBUG_MODE, Keys.F2, InputManager.KEY_PRESSED));
	}
	

	public static void save(){
		
	}

	
	public static Array<KeyActionPacket> getPlayerKeyActionIds(){
		return playerKeyActionIds;
	}
	public static Array<KeyActionPacket> getGlobalKeyActionIds() {
		return globalKeyActionIds;
	}
	
	
	public static int getScreenWidth() {
		return screenWidth;
	}

	public static void setScreenWidth(int screenWidth) {
		Settings.screenWidth = screenWidth;
	}

	public static int getScreenHeigth() {
		return screenHeigth;
	}

	public static void setScreenHeigth(int screenHeigth) {
		Settings.screenHeigth = screenHeigth;
	}
}
