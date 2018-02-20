package GameObjects.Ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.marton.spaceshipbattle.*;

/**
 * Created by marton on 7/3/16.
 */
public class PlayerShip extends Spaceship {
    private float elapsed_time;
    private long lastFire;
    private long reloadTime;

    public PlayerShip(int x, int y, int w, int h, float steering_speed, long reload_time, String sprite_name, Level lvl) {
        super(x, y, w, h, steering_speed, sprite_name, lvl);
        this.elapsed_time = 0;
        this.reloadTime = reload_time;
        lastFire = System.currentTimeMillis();
    }

    public void update(float t){
        move(Gdx.input.getAccelerometerX()*t*100);

        if(Gdx.input.isTouched()&&(System.currentTimeMillis()-lastFire)>reloadTime){
            shoot();
            lastFire = System.currentTimeMillis();
        }
    }

    private void move(float dist){
        if(x - dist*speed + w/2 >=0 && x - dist*speed + w/2 <=100)
            x -= dist*speed;
    }

    protected void shoot(){

    }

    public float getReloadTime(){
        return reloadTime;
    }

    public float getReloadWaitingTime(){
        return System.currentTimeMillis() - lastFire;
    }

    @Override
    public void collide(float damage) {
        lvl.killPlayer();
    }
}
