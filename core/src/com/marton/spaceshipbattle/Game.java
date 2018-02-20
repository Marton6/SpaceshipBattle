package com.marton.spaceshipbattle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import GameObjects.Ships.GunnerShip;
import GameObjects.Ships.SpaceshipQuick;
import UIObjects.PlayButton;

public class Game extends ApplicationAdapter {
    public final static float GAME_HEIGHT = 141;
    public final static float GAME_WIDTH = 100;

	private SpriteBatch batch;
	private Level lvl;
	private boolean paused;
    private OrthographicCamera camera;
    private FitViewport viewport;
    private Sprite bg;
    private float bg_delta;

	@Override
	public void create () {
		batch = new SpriteBatch();

        float aspect_ratio = Gdx.graphics.getHeight()/Gdx.graphics.getWidth();

        camera = new OrthographicCamera();
        viewport = new FitViewport(GAME_WIDTH*aspect_ratio, GAME_HEIGHT, camera);
        viewport.apply();
        camera.position.set(GAME_WIDTH/2, GAME_HEIGHT/2, 0);

		//initializing
        bg = new Sprite(new Texture("object_sprites/background.png"));
        bg_delta = 0;

        lvl = new Level();
        lvl.spawnObject(new PlayButton(GAME_WIDTH/2-10, GAME_HEIGHT/2-5, 20, 10, lvl));
        lvl.spawnObject(lvl.setPlayer(new SpaceshipQuick(10, 5, lvl)));
        paused=false;
	}

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.position.set(GAME_WIDTH/2, GAME_HEIGHT/2, 0);
    }

    @Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.begin();
        batch.draw(bg, 0, -bg_delta, GAME_WIDTH, GAME_HEIGHT);
        batch.draw(bg, 0, GAME_HEIGHT-bg_delta, GAME_WIDTH, GAME_HEIGHT);

        bg_delta +=Gdx.graphics.getDeltaTime()*20;
        if(bg_delta>GAME_HEIGHT)bg_delta=0;

		if(!paused) {
            batch.setProjectionMatrix(camera.combined);
			lvl.draw(batch);
		}
        batch.end();
        if(!paused)lvl.update(Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f));
	}

    public void pause_game() {
        paused = !paused;
    }

    @Override
	public void dispose () {
		batch.dispose();
		lvl.dispose();
        bg.getTexture().dispose();
	}


}
