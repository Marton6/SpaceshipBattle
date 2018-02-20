package GameObjects;

import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

/**
 * Created by marton on 7/5/16.
 */
public class Bullet extends GameObject {
    private float time_elapsed;
    private float damage;
    private float bulletSpeed;

    public Bullet(float x, float y, float w, float h, String sprite_name, float damage, float bulletSpeed, Level lvl) {
        super(x, y, w, h, sprite_name, lvl);
        time_elapsed = 0;
        this.damage = damage;
        this.bulletSpeed = bulletSpeed;
    }

    public void update(float t){
        GameObject go;
        if((go = lvl.getObjectAt(x, y+h, this)) != null && go != lvl.getPlayer()){
            go.collide(damage);
            System.out.print(go.getClass());
            lvl.removeObject(this);
        }
        y += bulletSpeed*t;

        time_elapsed += t;

        if(time_elapsed > 2)lvl.removeObject(this);
    }
}
