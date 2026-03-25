package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.custom.azilla.MyGdxGame;
import ru.custom.azilla.constants.GameSettings;

public class Leaderboard {
    TextView title;
    TextButton place1;
    TextButton place2;
    TextButton place3;
    TextView place4;
    TextView place5;
    SpriteBatch batch;

    int globalWidth;
    int globalHeight;
    int textureSize;
    String titleText = "Leaderboard!";

    public Leaderboard(int x, int y, int width, int height, MyGdxGame myGdxGame) {
        globalWidth = width;
        globalHeight = height;
        textureSize = width / 10 - 5;
        int topY = (int) (y + height * 2.5);
        int bottomY = y + 5;

        batch = myGdxGame.batch;
        title = new TextView(x + width / 2, topY, titleText, true);
        place1 = new TextButton(x + 5, bottomY, textureSize, textureSize,
            GameSettings.TROPHY1, "", myGdxGame.audioManager);
        place2 = new TextButton(x + width / 5 + 5, bottomY,
            textureSize, textureSize,
            GameSettings.TROPHY2, "", myGdxGame.audioManager);
        place3 = new TextButton(x + width / 5 * 2 + 5, bottomY,
            textureSize, textureSize,
            GameSettings.TROPHY3, "", myGdxGame.audioManager);
        place4 = new TextView(
            (int) (x + width / 10. * 6.5),
            y + height / 4 * 3,
            "", true);
        place5 = new TextView(
            (int) (x + width / 10. * 8.5),
            y + height / 4 * 3 ,
            "", true);
    }
    public void draw(Integer[] results) throws IllegalArgumentException {
        if (results.length != 5) {
            throw new IllegalArgumentException(
                "Expected 5 arguments, but found just " + results.length);
        }
        for (Integer integer : results) {
            if (integer == null) {
                throw new IllegalArgumentException(
                    "One of the elements is null");
            }
        }

        title.draw(batch);
        place1.draw(batch, String.valueOf(results[0]));
        place2.draw(batch, String.valueOf(results[1]));
        place3.draw(batch, String.valueOf(results[2]));
        place4.draw(batch, String.valueOf(results[3]));
        place5.draw(batch, String.valueOf(results[4]));
    }
    public void dispose() {

    }
}
