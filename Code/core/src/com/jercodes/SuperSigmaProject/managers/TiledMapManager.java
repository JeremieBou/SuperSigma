package com.jercodes.SuperSigmaProject.managers;

import java.util.Iterator;

import com.artemis.Entity;
import com.artemis.Manager;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.jercodes.SuperSigmaProject.EntityFactory;
import com.jercodes.SuperSigmaProject.components.world.TileMapComponent;

public class TiledMapManager extends Manager {
	//private EntityFactory entityFactory;
	
	
	//TODO entityFactory
	public TiledMapManager(EntityFactory entityFactory){
		//this.entityFactory = entityFactory;
	}
	
	public void added(Entity e){
		super.added(e.id);
		if(this.world.getMapper(TileMapComponent.class).has(e)){
			TileMapComponent mapComp = this.world.getMapper(TileMapComponent.class).get(e);
			TiledMap map = mapComp.getMap();
						
			MapObjects mapO = map.getLayers().get("Collisions").getObjects();
			Iterator<MapObject> arr = mapO.iterator();
			
			while(arr.hasNext()){
				MapObject obj = arr.next();
				world.getManager(Box2DManager.class).createShapeFromMapObject(obj);
			}		
		}			
	}
	
	public void deleted(Entity e){
		super.deleted(e.id);
	}
}
