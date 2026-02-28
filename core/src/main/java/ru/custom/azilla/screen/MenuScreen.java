package ru.custom.azilla.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.custom.azilla.GameSettings;
import ru.custom.azilla.MyGdxGame;
import ru.custom.azilla.components.TextButton;

public class MenuScreen implements Screen {
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    TextButton startButton;
    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.batch = myGdxGame.batch;
        startButton = new TextButton(GameSettings.SCREEN_X / 4,
            GameSettings.SCREEN_Y / 4,
            GameSettings.SCREEN_X / 2, GameSettings.SCREEN_Y / 2, "Start");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.ORANGE);
        batch.begin();
        startButton.draw(batch);
        batch.end();
        if (Gdx.input.justTouched()) {
            if (startButton.isTouched(Gdx.input.getX(), GameSettings.SCREEN_Y - Gdx.input.getY())) {
                myGdxGame.setScreen(myGdxGame.gameScreen);
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
    }
}
