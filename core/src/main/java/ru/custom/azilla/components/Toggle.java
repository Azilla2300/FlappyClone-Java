package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.constants.GameSettings;
import ru.custom.azilla.managers.AudioManager;

public class Toggle {

    AudioManager audioManager;

    Texture on;
    Texture off;

    int x;
    int y;
    int width;
    int height;

    public boolean isOn;

    public Toggle(int x, int y, int width, int height, boolean isOn, AudioManager audioManager) {
        this.audioManager = audioManager;

        on = new Texture(GameSettings.TOGGLE_ON);
        off = new Texture(GameSettings.TOGGLE_OFF);

        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        this.isOn = isOn;
    }

    public void draw(SpriteBatch batch) {
        if (isOn) batch.draw(on, x, y, width, height);
        else batch.draw(off, x, y, width, height);
    }

    public boolean handleInput(int touchX, int touchY) {
        boolean touchedX = x < touchX && x + width > touchX;
        boolean touchedY = y < touchY && y + height > touchY;
        boolean touched = touchedX && touchedY;
        if (touched) {
            audioManager.playSound(0);
            isOn = !isOn;
        }
        return touched;
    }

    public void dispose() {
        on.dispose();
        off.dispose();
    }

}
