package model;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {

    private final ImageView imageView;
    private final int columns;
    private final int count;
    private final int offsetX;
    private final int offsetY;
    private final double width;
    private final double height;

    private int lastIndex;

    public SpriteAnimation(
            ImageView imageView, 
            Duration duration, 
            int rows,   int columns,
            int offsetX, int offsetY,
            int width,   int height) {
        this.imageView = imageView;
        this.columns   = columns;
        this.count = rows*columns;
        this.offsetX   = offsetX;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }
    
    public SpriteAnimation(
            ImageView imageView, 
            Duration duration, 
            int rows,   int columns) {
        this.imageView = imageView;
        this.columns   = columns;
        this.count = rows*columns;
        this.offsetX   = 0;
        this.offsetY   = 0;
        this.width     = imageView.getImage().getWidth()/columns;
        this.height    = imageView.getImage().getHeight()/rows;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
        setCycleCount(Animation.INDEFINITE);
    }

    protected void interpolate(double k) {
        final int index = Math.min((int) Math.floor(k * count), count - 1);
        if (index != lastIndex) {
            final double x = (index % columns) * width  + offsetX;
            final double y = (index / columns) * height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            lastIndex = index;
        }
    }
    
    
}