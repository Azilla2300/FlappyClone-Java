package ru.custom.azilla.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class MemoriesManager {
    private static final Preferences preference = Gdx.app.getPreferences("UserPreference");

    public static void saveMusicState(boolean onOrOff) {
        preference.putBoolean("isMusicOn", onOrOff);
        preference.flush();
    }
    public static void saveSoundState(boolean onOrOff) {
        preference.putBoolean("isSoundOn", onOrOff);
        preference.flush();
    }
    public static boolean readMusicState() {
        return preference.getBoolean("isMusicOn", true);
    }
    public static boolean readSoundState() {
        return preference.getBoolean("isSoundOn", true);
    }
}
