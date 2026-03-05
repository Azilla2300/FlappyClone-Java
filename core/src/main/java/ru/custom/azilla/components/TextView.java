package ru.custom.azilla.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import ru.custom.azilla.constants.GameSettings;

public class TextView {
    BitmapFont font;

    String text;
    int x;
    public int y;

    int fontSize = GameSettings.FONTSIZE;

    public TextView(int x, int y, String text, boolean centered) {
        this.text = text;
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

        if (!centered) {
            this.x = x;
            this.y = y;
        } else {
            GlyphLayout glyphLayout = new GlyphLayout(this.font, text);
            this.x = (int) (x - glyphLayout.width / 2);
            this.y = (int) (y + glyphLayout.height / 2);
        }
    }
    public void draw(SpriteBatch batch, String text){
        font.draw(batch, text, x, y);
    }
    public void draw(SpriteBatch batch){
        font.draw(batch, this.text, x, y);
    }
    public void dispose() {
        font.dispose();
    }
}
