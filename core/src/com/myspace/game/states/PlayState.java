package com.myspace.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.myspace.game.SpaceGame;
import com.myspace.game.sprite.Bullet;
import com.myspace.game.sprite.Enemy;
import com.myspace.game.sprite.Ship;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PlayState extends State {
    Texture bg;
    Ship ship;
    ArrayList<Bullet> bullets;
    ArrayList<Enemy> enemies;
    private int EnemyCount = 3;
    Random random;
    float distance;
    float [] enemyOffSet;
    Circle[] EnemyCircle;
    Circle[] EnemyCircle2;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("background.png");
        ship = new Ship(SpaceGame.WIDTH/2 - 25,60);
        bullets = new ArrayList<Bullet>();
        enemies = new ArrayList<Enemy>();

        random = new Random();
        int rand = random.nextInt(70);



        enemies.add(new Enemy(700));
        enemies.add(new Enemy(700));
        enemies.add(new Enemy(700));
        EnemyCircle = new Circle[3];
        EnemyCircle2 = new Circle[3];



    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            ship.setPositionL();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            ship.setPositionR();
        if (Gdx.input.justTouched())
            bullets.add(new Bullet(ship.getPosition().x+23,ship.getPosition().y+35));


    }

    @Override
    public void update(float dt) {
        this.handleInput();
        for (Enemy enemy : enemies) {
            enemy.Update();
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0,0,480,800);
        sb.draw(ship.getTexture(),ship.getPosition().x,ship.getPosition().y,50,50);

        for (Bullet bullet : bullets) {
            sb.draw(bullet.getTexture(),bullet.getPosition().x,bullet.getVelocity(),5,15);
        }
        int i = 0;
        for (Enemy enemy : enemies) {

            sb.draw(enemy.getTexture1(),enemy.getPosition1().x,enemy.getPosition1().y,50,50);
            sb.draw(enemy.getTexture2(),enemy.getPosition2().x,enemy.getPosition2().y,50,50);

            EnemyCircle[i] = new Circle(enemy.getPosition1().x,enemy.getPosition1().y,50);
            EnemyCircle2[i] = new Circle(enemy.getPosition2().x,enemy.getPosition2().y,50);
            i++;
        }

        sb.end();
    }



    @Override
    public void dispose() {

    }
}
