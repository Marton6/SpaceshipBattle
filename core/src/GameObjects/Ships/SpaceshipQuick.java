package GameObjects.Ships;

import com.marton.spaceshipbattle.*;

import GameObjects.*;

/**
 * Created by marton on 7/3/16.
 */
public class SpaceshipQuick extends PlayerShip {
    public SpaceshipQuick(int x, int y, Level lvl) {
        super(x, y, 10, 10, .7f, 200, "object_sprites/Spaceship_Quick.png",  lvl);
    }

    @Override
    protected void shoot() {
        lvl.spawnObject(new GameObjects.Bullet_Simple(x+w/2, y+h, 7.5f, lvl));
    }
}
