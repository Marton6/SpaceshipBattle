package GameObjects;

import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

import GameObjects.Ships.EnemyShip;

/**
 * Created by marton on 7/3/16.
 */
public class ShieldBar extends GameObject {
    private EnemyShip ship;
    private float maxW, currW;

    public ShieldBar(float x, float y, float w, float h, EnemyShip ship, Level lvl) {
        super(x, y, w, h, "object_sprites/shieldbar.png", lvl);
        this.ship = ship;
        maxW = w;
        currW = w;
    }

    @Override
    public void update(float t) {
        currW=ship.getShield_health()/ship.getShield_max_health()*maxW;
        w = w-(w-currW)/(200*t);
    }
}
