package com.jercodes.SuperSigmaProject.systems;

import com.artemis.Aspect;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jercodes.SuperSigmaProject.components.RenderableComponent;
import com.jercodes.SuperSigmaProject.components.SpriteComponent;
import com.jercodes.SuperSigmaProject.components.TransformComponent;

public class RenderSystem extends EntityProcessingSystem{

	private SpriteBatch batch;
	@SuppressWarnings("unchecked")
	public RenderSystem(SpriteBatch batch){
		super(Aspect.all(RenderableComponent.class, SpriteComponent.class, TransformComponent.class));

		this.batch = batch;
	}

	@Override
	protected void process(Entity e) {

		e.getComponent(SpriteComponent.class);

		Sprite sprite = e.getComponent(SpriteComponent.class).getSprite();
		TransformComponent t = e.getComponent(TransformComponent.class);

		sprite.setCenter(t.getPos().cpy().x + t.getDimensions().x/2, t.getPos().cpy().y + t.getDimensions().y/2);
		sprite.setRotation(t.getAngle());

		batch.begin();
		sprite.draw(batch);	

		batch.end();

	}

}
