package nl.cyrildewit.pong.entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import nl.cyrildewit.pong.Handler;
import nl.cyrildewit.pong.entities.Entity;
import nl.cyrildewit.pong.entities.EntityManager;
import nl.cyrildewit.pong.entities.ID;

public class Goal extends StaticEntry {

    public Goal(Handler handler, ID id, float x, float y, int width, int height) {
        super(handler, id, x, y, width, height);

        bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
    }

    @Override
	public void tick() {
		checkGoal();
	}

    @Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), (int) bounds.width, (int) bounds.height);
	}

    /**
     * Check if the Ball is touching the bounds of this goal.
     */
    public void checkGoal() {
    	EntityManager entityManager = (EntityManager) handler.getWorld().getEntityManager();

        for(Entity e : entityManager.getEntities()) {
        	// If the current entity isn't an instance of the Ball class, continue
            if(! e.getId().equals(ID.Ball)) {
                continue;
            }

            // Check if the entity is touching the bounds of this goal
			if(e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, 0))) {
				System.out.println("Goalll: " + getId());
			}
		}
    }

}
