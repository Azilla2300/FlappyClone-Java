package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.constants.GameSettings;

public class TextButton {

    Texture texture;
    String text;
    TextView textView;

    int x;
    int y;

    int buttonWidth;
    int buttonHeight;

    public TextButton(int x, int y, int buttonWidth, int buttonHeight, String texture, String text) {
        this.x = x;
        this.y = y;

        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;

        this.text = text;
        textView = new TextView(x + buttonWidth / 2,
            y + buttonHeight / 2,
            text, true);

        this.texture = new Texture(texture);
    }
    public boolean isTouched(int touchX, int touchY) {
        boolean touchedX = x < touchX && x + buttonWidth > touchX;
        boolean touchedY = y < touchY && y + buttonHeight > touchY;
        return touchedX && touchedY;
    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, buttonWidth, buttonHeight);
        textView.draw(batch);
    }
    public void dispose() {
        texture.dispose();
        textView.dispose();
    }
}
