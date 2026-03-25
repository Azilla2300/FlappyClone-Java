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
    public static void saveResults(Integer[] scores) {
        String saveString = "";
        for (Integer score : scores) {
            saveString += score + ";";
        }
        preference.putString("results", saveString);
        preference.flush();
    }
    public static Integer[] readResults() {
        String loadedString = preference.getString("results", "0;0;0;0;0");
        String[] scores = loadedString.split(";");
        Integer[] results = new Integer[scores.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = Integer.valueOf(scores[i]);
        }
        return results;
    }

    public static void reset() {
        preference.clear();
    }
}
