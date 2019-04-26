package com.myspace.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {
    private Texture bg;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            gsm.set(new PlayState(gsm));
    }

    @Override
    public void update(float dt) {
        this.handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0,0,480,800);
        sb.draw(playButton,200,400,70,50);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        playButton.dispose();
    }
}
