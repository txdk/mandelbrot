package com.txdk.ui;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.txdk.Constants;
import com.txdk.math.ComplexIteration;
import com.txdk.math.Mandelbrot;
import com.txdk.plotting.ComplexPlotter;
import com.txdk.plotting.Plotter;

public class UserInterface extends JFrame {

    private Plotter plotter;
    
    public UserInterface()
    {
        super("Mandelbrot Set Plotter");
        this.getContentPane().setLayout(new FlowLayout());
        this.setSize(Constants.PLOT_LENGTH, Constants.PLOT_WIDTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createPlot()
    {
        ComplexIteration mandelbrot = new Mandelbrot(Constants.DIVERGENT_THRESHOLD, Constants.MAX_ITERATIONS);
        plotter = new ComplexPlotter(mandelbrot);
        BufferedImage mandelbrotPlot = plotter.plot();
        JLabel imageLabel = new JLabel(new ImageIcon(mandelbrotPlot));
        this.add(imageLabel);
        this.setVisible(true);
    }
}
