package com.jercodes.SuperSigmaProject;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.jercodes.SuperSigmaProject.components.tools.ProjectileComponent;
import com.jercodes.SuperSigmaProject.components.world.TileMapComponent;
import com.jercodes.SuperSigmaProject.managers.Box2DManager;
import com.jercodes.SuperSigmaProject.managers.InputManager;
import com.jercodes.SuperSigmaProject.managers.TiledMapManager;
import com.jercodes.SuperSigmaProject.systems.BalisticSystem;
import com.jercodes.SuperSigmaProject.systems.CameraSystem;
import com.jercodes.SuperSigmaProject.systems.ControllerSystem;
import com.jercodes.SuperSigmaProject.systems.CursorSystem;
import com.jercodes.SuperSigmaProject.systems.InventorySystem;
import com.jercodes.SuperSigmaProject.systems.MagazineSystem;
import com.jercodes.SuperSigmaProject.systems.PhysicsSystem;
import com.jercodes.SuperSigmaProject.systems.RenderSystem;
import com.jercodes.SuperSigmaProject.systems.TileMapRenderSystem;
import com.jercodes.SuperSigmaProject.systems.ToolSystem;
import com.jercodes.SuperSigmaProject.systems.TransformSystem;

/**
 * Main in game screen where everything happens
 * @author Jeremie
 *
 */
public class GameScreen implements Screen {
	private final World world;
	private final EntityFactory entityFactory;
	private ComponentMapper<TileMapComponent> tm;

	public GameScreen(SuperSigmaProject game){
		entityFactory = new EntityFactory();
		
		Box2DManager bm = new Box2DManager(entityFactory);
		ControllerSystem cm = new ControllerSystem();
		PhysicsSystem ps = new PhysicsSystem(bm.getBox2DWorld());
		
		
		
		WorldConfiguration config = new WorldConfiguration()
		.setManager(new TagManager())
		.setManager(new GroupManager())
		.setSystem(new InputManager(cm))
		.setSystem(new TiledMapManager(entityFactory))
		.setSystem(bm)

		.setSystem(new CameraSystem(game.batcher))

		.setSystem(new TileMapRenderSystem())
		.setSystem(new RenderSystem(game.batcher))

		.setSystem(cm)	
		
		.setSystem(ps)
		.setSystem(new TransformSystem())
		
		.setSystem(new BalisticSystem(entityFactory))
		.setSystem(new ToolSystem())
		.setSystem(new MagazineSystem())
		.setSystem(new InventorySystem(cm))

		.setSystem(new CursorSystem());
		
		world = new World(config);
		
		tm = world.getMapper(TileMapComponent.class);
		
		entityFactory.initialize(world);
		
		
		

		Entity tileMap = entityFactory.createTiledMap(Assets.map1);
		Entity testGun = entityFactory.createTestGun(ProjectileComponent.Type.TEST_BULLET);
		Entity player = entityFactory.createPlayer(world.getMapper(TileMapComponent.class).get(tileMap).getPlayerSpawn(), testGun);
		//Entity player = entityFactory.createPlayer(new Vector2(1000, 1000), testGun);
		entityFactory.createBlock(new Vector2(800, 800));
		entityFactory.createCamera(player, tm.get(tileMap).getRenderer());
		
		
	}
	
	public void render(float delta){
		Gdx.gl.glClearColor(0.0f, 1.0f, 0.0f, 0.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		world.setDelta(MathUtils.clamp(delta, 0, 1 / 15f));
		world.process();
	}

	public void show(){}
	public void resize(int width, int height) {	}
	public void hide(){}
	public void pause(){}
	public void resume(){}
	public void dispose(){}

}
