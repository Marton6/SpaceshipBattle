package GameObjects.Ships;

import com.marton.spaceshipbattle.*;

import java.util.Random;

import GameObjects.*;

/**
 * Created by marton on 7/3/16.
 */
public class EnemyShip extends Spaceship {
    private Random random;
    protected float dist;
    private float elapsed_time;
    protected float health, maxhealth;
    private float shield_health, shield_regen, shield_max_health;

    public EnemyShip(int x, int y, int w, int h, float shield_health, float shield_regen, float health, String sprite_name, Level lvl) {
        super(x, y, w, h, 50, sprite_name, lvl);
        random = new Random();
        elapsed_time=0;
        dist = ((random.nextFloat() * 2 * speed) - speed);
        this.shield_health = shield_health;
        this.shield_regen = shield_regen;
        shield_max_health = shield_health;
        this.health = health;
        maxhealth=health;
    }

    public EnemyShip(int x, int y, int w, int h, float health, String sprite_name, Level lvl) {
        super(x, y, w, h, 50, sprite_name, lvl);
        random = new Random();
        elapsed_time=0;
        dist = ((random.nextFloat() * 2 * speed) - speed);
        this.shield_health = 0;
        this.shield_regen = 0;
        shield_max_health = 0;
        this.health = health;
        maxhealth = health;
    }

    public void update(float t){
        if(shield_health<=0){
            shield_max_health=0;
            shield_health = 0;
        }
        if(shield_health < shield_max_health){
            shield_health += shield_regen*t;
        }

        move(t);

        elapsed_time+=t;
        if(elapsed_time>=1) {
            recalc();
            elapsed_time-=1;
        }
    }

    protected void recalc(){
        dist = ((random.nextFloat() * 2 * speed) - speed);
    }

    private void move(float t){
        if(lvl.getObjectAt(x+dist*t+w/2, y+h/2+5, this)==null && lvl.getObjectAt(x+dist*t+w/2, y+h/2, this)==null && x+dist*t <= 100-w && x+dist*t >= 0 )
            x+=dist*t;
        else if(lvl.getObjectAt(x-dist*t+w/2, y+h/2+5, this)==null && lvl.getObjectAt(x-dist*t+w/2, y+h/2, this)==null && x+dist*t<= 100-w && x+dist*t >= 0)
            x-=dist*t;
        else{
            shoot();
            shoot();
            recalc();
        }
    }

    protected void shoot() {
        lvl.spawnObject(new GameObjects.Bullet_Simple(x+w/2, y+h, 20, lvl));
    }

    public void collide(float damage) {
        if(shield_health<=0){
            health -= damage;
            if(health <= 0)die();
        }
        else{
            shield_health -= damage;
        }
    }

    public float getHealth() {
        return health;
    }
    protected void die(){
        lvl.removeObject(this);
        lvl.nextLevel();
    }

    public float getShield_health() {
        return shield_health;
    }

    public float getShield_max_health() {
        return shield_max_health;
    }

    public float getMaxHealth(){
        return maxhealth;
    }
}
