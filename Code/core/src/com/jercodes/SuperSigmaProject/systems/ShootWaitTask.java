package com.jercodes.SuperSigmaProject.systems;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.badlogic.gdx.utils.Timer;
import com.jercodes.SuperSigmaProject.components.tools.BalisticComponent;

public class ShootWaitTask extends Timer.Task{
	private Entity tool;
	private ComponentMapper<BalisticComponent> bm;
	
	public ShootWaitTask(Entity tool){
		this.tool = tool;
	}
	
	public void run() {
		bm.get(tool).setWaitingForCoolDown(false);
	}

}
