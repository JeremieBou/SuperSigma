package com.jercodes.SuperSigmaProject.managers;

import java.util.Iterator;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.jercodes.SuperSigmaProject.EntityFactory;
import com.jercodes.SuperSigmaProject.components.world.TileMapComponent;

public class TiledMapManager extends EntitySystem {
	//private EntityFactory entityFactory;
	
	
	//TODO entityFactory
	@SuppressWarnings("unchecked")
	public TiledMapManager(EntityFactory entityFactory){
		super(Aspect.all(TileMapComponent.class));
		//this.entityFactory = entityFactory;
	}
	
	public void inserted(int e){
		super.inserted(e);
		if(this.world.getMapper(TileMapComponent.class).has(e)){
			TileMapComponent mapComp = this.world.getMapper(TileMapComponent.class).get(e);
			TiledMap map = mapComp.getMap();
						
			MapObjects mapO = map.getLayers().get("Collisions").getObjects();
			Iterator<MapObject> arr = mapO.iterator();
			
			while(arr.hasNext()){
				MapObject obj = arr.next();
				world.getSystem(Box2DManager.class).createShapeFromMapObject(obj);
			}		
		}			
	}
	
	public void removed(Entity e){
		super.removed(e.id);
	}

	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub
		
	}
}
