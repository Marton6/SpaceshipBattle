package GameObjects.Ships;

import com.marton.spaceshipbattle.Level;

/**
 * Created by marton on 7/6/16.
 */
public class GunnerShip extends PlayerShip {

    public GunnerShip(int x, int y, Level lvl) {
        super(x, y, 15, 10, .7f, 1000, "object_sprites/gunner_ship.png", lvl);
    }

    @Override
    protected void shoot() {
        lvl.spawnObject(new GameObjects.Bullet_Simple(x+w/5, y+h/2, 10, lvl));
        lvl.spawnObject(new GameObjects.Bullet_Simple(x+w/2, y+h, 10, lvl));
        lvl.spawnObject(new GameObjects.Bullet_Simple(x+w-w/5, y+h/2, 10, lvl));
    }
}
