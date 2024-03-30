package com.txdk.plotting;

import java.awt.image.BufferedImage;

import com.txdk.Constants;

public abstract class Plotter {

    protected BufferedImage image;

    public Plotter()
    {
        image = new BufferedImage(Constants.PLOT_LENGTH, Constants.PLOT_WIDTH, BufferedImage.TYPE_INT_RGB);
    }
    
    public double getScaledXCoordinate(int xPixel)
    {
        double scale = Constants.PLOT_WINDOW_X_MAX - Constants.PLOT_WINDOW_X_MIN;
        return Constants.PLOT_WINDOW_X_MIN + scale * ((double) xPixel / Constants.PLOT_LENGTH);
    }

    public double getScaledYCoordinate(int yPixel)
    {
        double scale = Constants.PLOT_WINDOW_Y_MAX - Constants.PLOT_WINDOW_Y_MIN;
        return Constants.PLOT_WINDOW_Y_MIN + scale * ((double) yPixel / Constants.PLOT_WIDTH);
    }

    public abstract BufferedImage plot();

}
