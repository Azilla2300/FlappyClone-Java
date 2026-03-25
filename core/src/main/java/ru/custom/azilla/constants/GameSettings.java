package ru.custom.azilla.constants;

import com.badlogic.gdx.Gdx;

public class GameSettings {
    // Текстуры:
    // Bird
    public static String[] BIRD_TEXTURES = {
        "textures/bird/bird.png",
        "textures/bird/bird1.png",
        "textures/bird/bird2.png",
        "textures/bird/bird1.png"};
    // Backdrop
    public static String[][] BACKDROP_TEXTURES = {
        {"textures/backdrop/cool_screenshot_that_i_got_lol.png"},
        {"textures/backdrop/mountains.png",
        "textures/backdrop/houses.png",
        "textures/backdrop/trees.png"}};
    // Pipe
    public static String PIPE_RIGHT = "textures/tube/tube1.png";
    public static String PIPE_WRONG = "textures/tube/tube2.png";
    // Buttons
    public static String DEFAULT_BUTTON = "textures/buttons/buttonDefault.png";
    public static String SETTINGS_BUTTON = "textures/buttons/buttonSettings.png";
    public static String MENU_BUTTON = "textures/buttons/buttonMenu.png";
    public static String RESTART_BUTTON = "textures/buttons/buttonRestart.png";
    public static String EXIT_BUTTON = "textures/buttons/buttonExit.png";
    // Toggle
    public static String TOGGLE_ON = "textures/toggle/on.png";
    public static String TOGGLE_OFF = "textures/toggle/off.png";
    // Slider
    public static String SLIDER_BAR = "textures/slider/bar.png";
    public static String SLIDER_HEAD = "textures/slider/head.png";
    // Leaderboard
    public static String TROPHY1 = "textures/buttons/trophy.png";
    public static String TROPHY2 = "textures/buttons/trophy2.png";
    public static String TROPHY3 = "textures/buttons/trophy3.png";
    // Звуки и музыка
    public static String MENU_MUSIC = "music/menu.mp3";
    public static String GAME_MUSIC = "music/work.ogg";

    public static String CLICK_SOUND = "sounds/click.ogg";
    public static String DEATH_SOUND = "sounds/orb.ogg";
    public static String FLY_SOUND = "sounds/pop.ogg";

    // Общие настройки:
    public static int SCREEN_X = Gdx.graphics.getWidth(); // Разрешение экрана. Используется в логике и разрешении на десктопе
    public static int SCREEN_Y = Gdx.graphics.getHeight();

    public static boolean MODE = false; // Система скоростей (обычная скорость (false) / гравитация (true))

    // Размер шрифта
    public static int FONTSIZE = 72;

    // Птица
    public static int BIRD_FALL_SPEED = -5;
    public static int BIRD_JUMP_HEIGHT = 100;
    public static int BIRD_JUMP_SPEED = 10;

    // Трубы
    public static int PIPE_GAP = 350;
    public static int PIPE_MIN_Y = 100;
    public static int COUNT_OF_PIPES = 3;

    // Гравитация
    public static float GRAVITY = -5f; // Измеряется в пикселях за секунду
    public static float GRAVITY_MULTIPLIER = 3f / 60;
    public static float JUMP_MULTIPLIER = -1f; // Сколько гравитаций будет применятся при прыжке
    public static int TERMINAL_VELOCITY = GameSettings.SCREEN_Y / 60;

    // Фон
    public static int[][] BACKDROP_SPEEDS = {{0}, {1, 2, 5}};
}
