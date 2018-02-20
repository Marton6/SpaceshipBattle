package UIObjects;

import com.marton.spaceshipbattle.Game;
import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

import GameObjects.AsteroidSpawner;
import GameObjects.HealthBar;
import GameObjects.ReloadBar;
import GameObjects.Ships.EnemyShip;
import GameObjects.Ships.GunnerShip;
import GameObjects.Ships.SpaceshipHunter;
import GameObjects.Ships.SpaceshipQuick;

/**
 * Created by marton on 7/4/16.
 */
public class ShipButton extends GameObject {
    private int ship;

    public ShipButton(float x, float y, float w, float h, String sprite_name, int ship, Level lvl) {
        super(x, y, w, h, sprite_name, lvl);
        this.ship = ship;
    }

    @Override
    public void collide(float dmg) {
        lvl.empty();

        switch (ship){
            case 0:
                lvl.spawnObject(lvl.setPlayer(new SpaceshipQuick(10, 5, lvl)));
                break;
            case 1:
                lvl.spawnObject(lvl.setPlayer(new GunnerShip(10, 5, lvl)));
                break;
            case 2:
                lvl.spawnObject(lvl.setPlayer(new SpaceshipHunter(10, 5, lvl)));
                break;
        }

        EnemyShip enemyShip = new EnemyShip(50, 100, 10, 10, 100, "object_sprites/spaceship_enemy.png", lvl);
        lvl.spawnObject(new HealthBar(0, Game.GAME_HEIGHT-2, Game.GAME_WIDTH, 2, enemyShip, lvl));
        lvl.spawnObject(new AsteroidSpawner(0, Game.GAME_HEIGHT+10, .5f, lvl));
        lvl.spawnObject(enemyShip);
        lvl.spawnObject(new ReloadBar(0, 0, Game.GAME_WIDTH, 2, lvl.getPlayer(), lvl));

    }
}
