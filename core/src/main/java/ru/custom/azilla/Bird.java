package ru.custom.azilla;

import static ru.custom.azilla.GameSettings.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {

    Texture[] textureArray = BIRD_TEXTURES;
    int x;
    float y;
    int width;
    int height;
    boolean isJumping = false;
    int jumpStartY;
    int frameCounter;
    int currentFrame;
    float velocity;

    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(SpriteBatch spriteBatch) {
        currentFrame = (frameCounter / 5) % textureArray.length;
        frameCounter++;

        spriteBatch.draw(textureArray[currentFrame], x, y, width, height);
    }

    public void jump() {
        if (!MODE) {
            isJumping = true;
            jumpStartY = (int) y;
        } else {
            if (velocity <= 0) velocity = 0;
            velocity += GRAVITY * JUMP_MULTIPLIER;
        }
    }
    public void move() {
        if (!MODE) {
            y += BIRD_FALL_SPEED;
            if (isJumping) {
                y += BIRD_JUMP_SPEED;
                if (y == jumpStartY + BIRD_JUMP_HEIGHT) isJumping = false;
            }
        } else {
            y += velocity;
            velocity += GRAVITY * GRAVITY_MULTIPLIER;
        }
    }
    public void dispose() {
        for (Texture texture : textureArray) {
            texture.dispose();
        }
    }

}
