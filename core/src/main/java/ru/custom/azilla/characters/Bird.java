package ru.custom.azilla.characters;

import static ru.custom.azilla.constants.GameSettings.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.custom.azilla.managers.AudioManager;

public class Bird {

    Texture[] textureArray;
    TextureRegion textureRegion;

    AudioManager audioManager;

    int x;
    float y;
    int width;
    int height;
    int jumpStartY;
    float velocity;

    int frameCounter;
    int currentFrame;

    boolean isJumping = false;
    boolean enableAnimation = false;

    public Bird(int x, int y, int width, int height, AudioManager audioManager) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        textureArray = new Texture[BIRD_TEXTURES.length];
        for (int i = 0; i < BIRD_TEXTURES.length; i++) {
            textureArray[i] = new Texture(BIRD_TEXTURES[i]);
        }
        this.audioManager = audioManager;
    }

    public void draw(SpriteBatch batch) {
        if (enableAnimation) {
            currentFrame = (frameCounter / 10) % textureArray.length;
            frameCounter++;
        }
        if (frameCounter / 10 == 9) {
            frameCounter = 0;
            enableAnimation = false;
        }
        if (!MODE) batch.draw(textureArray[currentFrame], x, y, width, height);
        else {
            textureRegion = new TextureRegion(textureArray[currentFrame]);
            float rotation = velocity * 1.5f;
            batch.draw(textureRegion, x, y, 0, 0,
                width, height, 1 ,1, rotation);
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
    public void jump() {
        audioManager.playSound(2);
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

    public void dispose() {
        for (Texture texture : textureArray) {
            texture.dispose();
        }
    }
}
