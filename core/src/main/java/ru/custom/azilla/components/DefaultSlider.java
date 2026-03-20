package ru.custom.azilla.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import ru.custom.azilla.constants.GameSettings;

public class DefaultSlider extends Slider {
    public DefaultSlider(int x, int y) {
        super(0f, 1f, .002f, false, new DefaultSliderStyle());
        setX(x);
        setY(y);
    }
    static class DefaultSliderStyle extends SliderStyle{
        SpriteDrawable background = new SpriteDrawable(
            new Sprite(new Texture(GameSettings.SLIDER_BAR))
            );

        SpriteDrawable knob = new SpriteDrawable(
            new Sprite(new Texture(GameSettings.SLIDER_HEAD))
            );
        DefaultSliderStyle() {
            new SliderStyle(background, knob);
        }
    }
}
