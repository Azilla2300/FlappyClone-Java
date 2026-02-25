package ru.custom.azilla;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.screen.GameScreen;
import ru.custom.azilla.screen.MenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGdxGame extends Game {
    public SpriteBatch batch;
    MenuScreen menuScreen;
    public GameScreen gameScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();

        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        setScreen(menuScreen);
    }
}
