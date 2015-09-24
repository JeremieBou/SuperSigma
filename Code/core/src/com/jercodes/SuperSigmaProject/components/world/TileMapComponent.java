package com.jercodes.SuperSigmaProject.components.world;

import com.artemis.Component;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Vector2;

public class TileMapComponent extends Component{
	private TiledMapRenderer mapRenderer;
	private TiledMap map;
	private Vector2 dim;
	private Vector2 playerSpawn;
	
	public TileMapComponent(TiledMap map){
		this.map = map;
		mapRenderer = new OrthogonalTiledMapRenderer(this.map);
		
		setDim(new Vector2(64, 64));
		
		EllipseMapObject cOb = (EllipseMapObject) map.getLayers().get("Spawns").getObjects().get("Player");
		Ellipse c = cOb.getEllipse();
		
		playerSpawn = new Vector2(c.x, c.y);
		System.out.println(playerSpawn);
	}
	
	public TiledMapRenderer getRenderer(){
		return mapRenderer;
	}

	public TiledMap getMap() {
		return map;
	}

	public Vector2 getPlayerSpawn() {
		return playerSpawn;
	}

	public void setPlayerSpawn(Vector2 playerSpawn) {
		this.playerSpawn = playerSpawn;
	}

	public Vector2 getDim() {
		return dim;
	}

	public void setDim(Vector2 dim) {
		this.dim = dim;
	}
}
