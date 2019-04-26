package com.myspace.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class Enemy {
    private Texture texture1;
    private Texture texture2;
    private Vector3 position1;
    private Vector3 position2;
    private float Velocity = 2;
    Random random;
    public Enemy(float y) {
        random = new Random();

        texture1 = new Texture("enemy1.png");
        texture2 = new Texture("enemyRed1.png");
        position1 = new Vector3(random.nextInt(300),y,0);
        position2 = new Vector3(random.nextInt(200),getPosition1().y+300,0);

    }
    public Texture getTexture1() {
        return texture1;
    }
    public Texture getTexture2() {
        return texture2;
    }
    public Vector3 getPosition1() {
        return position1;
    }
    public Vector3 getPosition2() {
        return position2;
    }
    public void Update() {
        position1.y -=Velocity;
        position2.y -=Velocity;
        if (position1.y < 0) {
            position1.y =850;
            position1.x = random.nextInt(300);
        }

    }


}
