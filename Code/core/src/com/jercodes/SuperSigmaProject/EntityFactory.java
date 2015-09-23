package com.jercodes.SuperSigmaProject;

import com.artemis.Entity;
import com.artemis.EntityEdit;
import com.artemis.World;
import com.artemis.utils.EntityBuilder;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.jercodes.SuperSigmaProject.components.CameraComponent;
import com.jercodes.SuperSigmaProject.components.ControllableComponent;
import com.jercodes.SuperSigmaProject.components.DebugRenderComponent;
import com.jercodes.SuperSigmaProject.components.InputControllableComponent;
import com.jercodes.SuperSigmaProject.components.PhysicsComponent;
import com.jercodes.SuperSigmaProject.components.RenderableComponent;
import com.jercodes.SuperSigmaProject.components.SpriteComponent;
import com.jercodes.SuperSigmaProject.components.TransformComponent;
import com.jercodes.SuperSigmaProject.components.life.HPComponent;
import com.jercodes.SuperSigmaProject.components.life.InventoryComponent;
import com.jercodes.SuperSigmaProject.components.life.LivingComponent;
import com.jercodes.SuperSigmaProject.components.life.MPComponent;
import com.jercodes.SuperSigmaProject.components.life.PlayerComponent;
import com.jercodes.SuperSigmaProject.components.tools.BalisticComponent;
import com.jercodes.SuperSigmaProject.components.tools.GunComponent;
import com.jercodes.SuperSigmaProject.components.tools.MagazineComponent;
import com.jercodes.SuperSigmaProject.components.tools.ProjectileComponent;
import com.jercodes.SuperSigmaProject.components.tools.ReloadableComponent;
import com.jercodes.SuperSigmaProject.components.tools.ToolComponent;
import com.jercodes.SuperSigmaProject.components.world.TileMapComponent;

public class EntityFactory{
	private World world;
	
	public EntityFactory(World world){
		this.world = world;
	}

	public Entity createGlobalController(){
		Entity entity = new EntityBuilder(world)
		.with(new ControllableComponent(),
				new InputControllableComponent(Settings.getGlobalKeyActionIds()))
		.tag("global controller")
		.group("game objects")
		.build();

		return entity;
	}

	public Entity createPlayer(Vector2 spawnPoint, Entity firstItem){

		CircleShape shape = new CircleShape();
	    shape.setRadius(32*PhysicsComponent.pixel2Phys);
		
		InventoryComponent inventory = new InventoryComponent();
		inventory.equip(firstItem);
				
		Entity entity = new EntityBuilder(world)
		.with(new DebugRenderComponent(Color.CYAN),
				new RenderableComponent(),
				new SpriteComponent(Assets.playerSprite),
				new LivingComponent(),
				new HPComponent(100),
				new MPComponent(100),			
				new PlayerComponent(),
				new TransformComponent(spawnPoint, new Vector2(64,64), 0),
				new PhysicsComponent(PhysicsComponent.PLAYER_CAT_BIT, PhysicsComponent.PLAYER_MASK, false, shape, world, 10f),
				new ControllableComponent(),				
				new InputControllableComponent(Settings.getPlayerKeyActionIds()),
				inventory)	
		.tag("player")
		.group("allies")
		.build();
		
		return entity;
	}

	public Entity createEnviromentElement(Vector2 pos, Vector2 dim, Shape shape){

			
		Entity entity = new EntityBuilder(world)
		.with(new TransformComponent(pos, dim, 0),
				new PhysicsComponent(PhysicsComponent.ENVIROMENT_CAT_BIT, PhysicsComponent.ENVIROMENT_MASK, true, shape, world, 0f))
		.tag("block")
		.group("enviroment")
		.build();
		
		return entity;
	}

	public Entity createBlock(Vector2 pos){
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(16, 16);
		Entity entity = createEnviromentElement(pos, new Vector2(32, 32), shape);		
		EntityEdit ee = entity.edit()
		.add(new DebugRenderComponent(Color.RED))
		.add(new RenderableComponent())
		.add(new SpriteComponent(Assets.testBlock));
		
		return entity;
	}

	public Entity createTestGun(ProjectileComponent.Type projectileType){
		Entity entity = new EntityBuilder(world)
		.with(new ToolComponent(),
				new BalisticComponent(false, 30f, 10f, projectileType),
				new GunComponent(80, 0.2f),
				new MagazineComponent(80, 80),
				new ReloadableComponent(1.2f))
		.tag("testGun")
		.group("tools")
		.build();
		
		return entity;
	}

	public Entity createBullet(Vector2 pos, float speed, float angle, float weigth, float muzzleVelocity, Sprite givenSprite){

		CircleShape shape = new CircleShape();
	    shape.setRadius(5/PhysicsComponent.pixel2Phys);
		
		Entity entity = new EntityBuilder(world)
		.with(new ProjectileComponent(1f, pos),
				new TransformComponent(pos, new Vector2(10, 10), angle),
				new PhysicsComponent(PhysicsComponent.PROJECTILE_CAT_BIT, PhysicsComponent.PROJECTILE_MASK, true, shape, world, muzzleVelocity),
				new RenderableComponent(),
				new SpriteComponent(givenSprite))
		.tag("bullet")
		.group("projectile")
		.build();
		
		
		return entity;
	}

	public Entity createBullet(Vector2 pos, float speed, float angle, ProjectileComponent.Type type){
		switch(type){
			case TEST_BULLET:
				return createBullet(pos, speed, angle, 10f, 20f, Assets.bullet);

			default:
				return createBullet(pos, speed, angle, ProjectileComponent.Type.TEST_BULLET);
		}
	}


	public Entity createCamera(Entity target, TiledMapRenderer renderer){

		Entity entity = new EntityBuilder(world)
		.with(new CameraComponent(target, renderer))
		.tag("camera")
		.group("game objects")		
		.build();
				
		return entity;
	}

	public Entity createTiledMap(TiledMap tMap){
		
		TileMapComponent tmc = new TileMapComponent(tMap);
		Entity entity = new EntityBuilder(world)
		.with(tmc,
				new RenderableComponent())
		.tag("tileMap")
		.group("world objects")		
		.build();
		
		//TileMapSystem.processMap(tmc);
		
		return entity;
	}
}
