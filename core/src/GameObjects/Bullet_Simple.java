package GameObjects;

import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

/**
 * Created by marton on 7/2/16.
 */
public class Bullet_Simple extends Bullet {

    public Bullet_Simple(float x, float y, float dmg, Level lvl) {
        super(x, y, 1, 3, "object_sprites/Bullet_Simple.png", dmg, 250, lvl);
    }


}
