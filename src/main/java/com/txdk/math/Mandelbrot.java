package com.txdk.math;

public class Mandelbrot extends QuadraticIteration {

    public Mandelbrot(double divergentThreshold, int maxIterations){
        super(divergentThreshold, maxIterations);
    }

    @Override
    public Iterate iterateUntilDivergence(Complex startValue)
    {
        Complex value = new Complex(startValue);
        int iterationCount = 0;

        while ((value.modulus() < divergentThreshold) & (iterationCount < maxIterations))
        {
            value = applyFunction(value, startValue);
            iterationCount++;
        }

        return new Iterate(value, iterationCount);
    }
    
}
