package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.GameSettings;

public class BackdropPart {
    int x1 = 0;
    int x2 = GameSettings.SCREEN_X;
    int speed;
    Texture texture;
    public BackdropPart(String texturePath, int speed) {
        texture = new Texture(texturePath);
        this.speed = speed;
    }
    public void move() {
        x1 -= speed;
        x2 -= speed;
        if (x1 == -GameSettings.SCREEN_X) x1 = GameSettings.SCREEN_X;
        if (x2 == -GameSettings.SCREEN_X) x2 = GameSettings.SCREEN_X;
    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x1, 0,
            GameSettings.SCREEN_X, GameSettings.SCREEN_Y);
        batch.draw(texture, x2, 0,
            GameSettings.SCREEN_X, GameSettings.SCREEN_Y);
    }
    public void dispose() {
        texture.dispose();
    }
}
