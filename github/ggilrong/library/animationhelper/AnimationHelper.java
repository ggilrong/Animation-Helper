package com.github.ggilrong.library.animationhelper;

import android.view.View;

public class AnimationHelper
{
    public enum Direction {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    private static final long DEFAULT_DURATION = 1000;
    private static final long DEFAULT_DELAY = 0;

    public static <T extends View> void move(Direction direction, T view) {
        move(direction, view, DEFAULT_DURATION, DEFAULT_DELAY);
    }

    public static <T extends View> void move(Direction direction, T view, long delay) {
        move(direction, view, DEFAULT_DURATION, delay);
    }

    public static synchronized <T extends View> void move(final Direction direction, final T view, final long duration, long delay) {

        view.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                int width = view.getWidth();
                int height = view.getHeight();

                switch(direction)
                {
                    case LEFT:
                        view.animate().translationX(-width).setDuration(duration);
                        break;
                    case TOP:
                        view.animate().translationY(-height).setDuration(duration);
                        break;
                    case RIGHT:
                        view.animate().translationX(width).setDuration(duration);
                        break;
                    case BOTTOM:
                        view.animate().translationY(height).setDuration(duration);
                        break;
                }
            }
        }, delay);
    }
}
