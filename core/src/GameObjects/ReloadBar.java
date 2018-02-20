package GameObjects;

import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

import GameObjects.Ships.EnemyShip;
import GameObjects.Ships.PlayerShip;

/**
 * Created by marton on 7/3/16.
 */
public class ReloadBar extends GameObject {
    private PlayerShip ship;
    private float maxW, currW;
    public ReloadBar(float x, float y, float w, float h, PlayerShip ship, Level lvl) {
        super(x, y, w, h, "object_sprites/healthbar.png", lvl);
        this.ship = ship;
        maxW = w;
        currW = w;
    }

    @Override
    public void update(float t) {
        currW=ship.getReloadWaitingTime()/ship.getReloadTime()*maxW;

        w = w-(w-currW)/(200*t);
    }
}
