package GameObjects;

import com.marton.spaceshipbattle.*;

/**
 * Created by marton on 7/3/16.
 */
public class Asteroid extends GameObject {
    private float speed = 75;
    private float health = 30;

    public Asteroid(float x, float y, float w, float h, Level lvl) {
        super(x, y, w, h, "object_sprites/asteroid.png", lvl);
    }

    @Override
    public void update(float t) {
        y -= t*speed;

        //Check if it is out of bounds
        if(y + h < 0) lvl.removeObject(this);

        //Check for collision
        if(lvl.checkPlayerCollision(x, y) ||
           lvl.checkPlayerCollision(x+w, y) ||
           lvl.checkPlayerCollision(x, y+h) ||
           lvl.checkPlayerCollision(x+w, y+h))
            lvl.killPlayer();
    }

    @Override
    public void collide(float damage) {
        health -= damage;
        //speed /= 2;

        if(health <= 0) lvl.removeObject(this);
    }
}
