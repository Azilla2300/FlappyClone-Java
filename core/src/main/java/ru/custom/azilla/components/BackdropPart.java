package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.constants.GameSettings;

public class BackdropPart {
    Texture texture;

    int x1 = 0;
    int x2 = GameSettings.SCREEN_X;
    int speed;

    public BackdropPart(String texture, int speed) {
        this.texture = new Texture(texture);
        this.speed = speed;
    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x1, 0,
            GameSettings.SCREEN_X, GameSettings.SCREEN_Y);
        batch.draw(texture, x2, 0,
            GameSettings.SCREEN_X, GameSettings.SCREEN_Y);
    }
    public void move() {
        x1 -= speed;
        x2 -= speed;
        if (x1 == -GameSettings.SCREEN_X) x1 = GameSettings.SCREEN_X;
        if (x2 == -GameSettings.SCREEN_X) x2 = GameSettings.SCREEN_X;
    }

    public void dispose() {
        texture.dispose();
    }
}
