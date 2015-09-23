package com.jercodes.SuperSigmaProject.components.life;

import com.artemis.Component;
import com.artemis.Entity;
import com.badlogic.gdx.utils.Array;

public class InventoryComponent extends Component{
	private Array<Entity> items;
	private int equipedIndex;
	
	
	public InventoryComponent(){
		items = new Array<Entity>();
		equipedIndex = -1;
	}
	
	public Entity getEquiped(){
		if(equipedIndex >= 0){
			return items.get(equipedIndex);
		}
		else{
			return null;
		}
	}
	
	public void addItem(Entity entity){
		if(!items.contains(entity, true)){
			items.add(entity);
		}
	}
	
	public void equip(Entity entity){
		int index = items.indexOf(entity, true);
		if(index >= 0){
			equipedIndex = index;
		}
		else{
			addItem(entity);
			equip(entity);
		}
	}
}
