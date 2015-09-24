package com.jercodes.SuperSigmaProject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Assets  {
	public static Sprite playerSprite;
	public static Sprite bullet;
	public static Sprite testBlock;
	public static Pixmap cursor;
	
	public static TiledMap map1;
	public static TiledMap map2;
	public static TiledMap map3;
	public static TiledMap map4;
	
	public static Sprite loadTexture(String file){
		return new Sprite(new Texture("Graphics/Sprites/" + Gdx.files.internal(file)));
	}
	
	public static TiledMap loadTileMap(String file){
		return new TmxMapLoader().load("TileMaps/" + file + ".tmx");
	}
	
	public static Pixmap loadPixmap(String file){
		return new Pixmap(Gdx.files.internal("Graphics/Sprites/" + file));
	}
	
	public static void load(){
		playerSprite = loadTexture("Player/player.png");
		bullet = loadTexture("Projectiles/bullet.png");
		testBlock = loadTexture("block.png");
		cursor = loadPixmap("Cursors/cursor.png");
		
		map1 = loadTileMap("TestTileSet");
		map2 = loadTileMap("TestTileSet2");
		map3 = loadTileMap("TestTileSet3");
		map4 = loadTileMap("TestTileSet4");
	}
	
	public static void dispose(){
		cursor.dispose();
		map1.dispose();
		map2.dispose();
		map3.dispose();
		map4.dispose();
		
	}
}
