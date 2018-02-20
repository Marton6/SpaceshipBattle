package GameObjects;

import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

/**
 * Created by marton on 7/5/16.
 */
public class HunterBullet extends Bullet {

    public HunterBullet(float x, float y, Level lvl) {
        super(x, y, 2, 8, "object_sprites/hunter_bullet.png", 50, 400, lvl);
    }
}
