package ru.custom.azilla;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {

    Texture texture;
    int x;
    float y;
    int width;
    int height;
    boolean isJumping = false;
    int jumpStartY;

    public Bird(int x, int y, int width, int height, boolean mode) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        texture = new Texture(GameSettings.BIRD_TEXTURE);
    }

    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.draw(texture, x, y, width, height);
    }

    public void jump() {
        if (!GameSettings.MODE) {
            isJumping = true;
            jumpStartY = (int) y;
        }
    }
    public void move() {
        if (!GameSettings.MODE) {
            y += GameSettings.BIRD_FALL_SPEED;
            if (isJumping) {
                y += GameSettings.BIRD_JUMP_SPEED;
                if (y == jumpStartY + GameSettings.BIRD_JUMP_HEIGHT) isJumping = false;
            }
        }
    }
    public void dispose() {
        texture.dispose();
    }

}
