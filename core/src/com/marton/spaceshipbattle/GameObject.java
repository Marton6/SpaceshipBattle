package com.marton.spaceshipbattle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by marton on 7/2/16.
 */
public class GameObject {
    protected float x, y, w, h;
    private Sprite sprite;
    private Texture t;
    protected Level lvl;

    public GameObject(float x, float y, float w, float h, String sprite_name, Level lvl) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.lvl = lvl;

        t=new Texture(sprite_name);
        sprite = new Sprite(t);
    }

    public void draw(Batch batch){
        batch.draw(sprite, x, y, w, h);
    }

    public void update(float t){}

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getW() {
        return w;
    }

    public float getH() {
        return h;
    }

    public void collide(float damage){

    }

    public void dispose() {
        t.dispose();
    }

}
