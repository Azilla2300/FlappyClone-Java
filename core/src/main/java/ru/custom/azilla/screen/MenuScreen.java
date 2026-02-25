package ru.custom.azilla.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.custom.azilla.MyGdxGame;

public class MenuScreen implements Screen {
    MyGdxGame myGdxGame;
    SpriteBatch batch;
    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.batch = myGdxGame.batch;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.ORANGE);
        if (Gdx.input.justTouched()) {
            myGdxGame.setScreen(myGdxGame.gameScreen);
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

    }
}
