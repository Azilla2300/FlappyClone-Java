package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.GameSettings;

public class TextButton {

    Texture texture;
    String text;
    TextView textView;

    int x;
    int y;

    int buttonWidth;
    int buttonHeight;

    int textWidth;
    int textHeight;
    public TextButton(int x, int y, int buttonWidth, int buttonHeight, String text) {
        this.x = x;
        this.y = y;

        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;

        this.text = text;
        textView = new TextView(0,0);

        texture = new Texture(GameSettings.DEFAULT_BUTTON);

        GlyphLayout glyphLayout = new GlyphLayout(textView.font, text);
        textWidth = (int) glyphLayout.width;
        textHeight = (int) glyphLayout.height;

        textView.x = x + (buttonWidth - textWidth) / 2;
        textView.y = y + (buttonHeight + textHeight) / 2;
    }
    public boolean isTouched(int touchX, int touchY) {
        boolean touchedX = x < touchX && x + buttonWidth > touchX;
        boolean touchedY = y < touchY && y + buttonHeight > touchY;
        return touchedX && touchedY;
    }
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, buttonWidth, buttonHeight);
        textView.draw(batch, text);
    }
    public void dispose() {
        texture.dispose();
        textView.dispose();
    }
}
