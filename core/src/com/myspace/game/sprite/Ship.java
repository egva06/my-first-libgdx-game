package com.myspace.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Ship {
    private Vector3 position;
    private Texture texture;
    private int Velocity = 5;

    public Ship(int x,int y) {
        position = new Vector3(x,y,0);
        texture = new Texture("ship.png");
    }
    public Vector3 getPosition() {
        return position;
    }
    public Texture getTexture() {
        return texture;
    }
    public void setPositionL() {
        this.position.x -=Velocity;
    }
    public void setPositionR() {
        this.position.x +=Velocity;
    }
}
