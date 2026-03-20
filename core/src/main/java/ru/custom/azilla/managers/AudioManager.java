package ru.custom.azilla.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import ru.custom.azilla.constants.GameSettings;

public class AudioManager {
    private final Music[] musics;
    public boolean playMusic;

    private final Sound[] sounds;
    public boolean playSound;

    public AudioManager() {
        // Загрузка preferences
        playMusic = MemoriesManager.readMusicState();
        playSound = MemoriesManager.readSoundState();

        // Инициализация звуков по ID
        musics = new Music[2];
        for (int i = 0; i < musics.length; i++) {
            if (i == 0) {
                musics[0] = Gdx.audio.newMusic(
                    Gdx.files.internal(GameSettings.MENU_MUSIC));
                musics[0].setLooping(true);
                musics[0].setVolume(.5f);
                continue;
            }
            musics[i] = Gdx.audio.newMusic(
                Gdx.files.internal(GameSettings.GAME_MUSIC));
            musics[i].setLooping(true);
            musics[i].setVolume(.5f);
        }
        sounds = new Sound[3];
        for (int i = 0; i < sounds.length; i++) {
            if (i == 0) {
                sounds[0] = Gdx.audio.newSound(
                    Gdx.files.internal(GameSettings.CLICK_SOUND));
                continue;
            } else if (i == 1) {
                sounds[1] = Gdx.audio.newSound(
                    Gdx.files.internal(GameSettings.DEATH_SOUND));
                continue;
            }
            sounds[i] = Gdx.audio.newSound(
                Gdx.files.internal(GameSettings.FLY_SOUND));
        }
    }
    public void playMusic(int musicID) {
        if (playMusic) {
            if (musicID < musics.length)
                if (!musics[musicID].isPlaying()) musics[musicID].play();
        }
    }
    public void stopMusic(int musicID) {
        if (musicID < musics.length) musics[musicID].stop();
    }
    public void playSound(int soundID) {
        if (playSound) {
            if (soundID < sounds.length) sounds[soundID].play();
        }
    }
}
