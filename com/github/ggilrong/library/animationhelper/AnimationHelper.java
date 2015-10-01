package com.github.ggilrong.library.animationhelper;

import android.animation.Animator;
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
        move(direction, view, DEFAULT_DURATION, DEFAULT_DELAY, new SimpleAnimatorListener());
    }

    public static <T extends View> void move(Direction direction, T view, long duration, long delay) {
        move(direction, view, duration, delay, new SimpleAnimatorListener());
    }

    public static synchronized <T extends View> void move(final Direction direction, final T view, final long duration, long delay, final Animator.AnimatorListener animatorListener) {

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
                        view.animate().translationX(-width).setDuration(duration).setListener(animatorListener);
                        break;
                    case TOP:
                        view.animate().translationY(-height).setDuration(duration).setListener(animatorListener);
                        break;
                    case RIGHT:
                        view.animate().translationX(width).setDuration(duration).setListener(animatorListener);
                        break;
                    case BOTTOM:
                        view.animate().translationY(height).setDuration(duration).setListener(animatorListener);
                        break;
                }
            }
        }, delay);
    }

    public static class SimpleAnimatorListener implements Animator.AnimatorListener
    {

        @Override
        public void onAnimationStart(Animator animation)
        {

        }

        @Override
        public void onAnimationEnd(Animator animation)
        {

        }

        @Override
        public void onAnimationCancel(Animator animation)
        {

        }

        @Override
        public void onAnimationRepeat(Animator animation)
        {

        }
    }
}
