package com.jercodes.SuperSigmaProject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jercodes.SuperSigmaProject.SuperSigmaProject;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Super Sigma Project";
		config.fullscreen = false;
		
		if(args.length >= 2){
			config.width = Integer.parseInt(args[0]);
			config.height = Integer.parseInt(args[1]);
			if(args.length >= 3){
				config.fullscreen = Boolean.parseBoolean(args[2]);
			}
		}
		else{
			config.width = 1920;
			config.height = 1080;
		}
		
		new LwjglApplication(new SuperSigmaProject(), config);
	}
}
