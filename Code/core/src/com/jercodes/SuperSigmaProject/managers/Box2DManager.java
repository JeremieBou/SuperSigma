package com.jercodes.SuperSigmaProject.managers;

import com.artemis.Aspect;
import com.artemis.EntitySystem;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.jercodes.SuperSigmaProject.EntityFactory;
import com.jercodes.SuperSigmaProject.components.PhysicsComponent;
import com.jercodes.SuperSigmaProject.components.TransformComponent;

public class Box2DManager extends EntitySystem{
	private World box2DWorld;
	private EntityFactory entityFactory;

	@SuppressWarnings("unchecked")
	public Box2DManager(EntityFactory entityFactory){
		super(Aspect.all(PhysicsComponent.class, TransformComponent.class));
		box2DWorld = new World(new Vector2(0,0), true);
		this.entityFactory = entityFactory;
	}

	public void inserted(int e){
		super.inserted(e);
		System.out.println("WHOO");

		PhysicsComponent p = this.world.getMapper(PhysicsComponent.class).get(e);
		TransformComponent t = this.world.getMapper(TransformComponent.class).get(e);

		BodyDef bodyDef = new BodyDef();

		if(p.isStatic()){
			bodyDef.type = BodyDef.BodyType.StaticBody;
		}
		else{
			bodyDef.type = BodyDef.BodyType.DynamicBody;
		}

		bodyDef.position.set((t.getPos().x)*PhysicsComponent.pixel2Phys, (t.getPos().y)*PhysicsComponent.pixel2Phys);

		p.setBody(box2DWorld.createBody(bodyDef));
		if(p.getBody() != null){
			System.out.println("yay");	
		}
		else{
			System.out.println("awwww");
		}
		p.getFixDef().shape = p.getShape();
		p.getFixDef().density = p.getDensity();
		p.getFixDef().filter.categoryBits = p.getCategoryBits();
		p.getFixDef().filter.maskBits = p.getMaskBits();

		p.getBody().createFixture(p.getFixDef());


	}

	public void createShapeFromMapObject(MapObject obj){		
		System.out.println("happened");
		if(obj instanceof RectangleMapObject){
			createRectangleFromMapObject((RectangleMapObject) obj);
		}

		else if(obj instanceof CircleMapObject){
			createCircleFromMapObject((CircleMapObject) obj);
		}

		else if(obj instanceof PolygonMapObject){
			createtPolygonFromMapObject((PolygonMapObject) obj);
		}

		else if(obj instanceof PolylineMapObject){
			createPolylineFromMapObject((PolylineMapObject) obj);
		}
		else if(obj instanceof EllipseMapObject){
			Ellipse e = ((EllipseMapObject)obj).getEllipse();
			createCircleFromMapObject(new CircleMapObject(e.x, e.y, e.width));
		}
	}

	private void createRectangleFromMapObject(RectangleMapObject obj){
		Rectangle rec = obj.getRectangle();
		PolygonShape polygon = new PolygonShape();
		Vector2 dim = new Vector2(rec.width, rec.height);
		Vector2 pos = new Vector2(rec.x, rec.y);
		pos.add(dim.cpy().scl(0.5f));
		polygon.setAsBox(dim.x*PhysicsComponent.pixel2Phys/2, dim.y*PhysicsComponent.pixel2Phys/2);

		entityFactory.createEnviromentElement(pos, dim, polygon);
	}

	private void createCircleFromMapObject(CircleMapObject obj){	
		System.out.println("wtf?");
		Circle circle = obj.getCircle();
		CircleShape circleShape = new CircleShape();
		Float radius = circle.radius/2;
		Vector2 pos = new Vector2(circle.x + radius, circle.y + radius);
		circleShape.setRadius(radius*PhysicsComponent.pixel2Phys);

		entityFactory.createEnviromentElement(pos, new Vector2(radius*2, radius*2), circleShape);

	}

	private void createtPolygonFromMapObject(PolygonMapObject obj){
		Polygon poly = obj.getPolygon();
		PolygonShape polygon = new PolygonShape();

		float[] vertices = poly.getTransformedVertices();

		float[] worldVertices = new float[vertices.length];

		for (int i = 0; i < vertices.length; ++i) {
			System.out.println(vertices[i]);
			worldVertices[i] = vertices[i]*PhysicsComponent.pixel2Phys;
		}

		polygon.set(worldVertices);

		Rectangle rec = poly.getBoundingRectangle();
		System.out.println(rec);
		entityFactory.createEnviromentElement(new Vector2(rec.x, rec.y), new Vector2(rec.width, rec.height), polygon);
	}

	private void createPolylineFromMapObject(PolylineMapObject obj) {
		Polyline line = obj.getPolyline();

		float[] vertices = line.getTransformedVertices();
		Vector2[] worldVertices = new Vector2[vertices.length / 2];

		for (int i = 0; i < vertices.length / 2; ++i) {
			worldVertices[i] = new Vector2();
			worldVertices[i].x = vertices[i * 2]*PhysicsComponent.pixel2Phys;
			worldVertices[i].y = vertices[i * 2 + 1]*PhysicsComponent.pixel2Phys;
		}

		ChainShape chain = new ChainShape(); 
		chain.createChain(worldVertices);

		entityFactory.createEnviromentElement(new Vector2(line.getX(), line.getY()), new Vector2(line.getLength(), line.getLength()), chain);
	}
	public World getBox2DWorld() {
		return box2DWorld;
	}

	@Override
	protected void processSystem() {
		// TODO Auto-generated method stub

	}
}
