package com.marton.spaceshipbattle;

import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;

import GameObjects.AsteroidSpawner;
import GameObjects.Bullet_Simple;
import GameObjects.HealthBar;
import GameObjects.ReloadBar;
import GameObjects.ShieldBar;
import GameObjects.Ships.AgileEnemy;
import GameObjects.Ships.EnemyShip;
import GameObjects.Ships.PlayerShip;
import GameObjects.Ships.ShooterEnemy;
import GameObjects.Ships.Spaceship;
import GameObjects.Ships.SpaceshipQuick;
import UIObjects.GameOverButton;
import UIObjects.PlayButton;

/**
 * Created by marton on 7/2/16.
 */

//TODO: Game Over screen

public class Level {
    private ArrayList<GameObject> gameObjects, temp, temp_del;
    private boolean queued, queued_del;
    private PlayerShip player;
    private int level_count;

    public Level() {
        gameObjects=new ArrayList<GameObject>();

        temp = new ArrayList<GameObject>();
        temp_del = new ArrayList<GameObject>();
        queued = false;
        queued_del = false;
        level_count = 1;
    }

    public void spawnObject(GameObject go){
        temp.add(go);
        queued = true;
    }

    public void removeObject(GameObject go){
        queued_del = true;
        temp_del.add(go);
    }

    public void draw(Batch batch){
        for(GameObject go:gameObjects){
            go.draw(batch);
        }
    }

    public void update(float t){
        for(GameObject go:gameObjects){
            go.update(t);
        }
        if(queued){
            gameObjects.addAll(temp);
            temp.clear();
            queued = false;
        }

        if(queued_del){
            gameObjects.removeAll(temp_del);
            temp_del.clear();
            queued_del = false;
        }
    }

    public void dispose() {
        for(GameObject go:gameObjects){
            go.dispose();
        }
    }

    public Spaceship setPlayer(PlayerShip player) {
        this.player = player;
        return player;
    }

    public GameObject getObjectAt(float x, float y, GameObject caller){
        for(GameObject go:gameObjects){
            if(go.x <= x && (go.x + go.w) >= x && go.y<=y && (go.y + go.h) >= y && go!=caller && !(go instanceof Bullet_Simple))return go;
        }
        return null;
    }

    public boolean checkPlayerCollision(float x, float y){
        if(player.x <= x && player.x + player.w >= x&& player.y <= y && player.y + player.h >= y)return true;
        return false;
    }

    public void killPlayer() {
        emptySavePlayer();
        spawnObject(new GameOverButton(Game.GAME_WIDTH/2-25, Game.GAME_HEIGHT/2-2.5f, 50, 5, this));
    }

    public void empty() {
        temp_del.addAll(gameObjects);
        queued_del = true;
    }

    public void emptySavePlayer() {
        for(GameObject go : gameObjects){
            if(go!=player)temp_del.add(go);
        }
        queued_del = true;
    }

    public PlayerShip getPlayer(){
        return player;
    }

    public void nextLevel(){
        level_count++;
        switch (level_count){
            case 2:
                emptySavePlayer();

                spawnObject(new AsteroidSpawner(0, Game.GAME_HEIGHT+10, .75f, this));

                EnemyShip e;
                spawnObject(e =new AgileEnemy(50, 100, 10, 10, "object_sprites/spaceship_enemy.png", this));
                spawnObject(new HealthBar(0, Game.GAME_HEIGHT-2, Game.GAME_WIDTH, 2, e, this));
                spawnObject(new ShieldBar(0, Game.GAME_HEIGHT-2, Game.GAME_WIDTH, 2, e, this));
                spawnObject(new ReloadBar(0, 0, Game.GAME_WIDTH, 2, getPlayer(), this));
                break;
            case 3:
                emptySavePlayer();
                ShooterEnemy e1 = new ShooterEnemy(50, 120, 15, 10, 0, 0, 200, this);
                ShooterEnemy e2 = new ShooterEnemy(70, 100, 15, 10, 0, 0, 200, this);

                spawnObject(new HealthBar(0, Game.GAME_HEIGHT-2, Game.GAME_WIDTH, 2, e1, this));
                spawnObject(new HealthBar(0, Game.GAME_HEIGHT-4, Game.GAME_WIDTH, 2, e2, this));

                spawnObject(e1);
                spawnObject(e2);

                spawnObject(new ReloadBar(0, 0, Game.GAME_WIDTH, 2, getPlayer(), this));
                break;
            case 4:
                break;

            case 5:
                emptySavePlayer();
                ShooterEnemy e3 = new ShooterEnemy(50, 120, 15, 10, 150, 5, 300, this);

                spawnObject(new HealthBar(0, Game.GAME_HEIGHT-2, Game.GAME_WIDTH, 2, e3, this));
                spawnObject(new ShieldBar(0, Game.GAME_HEIGHT-4, Game.GAME_WIDTH, 2, e3, this));

                spawnObject(e3);

                spawnObject(new ReloadBar(0, 0, Game.GAME_WIDTH, 2, getPlayer(), this));
                break;
        }
    }
}