package com.jercodes.SuperSigmaProject.components.tools;

import com.artemis.Component;

public class ToolComponent extends Component{
	private boolean usingPrimary = false;	
	private boolean canUsePrimary = true;
	
	private boolean usingSecondary = false;
	private boolean canUseSecondary = true;
		
	public ToolComponent(){
	}

	public boolean canUsePrimary() {
		return canUsePrimary;
	}
	
	public void setUsePrimary(boolean newVal){
		canUsePrimary = newVal;
	}

	public boolean canUseSecondary() {
		return canUseSecondary;
	}
	
	public void setUseSecondary(boolean newVal){
		canUseSecondary = newVal;
	}
	
	public void togglePrimaryUse(){
		canUsePrimary = !canUsePrimary;
	}
	
	public void toggleSecondaryUse(){
		canUseSecondary = !canUseSecondary;
	}
	
	public boolean isUsingPrimary() {
		return usingPrimary;
	}

	public void setUsingPrimary(boolean usingPrimary) {
		this.usingPrimary = usingPrimary;
	}

	public boolean isUsingSecondary() {
		return usingSecondary;
	}

	public void setUsingSecondary(boolean usingSecondary) {
		this.usingSecondary = usingSecondary;
	}
}
