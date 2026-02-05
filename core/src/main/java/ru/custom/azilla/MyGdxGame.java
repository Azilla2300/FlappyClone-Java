package ru.custom.azilla;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Bird bird;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bird = new Bird(100, 100, 17 * 10, 12 * 10, false);
    }

    @Override
    public void render() {

        handleInput();
        bird.move();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        bird.draw(batch);
        batch.end();
    }

    public void handleInput() {
        if (!GameSettings.MODE) {
            if (Gdx.input.justTouched()) {
                bird.jump();
            }
        } else dispose(); // Крашит игру
    }

    @Override
    public void dispose() {
        batch.dispose();
        bird.dispose();
    }
}
