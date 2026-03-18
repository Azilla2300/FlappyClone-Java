package ru.custom.azilla.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import ru.custom.azilla.constants.GameSettings;

public class AudioManager {
    public Music menuMusic;
    public Music gameMusic;

    public Sound click;
    public Sound death;
    public Sound fly;

    public AudioManager() {
        menuMusic = Gdx.audio.newMusic(
            Gdx.files.internal(GameSettings.MENU_MUSIC));
        gameMusic = Gdx.audio.newMusic(
            Gdx.files.internal(GameSettings.GAME_MUSIC));

        click = Gdx.audio.newSound(
            Gdx.files.internal(GameSettings.CLICK_SOUND));
        death = Gdx.audio.newSound(
            Gdx.files.internal(GameSettings.DEATH_SOUND));
        fly = Gdx.audio.newSound(
            Gdx.files.internal(GameSettings.FLY_SOUND));
        menuMusic.setVolume(.5f);
        gameMusic.setVolume(.5f);

        click.setVolume(0, .5f);
        death.setVolume(1, .5f);
        fly.setVolume(2, .5f);
    }
}
