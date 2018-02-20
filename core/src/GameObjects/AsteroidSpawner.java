package GameObjects;

import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

import java.util.Random;

/**
 * Created by marton on 7/3/16.
 */
public class AsteroidSpawner extends GameObject {
    private float rate, elapsed_time;
    private Random random;

    public AsteroidSpawner(float x, float y, float rate, Level lvl) {
        super(x, y, 1, 1, "object_sprites/blank.png", lvl);
        this.rate = rate;
        this.elapsed_time = 0;
        random = new Random();
    }

    public void update(float t){
        elapsed_time += t;

        if(elapsed_time > rate){
            float size = random.nextFloat()*10+5;
            lvl.spawnObject(new Asteroid(random.nextFloat()*100, y, size, size, lvl));

            elapsed_time -= rate;
        }

    }
}
