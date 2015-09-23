package com.jercodes.SuperSigmaProject.systems;

import com.artemis.systems.VoidEntitySystem;
import com.jercodes.SuperSigmaProject.components.magic.MagicCompositionComponent;

public class MagicCompositionSystem extends VoidEntitySystem {

	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub

	}
	
	public float getCompositionRatio(MagicCompositionComponent s, MagicCompositionComponent o){
		float compositionRatio = (s.getBlack() * 0)/o.getBlack() + (s.getBlack() * 1)/o.getPurple() + (s.getBlack() * 1)/o.getBrown() + (s.getBlack() * 1)/o.getYellow() + 
				(s.getBlack() * 1)/o.getBlue() + (s.getBlack() * 1)/o.getRed() + (s.getBlack() * 1)/o.getGreen() + (s.getBlack() * 3)/o.getWhite() +
				
				(s.getPurple() * 0.75f)/o.getBlack() + (s.getPurple() * 1)/o.getPurple() + (s.getPurple() * 2)/o.getBrown() + (s.getPurple() * 1.5f)/o.getYellow() + 
				(s.getPurple() * 1)/o.getBlue() + (s.getPurple() * 0.5f)/o.getRed() + (s.getPurple() * 0.25f)/o.getGreen() + (s.getPurple() * 0.75f)/o.getWhite() +
				
				(s.getBrown() * 0.75f)/o.getBlack() + (s.getBrown() * 0.25f)/o.getPurple() + (s.getBrown() * 1)/o.getBrown() + (s.getBrown() * 2)/o.getYellow() + 
				(s.getBrown() * 1.5f)/o.getBlue() + (s.getBrown() * 1)/o.getRed() + (s.getBrown() * 0.5f)/o.getGreen() + (s.getBrown() * 0.75f)/o.getWhite() +
				
				(s.getYellow() * 0.75f)/o.getBlack() + (s.getYellow() * 0.5f)/o.getPurple() + (s.getYellow() * 0.25f)/o.getBrown() + (s.getYellow() * 1)/o.getYellow() + 
				(s.getYellow() * 2)/o.getBlue() + (s.getYellow() * 1.5f)/o.getRed() + (s.getYellow() * 1)/o.getGreen() + (s.getYellow() * 0.75f)/o.getWhite() +
				
				(s.getBlue() * 0.75f)/o.getBlack() + (s.getBlue() * 1)/o.getPurple() + (s.getBlue() * 0.5f)/o.getBrown() + (s.getBlue() * 0.25f)/o.getYellow() + 
				(s.getBlue() * 1)/o.getBlue() + (s.getBlue() * 2f)/o.getRed() + (s.getBlue() * 1.5f)/o.getGreen() + (s.getBlue() * 0.75f)/o.getWhite() +
				
				(s.getRed() * 0.75f)/o.getBlack() + (s.getRed() * 1.5f)/o.getPurple() + (s.getRed() * 1)/o.getBrown() + (s.getRed() * 0.5f)/o.getYellow() + 
				(s.getRed() * 0.25f)/o.getBlue() + (s.getRed() * 1)/o.getRed() + (s.getRed() * 2f)/o.getGreen() + (s.getRed() * 0.75f)/o.getWhite() +
				
				(s.getGreen() * 0.75f)/o.getBlack() + (s.getGreen() * 2f)/o.getPurple() + (s.getGreen() * 1.5f)/o.getBrown() + (s.getGreen() * 1)/o.getYellow() + 
				(s.getGreen() * 0.5f)/o.getBlue() + (s.getGreen() * 0.25f)/o.getRed() + (s.getGreen() * 1)/o.getGreen() + (s.getGreen() * 0.75f)/o.getWhite() +
				
				(s.getWhite() * 3)/o.getBlack() + (s.getWhite() * 1)/o.getPurple() + (s.getWhite() * 1)/o.getBrown() + (s.getWhite() * 1)/o.getYellow() + 
				(s.getWhite() * 1)/o.getBlue() + (s.getWhite() * 1)/o.getRed() + (s.getWhite() * 1)/o.getGreen() + (s.getWhite() * 0)/o.getWhite();
		
		
		
		
		
		
		
		return compositionRatio;
	}

}
