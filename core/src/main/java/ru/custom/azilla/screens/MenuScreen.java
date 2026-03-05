package ru.custom.azilla.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.custom.azilla.components.MovingBackdrop;
import ru.custom.azilla.components.TextView;
import ru.custom.azilla.constants.GameSettings;
import ru.custom.azilla.MyGdxGame;
import ru.custom.azilla.components.TextButton;

public class MenuScreen implements Screen {
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    TextButton startButton;
    TextButton settingsButton;
    TextButton exitButton;
    TextView title;
    MovingBackdrop movingBackdrop;
    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.batch = myGdxGame.batch;
        title = new TextView(GameSettings.SCREEN_X / 2,
            GameSettings.SCREEN_Y, "Flappy Clone", true);
        title.y = GameSettings.SCREEN_Y - 20;
        startButton = new TextButton(GameSettings.SCREEN_X / 4,
            GameSettings.SCREEN_Y / 4,
            GameSettings.SCREEN_X / 2,
            GameSettings.SCREEN_Y / 2,
            GameSettings.DEFAULT_BUTTON, "Start");
        settingsButton = new TextButton(GameSettings.SCREEN_X - 150,
            50, 100, 100,
            GameSettings.SETTINGS_BUTTON, "");
        exitButton = new TextButton(50, 50,
            300, 100, GameSettings.EXIT_BUTTON, "");
        movingBackdrop = new MovingBackdrop(0);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.ORANGE);
        batch.begin();
        movingBackdrop.draw(batch);
        title.draw(batch);
        startButton.draw(batch);
        settingsButton.draw(batch);
        exitButton.draw(batch);
        batch.end();
        handleInput();
    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            int trueY = GameSettings.SCREEN_Y - Gdx.input.getY();
            if (startButton.isTouched(Gdx.input.getX(), trueY)) {
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }
            if (settingsButton.isTouched(Gdx.input.getX(), trueY)) {
                myGdxGame.setScreen(myGdxGame.settingsScreen);
            }
            if (exitButton.isTouched(Gdx.input.getX(), trueY)) {
                Gdx.app.exit();
            }
        }
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
        startButton.dispose();
        settingsButton.dispose();
        exitButton.dispose();
        title.dispose();
        movingBackdrop.dispose();
    }
}
