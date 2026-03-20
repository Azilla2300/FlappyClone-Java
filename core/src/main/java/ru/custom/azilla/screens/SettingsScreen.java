package ru.custom.azilla.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.custom.azilla.MyGdxGame;
import ru.custom.azilla.components.DefaultSlider;
import ru.custom.azilla.components.TextButton;
import ru.custom.azilla.components.TextView;
import ru.custom.azilla.components.Toggle;
import ru.custom.azilla.constants.GameSettings;
import ru.custom.azilla.managers.MemoriesManager;

public class SettingsScreen extends ScreenAdapter {

    MyGdxGame myGdxGame;
    TextButton menuButton;
    SpriteBatch batch;

    TextView musicT;
    TextView soundT;

    Toggle music;
    Toggle sound;

    DefaultSlider soundSlider;

    public SettingsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.batch = myGdxGame.batch;
        menuButton = new TextButton(50, GameSettings.SCREEN_Y - 150,
            100, 100, GameSettings.MENU_BUTTON, "",
            myGdxGame.audioManager);
        soundT = new TextView(100,
            (int) (GameSettings.SCREEN_Y * 0.75),
            "Sound:", false);
        sound = new Toggle(100,
            (int) (GameSettings.SCREEN_Y * 0.55),
            150,75, myGdxGame.audioManager.playSound,
            myGdxGame.audioManager);
        soundSlider = new DefaultSlider(100,
            (int) (GameSettings.SCREEN_Y * 0.5));

        musicT = new TextView(100,
            (int) (GameSettings.SCREEN_Y * 0.40),
            "Music:", false);
        music = new Toggle(
            100, (int) (GameSettings.SCREEN_Y * 0.20),
            150,75, myGdxGame.audioManager.playMusic,
            myGdxGame.audioManager);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.ORANGE);
        batch.begin();
        menuButton.draw(batch);
        musicT.draw(batch);
        music.draw(batch);
        soundT.draw(batch);
        sound.draw(batch);
        soundSlider.draw(batch, 1); // TODO: FIX DAT
        batch.end();
        handleInput();
    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            int trueY = GameSettings.SCREEN_Y - Gdx.input.getY();
            if (menuButton.isTouched(Gdx.input.getX(), trueY)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
            }
            if (music.handleInput(Gdx.input.getX(), trueY)) {
                myGdxGame.audioManager.playMusic = music.isOn;

                if (music.isOn) myGdxGame.audioManager.playMusic(0);
                else myGdxGame.audioManager.stopMusic(0);

                MemoriesManager.saveMusicState(music.isOn);
            }
            if (sound.handleInput(Gdx.input.getX(), trueY)) {
                myGdxGame.audioManager.playSound = sound.isOn;

                MemoriesManager.saveSoundState(sound.isOn);
            }
        }
    }

    @Override
    public void dispose() {
        menuButton.dispose();
        musicT.dispose();
        soundT.dispose();
        music.dispose();
        sound.dispose();

    }
}
