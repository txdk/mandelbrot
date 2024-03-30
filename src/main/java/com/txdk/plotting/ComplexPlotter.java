package com.txdk.plotting;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.txdk.Constants;
import com.txdk.math.Complex;
import com.txdk.math.ComplexIteration;

import net.mahdilamb.colormap.Colormap;
import net.mahdilamb.colormap.Colormaps;

public class ComplexPlotter extends Plotter {

    private ComplexIteration complexIteration;

    public ComplexPlotter(ComplexIteration complexIteration)
    {
        super();
        this.complexIteration = complexIteration;
    }

    @Override
    public BufferedImage plot()
    {
        for (int xPixel = 0; xPixel < Constants.PLOT_LENGTH; xPixel++)
        {
            for (int yPixel = 0; yPixel < Constants.PLOT_WIDTH; yPixel++)
            {
                double realPart = getScaledXCoordinate(xPixel);
                double imaginaryPart = getScaledYCoordinate(yPixel);
                Complex pixelCoordsAsComplex = new Complex(realPart, imaginaryPart);
                double numIterations = complexIteration.countFractionalIterationsUntilDivergence(pixelCoordsAsComplex);
                image.setRGB(xPixel, yPixel, getColourFromNumIterations(numIterations));
            }
        }      
        return image;
    }

    public int getColourFromNumIterations(double numIterations)
    {
        int maxIterations = complexIteration.getMaxIterations();
        if (numIterations >= maxIterations) return Constants.DEFAULT_SET_COLOUR;

        Colormap colormap = Colormaps.get(Constants.DEFAULT_COLORMAP);
        double colorValue = numIterations / maxIterations;
        Color color = colormap.get(colorValue);
        return color.getRGB();
    }
}
