package UIObjects;

import com.marton.spaceshipbattle.Game;
import com.marton.spaceshipbattle.GameObject;
import com.marton.spaceshipbattle.Level;

import GameObjects.Ships.SpaceshipQuick;

/**
 * Created by marton on 7/4/16.
 */
public class GameOverButton extends GameObject {
    public GameOverButton(float x, float y, float w, float h, Level lvl) {
        super(x, y, w, h, "ui/game_over_button.png", lvl);
    }

    @Override
    public void collide(float dmg) {
        lvl.empty();
        lvl.spawnObject(new PlayButton(Game.GAME_WIDTH/2-10, Game.GAME_HEIGHT/2-5, 20, 10, lvl));
        lvl.spawnObject(lvl.setPlayer(new SpaceshipQuick(10, 5, lvl)));
    }
}
