package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.constants.GameSettings;

public class MovingBackdrop {
    BackdropPart[] parts;

    public MovingBackdrop(int type) {
        parts = new BackdropPart[GameSettings.BACKDROP_TEXTURES[type].length];
        String[] textures = GameSettings.BACKDROP_TEXTURES[type];
        int[] speeds = GameSettings.BACKDROP_SPEEDS[type];
        for (int i = 0; i < textures.length; i++) {
            parts[i] = new BackdropPart(textures[i], speeds[i]);
        }
    }
    public void draw(SpriteBatch batch) {
        for (BackdropPart onePart : parts) {
            onePart.draw(batch);
        }
    }
    public void move() {
        for (BackdropPart onePart : parts) {
            onePart.move();
        }
    }

    public void dispose() {
        for (BackdropPart onePart : parts) {
            onePart.dispose();
        }
    }
}
