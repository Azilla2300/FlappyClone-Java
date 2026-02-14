package ru.custom.azilla;

import com.badlogic.gdx.graphics.Texture;

public class GameSettings {
    // Текстуры:
    public static Texture[] BIRD_TEXTURES = new Texture[] {
        new Texture("textures/bird.png"),
        new Texture("textures/bird1.png"),
        new Texture("textures/bird2.png"),
        new Texture("textures/bird1.png")
    };

    public static String PIPE_RIGHT = "textures/tube1.png";
    public static String PIPE_WRONG = "textures/tube2.png";

    // Общие настройки:
    public static int SCREEN_X = 1280; // Разрешение экрана. Используется в логике и разрешении на десктопе
    public static int SCREEN_Y = 720;

    public static boolean MODE = false; // Система скоростей (обычная скорость (false) / гравитация (true))

    public static int BIRD_FALL_SPEED = -5;
    public static int BIRD_JUMP_HEIGHT = 100;
    public static int BIRD_JUMP_SPEED = 10;

    public static int PIPE_GAP = 300;
    public static int PIPE_MIN_Y = 100;

    public static float GRAVITY = -5f; // Измеряется в пикселях за секунду
    public static float GRAVITY_MULTIPLIER = 3f / 60;
    public static float JUMP_MULTIPLIER = -1f; // Сколько гравитаций будет применятся при прыжке
}
