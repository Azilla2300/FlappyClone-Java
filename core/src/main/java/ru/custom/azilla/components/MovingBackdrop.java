package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.GameSettings;

public class MovingBackdrop {
    BackdropPart[] parts = new BackdropPart[GameSettings.BACKDROP_TEXTURES.length];

    public MovingBackdrop() {
        String[] textures = GameSettings.BACKDROP_TEXTURES;
        int[] speeds = GameSettings.BACKDROP_SPEEDS;
        for (int i = 0; i < textures.length; i++) {
            parts[i] = new BackdropPart(textures[i], speeds[i]);
        }
    }
    public void move() {
        for (BackdropPart onePart : parts) {
            onePart.move();
        }
    }
    public void draw(SpriteBatch batch) {
        for (BackdropPart onePart : parts) {
            onePart.draw(batch);
        }
    }
    public void dispose() {
        for (BackdropPart onePart : parts) {
            onePart.dispose();
        }
    }
}
