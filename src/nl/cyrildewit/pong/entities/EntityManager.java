package nl.cyrildewit.pong.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import nl.cyrildewit.engine.GameContainer;

public class EntityManager {

	private GameContainer gc;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};

	public EntityManager(GameContainer gc) {
		this.gc = gc;
		entities = new ArrayList<Entity>();
	}

	public void tick() {
		Iterator<Entity> it = entities.iterator();

		while(it.hasNext()){
			Entity e = it.next();
			e.tick();
			if(! e.isActive()) {
				it.remove();
			}

		}
		entities.sort(renderSorter);
	}

	public void render(Graphics g) {
		for(Entity e : entities){
			e.render(g);
		}
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public GameContainer getHandler() {
		return gc;
	}

	public void setHandler(GameContainer gc) {
		this.gc = gc;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
