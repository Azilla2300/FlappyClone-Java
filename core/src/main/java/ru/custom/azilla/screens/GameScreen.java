package ru.custom.azilla.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

import ru.custom.azilla.characters.Bird;
import ru.custom.azilla.constants.GameSettings;
import ru.custom.azilla.components.MovingBackdrop;
import ru.custom.azilla.MyGdxGame;
import ru.custom.azilla.components.TextView;
import ru.custom.azilla.characters.Tube;
import ru.custom.azilla.managers.MemoriesManager;

public class GameScreen implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;

    Random random = new Random();

    Bird bird;
    Tube[] tubeArray;
    MovingBackdrop backdrop;
    TextView pointCounterTxt;

    int tubeWidth = 136;
    int distanceBetweenPipes;
    public int pointCounter;
    boolean restared;
    public GameScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.batch = myGdxGame.batch;

        backdrop = new MovingBackdrop(1);
        bird = new Bird(100, GameSettings.SCREEN_Y / 2 - 17 * 5,
            17 * 10, 12 * 10, myGdxGame.audioManager);
        pointCounterTxt = new TextView(100, 100,
            "Points: ", false);
        tubeArray = new Tube[GameSettings.COUNT_OF_PIPES];
        distanceBetweenPipes = (tubeWidth + GameSettings.SCREEN_X)
            / GameSettings.COUNT_OF_PIPES;
        for (int i = 0; i < tubeArray.length; i++) {
            tubeArray[i] = new Tube(GameSettings.SCREEN_X + i * distanceBetweenPipes);
        }
        pointCounter = 0;
        restared = true;
    }
    @Override
    public void show() {
        myGdxGame.audioManager.playMusic(1);
    }

    public void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void render(float delta) {
        bird.move();
        backdrop.move();
        ScreenUtils.clear(Color.ORANGE);
        batch.begin();
        backdrop.draw(batch);
        bird.draw(batch);
        for (Tube tube : tubeArray) {
            tube.draw(batch);
            if (tube.shouldAddPoints(bird)) pointCounter++;
            tube.move();
            if (tube.isHit(bird)) {
                transition();
            }
        }
        pointCounterTxt.draw(batch, "Points: " + pointCounter);
        batch.end();
        handleInput();
    }

    private void transition() {
        System.out.println("We got a hit!" + random.nextInt(1000000000));
        myGdxGame.audioManager.playSound(1);
        if (restared) {
            Integer[] results = MemoriesManager.readResults();
            Integer buffer = pointCounter;
            for (int i = 0; i < results.length; i++) {
                if (results[i] < buffer) {
                    int buffer2 = results[i];
                    results[i] = buffer;
                    buffer = buffer2;
                }
            }
            MemoriesManager.saveResults(results);
        }
        restared = false;
        myGdxGame.setScreen(myGdxGame.restartScreen);
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
        myGdxGame.audioManager.stopMusic(1);
    }

    @Override
    public void dispose() {
        transition();
        bird.dispose();
        for (Tube tube : tubeArray) {
            tube.dispose();
        }
        backdrop.dispose();
        pointCounterTxt.dispose();
    }
}
