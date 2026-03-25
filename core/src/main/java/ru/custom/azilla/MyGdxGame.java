package ru.custom.azilla;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.constants.GameSettings;
import ru.custom.azilla.managers.AudioManager;
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
    public AudioManager audioManager;

    @Override
    public void create() {
        batch = new SpriteBatch();

        Gdx.graphics.setTitle("Flappy clone!!! Also, why did i changed that lol? :Р");

        audioManager = new AudioManager();

        menuScreen = new MenuScreen(this);
        gameScreen = new GameScreen(this);
        settingsScreen = new SettingsScreen(this);
        restartScreen = new RestartScreen(this);

        setScreen(menuScreen);
    }

    @Override
    public void resize(int width, int height) {
        GameSettings.SCREEN_X = width;
        GameSettings.SCREEN_Y = height;
        audioManager.stopMusic(0);
        audioManager.stopMusic(1);
        dispose();
        create();
    }

    public void dispose() {
        batch.dispose();
        menuScreen.dispose();
        gameScreen.dispose();
        settingsScreen.dispose();
        restartScreen.dispose();
    }
}
