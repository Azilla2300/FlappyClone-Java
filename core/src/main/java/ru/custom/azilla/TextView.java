package ru.custom.azilla;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TextView {
    BitmapFont font;

    int x;
    int y;

    int fontSize = GameSettings.FONTSIZE;

    public TextView(int x, int y) {
        this.x = x;
        this.y = y;
        font = new BitmapFont();

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
            Gdx.files.internal("fonts/OCRAEXT.TTF"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameters
            = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameters.color = Color.WHITE;
        parameters.size = fontSize;
        parameters.borderColor = Color.BLACK;
        parameters.borderWidth = 3;
        font = generator.generateFont(parameters);
    }
    void draw(SpriteBatch batch, String text){
        font.draw(batch, text, x, y);
    }
    void dispose() {
        font.dispose();
    }
}
