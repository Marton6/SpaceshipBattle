package GameObjects.Ships;

import com.badlogic.gdx.graphics.Cursor;
import com.marton.spaceshipbattle.Level;

import GameObjects.EnemyBullet;

/**
 * Created by marton on 7/7/16.
 */
public class ShooterEnemy extends EnemyShip {
    private long lastFire;
    private int reloadTime;

    public ShooterEnemy(int x, int y, int w, int h, float shield_health, float shield_regen, float health, Level lvl) {
        super(x, y, w, h, shield_health, shield_regen, health, "object_sprites/gunner_ship.png", lvl);
        lastFire = System.currentTimeMillis();
        reloadTime = 750;
    }

    @Override
    public void update(float t) {
        super.update(t);
        if(Math.abs(lvl.getPlayer().getX()-x)<5 && (System.currentTimeMillis()-lastFire)>reloadTime){
            shootBack();
            lastFire = System.currentTimeMillis();
        }
    }

    @Override
    protected void shoot() {
        //
    }

    protected void shootBack() {
        lvl.spawnObject(new EnemyBullet(x+w/2, y, lvl));
    }
}
