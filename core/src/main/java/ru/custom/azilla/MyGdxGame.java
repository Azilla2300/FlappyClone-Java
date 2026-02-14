package ru.custom.azilla;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGdxGame extends ApplicationAdapter {
    Random random = new Random();
    private SpriteBatch batch;
    private Bird bird;
    private Tube[] tubeArray;
    int tubeWidth = 136;
    int distanceBetweenPipes;

    @Override
    public void create() {
        System.out.println("Where is output?");
        batch = new SpriteBatch();
        bird = new Bird(100, 100, 17 * 10, 12 * 10);
        tubeArray = new Tube[GameSettings.COUNT_OF_PIPES];
        distanceBetweenPipes = (tubeWidth + GameSettings.SCREEN_X) / GameSettings.COUNT_OF_PIPES;
        for (int i = 0; i < tubeArray.length; i++) {
            tubeArray[i] = new Tube(
                GameSettings.SCREEN_X + i * distanceBetweenPipes
            );
        }
    }

    @Override
    public void render() {

        handleInput();
        bird.move();
        for (Tube tube : tubeArray) {
            tube.move();
            if (tube.isHit(bird)) System.out.println("We got a hit!" + random.nextInt(1000000000));
        }
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        bird.draw(batch);
        for (Tube tube : tubeArray) {
            tube.draw(batch);
        }
        batch.end();
    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        bird.dispose();
        for (Tube tube : tubeArray) {
            tube.dispose();
        }
    }
}
