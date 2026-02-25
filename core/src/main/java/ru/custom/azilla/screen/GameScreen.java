package ru.custom.azilla.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

import ru.custom.azilla.Bird;
import ru.custom.azilla.GameSettings;
import ru.custom.azilla.MovingBackdrop;
import ru.custom.azilla.MyGdxGame;
import ru.custom.azilla.TextView;
import ru.custom.azilla.Tube;

public class GameScreen implements Screen {

    Random random = new Random();
    private Bird bird;
    private Tube[] tubeArray;
    int tubeWidth = 136;
    int distanceBetweenPipes;
    MovingBackdrop backdrop;
    TextView pointCounterTxt;
    int pointCounter;
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.batch = myGdxGame.batch;

        backdrop = new MovingBackdrop();
        bird = new Bird(100, 100, 17 * 10, 12 * 10);
        pointCounterTxt = new TextView(100, 100);
        tubeArray = new Tube[GameSettings.COUNT_OF_PIPES];
        distanceBetweenPipes = (tubeWidth + GameSettings.SCREEN_X) / GameSettings.COUNT_OF_PIPES;
        for (int i = 0; i < tubeArray.length; i++) {
            tubeArray[i] = new Tube(
                GameSettings.SCREEN_X + i * distanceBetweenPipes
            );
        }
        pointCounter = 0;
    }
    @Override
    public void show() {

    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void render(float delta) {
        handleInput();
        bird.move();
        backdrop.move();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        backdrop.draw(batch);
        bird.draw(batch);
        for (Tube tube : tubeArray) {
            tube.draw(batch);
            if (tube.shouldAddPoints(bird)) pointCounter++;
            tube.move();
            if (tube.isHit(bird)) {
                System.out.println("We got a hit!" + random.nextInt(1000000000));
            }
        }
        pointCounterTxt.draw(batch, "Points: " + pointCounter);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bird.dispose();
        for (Tube tube : tubeArray) {
            tube.dispose();
        }
        backdrop.dispose();
        pointCounterTxt.dispose();
    }
}
