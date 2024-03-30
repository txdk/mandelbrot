package com.txdk.math;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Iterate {
    
    private Complex value;
    private int numIterations;

    public double getModulus()
    {
        return value.modulus();
    }
}
