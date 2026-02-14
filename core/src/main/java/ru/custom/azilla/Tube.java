package ru.custom.azilla;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Tube {
    Random random = new Random();
    float x;
    int centerY;
    Texture tubeRight;
    Texture tubeWrong;
    int tubeLength = 145 * 4;
    int tubeWidth = 34 * 4;
    int drawableY1; // Для tubeWrong
    int drawableY2; // Для tubeRight
    int otherside = GameSettings.PIPE_MIN_Y + GameSettings.PIPE_GAP / 2;

    public Tube(float x) {
        this.x = x;
        tubeRight = new Texture(GameSettings.PIPE_RIGHT);
        tubeWrong = new Texture(GameSettings.PIPE_WRONG);
        randomCenterY();
    }
    void move() {
        x -= 8.5f;
        if (x <= -10 - tubeWidth) {
            x = GameSettings.SCREEN_X + 10;
            randomCenterY();
        }
    }
    boolean isHit(Bird bird) {
        checkDrawableY();
        boolean matchX = bird.width + bird.x > x && tubeWidth + x < bird.x;
        if (matchX) {
            if (bird.y + bird.height > drawableY1) return true;
            else if (bird.y < centerY - GameSettings.PIPE_GAP / 2) return true;
        }
        return false;
    }
    void draw(SpriteBatch batch) {
        checkDrawableY();
        batch.draw(tubeWrong, x, drawableY1, tubeWidth, tubeLength);
        batch.draw(tubeRight, x, drawableY2, tubeWidth, tubeLength);
    }
    void randomCenterY() {
        centerY = random.nextInt(GameSettings.SCREEN_Y - otherside * 2) + otherside;
    }
    void checkDrawableY() {
        drawableY1 = centerY + GameSettings.PIPE_GAP / 2; // Для tubeWrong
        drawableY2 = centerY - (tubeLength + GameSettings.PIPE_GAP / 2); // Для tubeRight
    }
    void dispose() {
        tubeRight.dispose();
        tubeWrong.dispose();
    }
}
