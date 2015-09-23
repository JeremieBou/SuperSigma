package com.jercodes.SuperSigmaProject.managers;

import java.util.Iterator;

import com.artemis.Entity;
import com.artemis.Manager;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.jercodes.SuperSigmaProject.EntityFactory;
import com.jercodes.SuperSigmaProject.components.PhysicsComponent;
import com.jercodes.SuperSigmaProject.components.world.TileMapComponent;

public class TiledMapManager extends Manager {
	private EntityFactory entityFactory;
	
	public TiledMapManager(EntityFactory entityFactory){
		this.entityFactory = entityFactory;
	}
	
	public void added(Entity e){
		super.added(e);
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
		super.deleted(e);
	}
}
