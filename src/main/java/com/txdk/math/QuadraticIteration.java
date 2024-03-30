package com.txdk.math;

public abstract class QuadraticIteration extends ComplexIteration {

    public QuadraticIteration(double divergentThreshold, int maxIterations)
    {
        super(divergentThreshold, maxIterations);
    }

    @Override
    public Complex applyFunction(Complex value, Complex constant)
    {
        return new Complex(value.square().add(constant));
    }
    
}
