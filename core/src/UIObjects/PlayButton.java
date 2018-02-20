package UIObjects;

import com.marton.spaceshipbattle.Game;
import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

import GameObjects.Ships.SpaceshipQuick;

/**
 * Created by marton on 7/4/16.
 */
public class PlayButton extends GameObject {
    public PlayButton(float x, float y, float w, float h, Level lvl) {
        super(x, y, w, h, "ui/play_button.png", lvl);
    }

    @Override
    public void collide(float dmg) {
        lvl.empty();
        lvl.spawnObject(lvl.setPlayer(new SpaceshipQuick(10, 5, lvl)));
        lvl.spawnObject(new ShipButton(Game.GAME_WIDTH/4-5, Game.GAME_HEIGHT/2-5, 10, 10, "object_sprites/Spaceship_Quick.png", 0, lvl));
        lvl.spawnObject(new ShipButton(2*Game.GAME_WIDTH/4-5, Game.GAME_HEIGHT/2-5, 10, 10, "object_sprites/gunner_ship.png", 1, lvl));
        lvl.spawnObject(new ShipButton(3*Game.GAME_WIDTH/4-5, Game.GAME_HEIGHT/2-5, 10, 15, "object_sprites/hunter_ship.png", 2, lvl));
    }
}
