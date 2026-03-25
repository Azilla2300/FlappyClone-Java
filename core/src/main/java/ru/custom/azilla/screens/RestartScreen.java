package ru.custom.azilla.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.custom.azilla.MyGdxGame;
import ru.custom.azilla.components.Leaderboard;
import ru.custom.azilla.components.TextButton;
import ru.custom.azilla.components.TextView;
import ru.custom.azilla.constants.GameSettings;
import ru.custom.azilla.managers.MemoriesManager;

public class RestartScreen implements Screen {

    MyGdxGame myGdxGame;
    SpriteBatch batch;
    TextButton restartButton;
    TextButton menuButton;
    TextView gameOver;
    Leaderboard leaderboard;
    Integer[] results;

    public RestartScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.batch = myGdxGame.batch;
        menuButton = new TextButton(50, GameSettings.SCREEN_Y - 150,
            100, 100, GameSettings.MENU_BUTTON, "",
            myGdxGame.audioManager);
        restartButton = new TextButton(GameSettings.SCREEN_X / 2 - 150,
            GameSettings.SCREEN_Y / 2 - 150,
            300, 300, GameSettings.RESTART_BUTTON,
            "", myGdxGame.audioManager);
        gameOver = new TextView(GameSettings.SCREEN_X / 2,
            GameSettings.SCREEN_Y,
            "Game over!\nTotal points: " + myGdxGame.gameScreen.pointCounter,
            true);
        gameOver.y = GameSettings.SCREEN_Y / 16 * 15;
        leaderboard = new Leaderboard(GameSettings.SCREEN_X / 8,
            20,
            GameSettings.SCREEN_X / 4 * 3,
            GameSettings.SCREEN_Y / 12, myGdxGame);
    }

    @Override
    public void show() {
        results = MemoriesManager.readResults();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.ORANGE);
        batch.begin();
        menuButton.draw(batch);
        gameOver.draw(batch, getGameOverText());
        restartButton.draw(batch);
        leaderboard.draw(results);
        batch.end();
        handleInput();
    }

    void handleInput() {
        if (Gdx.input.justTouched()) {
            int trueY = GameSettings.SCREEN_Y - Gdx.input.getY();
            if (menuButton.isTouched(Gdx.input.getX(), trueY)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
            }
            if (restartButton.isTouched(Gdx.input.getX(), trueY)) {
                myGdxGame.gameScreen = new GameScreen(myGdxGame);
                myGdxGame.setScreen(myGdxGame.gameScreen);
            }
        }
    }

    public String getGameOverText() {
        return "Game over!\nTotal points: " + myGdxGame.gameScreen.pointCounter;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        restartButton.dispose();
        menuButton.dispose();
        gameOver.dispose();
        leaderboard.dispose();
    }
}
