package com.txdk.math;

public class Julia extends QuadraticIteration {

    private Complex constant;

    public Julia(Complex constant, double divergentThreshold, int maxIterations)
    {
        super(divergentThreshold, maxIterations);
        this.constant = constant;
    }

    @Override
    public Iterate iterateUntilDivergence(Complex startValue)
    {
        Complex value = new Complex(startValue);
        int iterationCount = 0;

        while ((value.modulus() < divergentThreshold) & (iterationCount < maxIterations))
        {
            value = applyFunction(value, constant);
            iterationCount++;
        }

        return new Iterate(value, iterationCount);
    }
    
}
