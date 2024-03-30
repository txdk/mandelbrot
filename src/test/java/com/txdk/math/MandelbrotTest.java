package com.txdk.math;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MandelbrotTest {

    private Mandelbrot mandelbrot;

    @Before
    public void setup()
    {
        mandelbrot = new Mandelbrot(2, 20);
    }

    @Test
    public void applyFunctionTest()
    {
        Complex complex = new Complex(1, 1);
        assertEquals(mandelbrot.applyFunction(new Complex(0, 0), complex), complex);
        assertEquals(mandelbrot.applyFunction(complex, complex), new Complex(1, 3));
    }

    @Test
    public void countIterationsUntilDivergenceTest()
    {
        assertEquals(mandelbrot.countIterationsUntilDivergence(new Complex(0, 0)), mandelbrot.getMaxIterations());
        assertEquals(mandelbrot.countIterationsUntilDivergence(new Complex(0.25, 0.25)), mandelbrot.getMaxIterations());
        assertEquals(mandelbrot.countIterationsUntilDivergence(new Complex(2, 0)), 0);
        assertEquals(mandelbrot.countIterationsUntilDivergence(new Complex(1,1)), 1);
    }
    
}
