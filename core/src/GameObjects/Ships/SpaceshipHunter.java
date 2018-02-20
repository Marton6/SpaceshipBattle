package GameObjects.Ships;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.marton.spaceshipbattle.Level;

import GameObjects.HunterBullet;

/**
 * Created by marton on 7/5/16.
 */
public class SpaceshipHunter extends PlayerShip {
    private Sprite sprite;

    public SpaceshipHunter(int x, int y, Level lvl) {
        super(x, y, 10, 15, .7f, 1000, "object_sprites/hunter_ship.png", lvl);
        sprite=new Sprite(new Texture("object_sprites/laser_aim.png"));
    }

    @Override
    protected void shoot() {
        lvl.spawnObject(new HunterBullet(x+w/2, y+h, lvl));
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        //if(Gdx.input.isTouched())batch.draw(sprite, x+w/2-.5f, y+h, .5f, 141);
    }

    @Override
    public void dispose() {
        super.dispose();
        sprite.getTexture().dispose();
    }
}
