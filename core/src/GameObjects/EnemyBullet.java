package GameObjects;

import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

import GameObjects.Ships.PlayerShip;

/**
 * Created by marton on 7/7/16.
 */
public class EnemyBullet extends GameObject {
    private float elapsed_time;

    public EnemyBullet(float x, float y, Level lvl) {
        super(x, y, 2, 5, "object_sprites/Bullet_Simple.png", lvl);
        elapsed_time = 0;
    }

    @Override
    public void update(float t) {
        y-=150*t;
        elapsed_time+=t;
        if(elapsed_time>2)lvl.removeObject(this);

        GameObject go;
        if((go = lvl.getObjectAt(x, y, this))!=null && go instanceof PlayerShip){
            go.collide(0);
            lvl.removeObject(this);
        }
    }


}
