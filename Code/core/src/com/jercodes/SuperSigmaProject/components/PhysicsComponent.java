package com.jercodes.SuperSigmaProject.components;

import com.artemis.Component;
import com.artemis.World;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.jercodes.SuperSigmaProject.systems.PhysicsSystem;

public class PhysicsComponent extends Component{
	public static float phys2Pixel = 64;
	public static float pixel2Phys = 1/64f;
	
	public static final short PLAYER_CAT_BIT = 0x0001;
	public static final short ENEMY_CAT_BIT = 0x0002;
	public static final short PROJECTILE_CAT_BIT = 0x0004;
	public static final short ENVIROMENT_CAT_BIT = 0x0008;
		
	public static final short PLAYER_MASK = PLAYER_CAT_BIT | ENEMY_CAT_BIT | PROJECTILE_CAT_BIT | ENVIROMENT_CAT_BIT;
	public static final short ENEMY_MASK = PLAYER_CAT_BIT | ENEMY_CAT_BIT | PROJECTILE_CAT_BIT | ENVIROMENT_CAT_BIT;
	public static final short PROJECTILE_MASK = ENEMY_CAT_BIT | PROJECTILE_CAT_BIT | ENVIROMENT_CAT_BIT;
	public static final short ENVIROMENT_MASK = PLAYER_CAT_BIT | ENEMY_CAT_BIT | PROJECTILE_CAT_BIT | ENVIROMENT_CAT_BIT;
	
	public World world;
		
	private boolean isStatic;
	
	private short categoryBits;
	private short maskBits;
	
	private Body body;
	private Fixture fixture;	
	private FixtureDef fixDef = new FixtureDef();
	
	private float density;
	private Shape shape;
	
	private float movementSpeed;
	
	public PhysicsComponent(short categoryBit, short maskBit, boolean isStatic, Shape shape, World world, float movementSpeed){
		this.categoryBits = categoryBit;
		this.maskBits = maskBit;
		this.isStatic = isStatic;
		this.shape = shape;
		this.world = world;
		this.movementSpeed = movementSpeed;
		
	}


	public boolean isStatic() {
		return isStatic;
	}


	public short getCategoryBits() {
		return categoryBits;
	}


	public short getMaskBits() {
		return maskBits;
	}


	public Body getBody() {
		return body;
	}
	
	public void setBody(Body body){
		this.body = body;
	}


	public Fixture getFixture() {
		return fixture;
	}


	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}


	public FixtureDef getFixDef() {
		return fixDef;
	}


	public Shape getShape() {
		return shape;
	}


	public float getDensity(){
		return density;
	}


	public float getMovementSpeed() {
		return movementSpeed;
	}
	
	
	
}
