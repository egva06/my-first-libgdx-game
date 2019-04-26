package com.myspace.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Bullet {
    private Texture texture;
    private Vector3 position;
    private float Velocity = 5;

    public Bullet(float x,float y) {
        texture = new Texture("laser.png");
        position = new Vector3(x,y,0);
    }
    public Texture getTexture() {
        return texture;
    }
    public Vector3 getPosition() {
        return position;
    }
    public float getVelocity() {
        return position.y+=Velocity;
    }


}
