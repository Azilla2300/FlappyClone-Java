package ru.custom.azilla;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.screens.GameScreen;
import ru.custom.azilla.screens.MenuScreen;
import ru.custom.azilla.screens.RestartScreen;
import ru.custom.azilla.screens.SettingsScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGdxGame extends Game {
    public SpriteBatch batch;
    public MenuScreen menuScreen;
    public GameScreen gameScreen;
    public RestartScreen restartScreen;
    public SettingsScreen settingsScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();

        Gdx.graphics.setTitle("Flappy clone!!! Also, why did i changed that lol? :Р");

        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        settingsScreen = new SettingsScreen(this);
        restartScreen = new RestartScreen(this);

        setScreen(menuScreen);
    }
    public void dispose() {
        batch.dispose();
    }
}
