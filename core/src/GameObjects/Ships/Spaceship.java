package GameObjects.Ships;

import com.badlogic.gdx.Gdx;
import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

/**
 * Created by marton on 7/2/16.
 */
public class Spaceship extends GameObject {
    protected float speed;

    public Spaceship(int x, int y, int w, int h, float steering_speed, String sprite_name, Level lvl) {
        super(x, y, w, h, sprite_name, lvl);
        this.speed = steering_speed;
    }

    public void kill(){
        lvl.removeObject(this);
    }
}
