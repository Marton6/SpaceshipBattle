package GameObjects;

import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

import GameObjects.Ships.EnemyShip;
import GameObjects.Ships.Spaceship;

/**
 * Created by marton on 7/3/16.
 */
public class HealthBar extends GameObject {
    private EnemyShip ship;
    private float maxW, currW;
    public HealthBar(float x, float y, float w, float h, EnemyShip ship, Level lvl) {
        super(x, y, w, h, "object_sprites/healthbar.png", lvl);
        this.ship = ship;
        maxW = w;
        currW = w;
    }

    @Override
    public void update(float t) {
        currW=ship.getHealth()/ship.getMaxHealth()*maxW;
        w = w-(w-currW)/(200*t);
    }
}
