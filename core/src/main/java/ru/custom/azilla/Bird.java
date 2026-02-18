package ru.custom.azilla;

import static ru.custom.azilla.GameSettings.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bird {

    Texture[] textureArray = BIRD_TEXTURES;
    TextureRegion textureRegion;
    int x;
    float y;
    int width;
    int height;
    boolean isJumping = false;
    int jumpStartY;
    int frameCounter;
    int currentFrame;
    float velocity;
    boolean enableAnimation = false;

    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(SpriteBatch spriteBatch) {
        if (enableAnimation) {
            currentFrame = (frameCounter / 10) % textureArray.length;
            frameCounter++;
        }
        if (frameCounter / 10 == 9) {
            frameCounter = 0;
            enableAnimation = false;
        }
        if (!MODE) spriteBatch.draw(textureArray[currentFrame], x, y, width, height);
        else {
            textureRegion = new TextureRegion(textureArray[currentFrame]);
            float rotation = velocity * 1.5f;
            spriteBatch.draw(textureRegion, x, y, 0, 0,
                width, height, 1 ,1, rotation);
        }
    }

    public void jump() {
        if (!MODE) {
            isJumping = true;
            jumpStartY = (int) y;
        } else {
            if (velocity <= 0) velocity = 0;
            velocity += GRAVITY * JUMP_MULTIPLIER;
        }
        if (!enableAnimation) enableAnimation = true;
        else {
            while (frameCounter / 10 % textureArray.length > textureArray.length) {
                frameCounter = frameCounter - 10 * textureArray.length;
            }
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
            if (velocity >= TERMINAL_VELOCITY) velocity = TERMINAL_VELOCITY;
            if (velocity <= -TERMINAL_VELOCITY) velocity = -TERMINAL_VELOCITY;
        }
    }
    public void dispose() {
        for (Texture texture : textureArray) {
            texture.dispose();
        }
    }

}
