package nl.cyrildewit.pong.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import nl.cyrildewit.pong.Handler;

public abstract class Entity {

	protected Handler handler;
	protected EntityType type;
	protected float x, y;
	protected int width, height;
	protected boolean active = true;
	protected Rectangle bounds;

	public Entity(Handler handler, EntityType type, float x, float y, int width, int height) {
		this.handler = handler;
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle(0, 0, width, height);
	}

    public abstract void tick();

	public abstract void render(Graphics g);

	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		EntityManager enitityManager = (EntityManager) handler.getWorld().getEntityManager();

		for(Entity e : enitityManager.getEntities()) {
			if(e.equals(this)) {
				continue;
			}

			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}

		return false;
	}

	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public EntityType getType() {
		return type;
	}

	public void setId(EntityType type) {
		this.type = type;
	}

}
