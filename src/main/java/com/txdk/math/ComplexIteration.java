package com.txdk.math;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ComplexIteration {

    double divergentThreshold;
    int maxIterations;
  
    public abstract Complex applyFunction(Complex value, Complex constant);

    public abstract Iterate iterateUntilDivergence(Complex startValue);

    public int countIterationsUntilDivergence(Complex startValue)
    {
        Iterate divergentIterate = iterateUntilDivergence(startValue);
        return divergentIterate.getNumIterations();
    }

    public double countFractionalIterationsUntilDivergence(Complex startValue)
    {
        Iterate divergentIterate = iterateUntilDivergence(startValue);
        double log2OfModulus = Math.log(divergentIterate.getModulus()) / Math.log(2.0);
        double fractionalIteration = 1.0 - Math.log(log2OfModulus);
        return divergentIterate.getNumIterations() + fractionalIteration;
    }
}
