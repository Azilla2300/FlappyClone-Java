package ru.custom.azilla.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.custom.azilla.MyGdxGame;
import ru.custom.azilla.components.TextButton;
import ru.custom.azilla.constants.GameSettings;

public class SettingsScreen implements Screen {

    MyGdxGame myGdxGame;
    TextButton menuButton;
    SpriteBatch batch;

    public SettingsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.batch = myGdxGame.batch;
        menuButton = new TextButton(50, GameSettings.SCREEN_Y - 150,
            100, 100, GameSettings.MENU_BUTTON, "",
            myGdxGame.audioManager);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.ORANGE);
        batch.begin();
        menuButton.draw(batch);
        batch.end();
        handleInput();
    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            int trueY = GameSettings.SCREEN_Y - Gdx.input.getY();
            if (menuButton.isTouched(Gdx.input.getX(), trueY)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
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
        menuButton.dispose();
    }
}
