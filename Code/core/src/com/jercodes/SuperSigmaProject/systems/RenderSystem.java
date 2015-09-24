package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.World;
import com.artemis.utils.IntBag;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.jercodes.SuperSigmaProject.components.PhysicsComponent;
import com.jercodes.SuperSigmaProject.components.RenderableComponent;
import com.jercodes.SuperSigmaProject.components.SpriteComponent;
import com.jercodes.SuperSigmaProject.components.TransformComponent;
import com.jercodes.SuperSigmaProject.components.world.TileMapComponent;

public class RenderSystem extends EntitySystem{

	private SpriteBatch batch;
	private final World world;
	private com.badlogic.gdx.physics.box2d.World box2dWorld;

	private Box2DDebugRenderer debugRenderer;
	private Matrix4 debugMatrix;

	public RenderSystem(SpriteBatch batch, World world, com.badlogic.gdx.physics.box2d.World box2dWorld){
		super(Aspect.getAspectForAll(RenderableComponent.class));

		this.batch = batch;
		
		this.world = world;

		debugRenderer = new Box2DDebugRenderer();
		this.box2dWorld = box2dWorld;
	}
	
	public void processEntities(IntBag entities){
		
		int[] array = entities.getData();
		
		Entity e = flyweight;
		
		for (int i = 0, s = entities.size(); s > i; i++) {
			e.id = array[i];
			process(e);
		}

		debugMatrix = batch.getProjectionMatrix().cpy().scale(PhysicsComponent.phys2Pixel, PhysicsComponent.phys2Pixel, 0);
		debugRenderer.render(box2dWorld, debugMatrix);
	}
	
	public void process(Entity entity) {
		if(this.world.getMapper(SpriteComponent.class).has(entity) && this.world.getMapper(TransformComponent.class).has(entity)){
			Sprite sprite = this.world.getMapper(SpriteComponent.class).get(entity).getSprite();
			TransformComponent t = this.world.getMapper(TransformComponent.class).get(entity);

			sprite.setCenter(t.getPos().cpy().x + t.getDimensions().x/2, t.getPos().cpy().y + t.getDimensions().y/2);
			sprite.setRotation(t.getAngle());

			batch.begin();
			sprite.draw(batch);	

			batch.end();
		}
		else if(this.world.getMapper(TileMapComponent.class).has(entity)){
			int[] layers = {0, 1};
			this.world.getMapper(TileMapComponent.class).get(entity).getRenderer().render(layers);
		}
	}

	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub
		
	}
}
