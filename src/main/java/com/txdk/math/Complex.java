package com.txdk.math;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Complex {
    
    private double realPart;
    private double imaginaryPart;

    public Complex(Complex source)
    {
        this.realPart = source.realPart;
        this.imaginaryPart = source.imaginaryPart;
    }

    public Complex add(Complex other)
    {
        Complex sum = new Complex(realPart + other.realPart, imaginaryPart + other.imaginaryPart);
        return sum;
    }

    public Complex multiply(Complex other)
    {
        double productRealPart = realPart * other.realPart - imaginaryPart * other.imaginaryPart;
        double productImaginaryPart = realPart * other.imaginaryPart + imaginaryPart * other.realPart;
        return new Complex(productRealPart, productImaginaryPart);
    }

    public Complex square()
    {
        return this.multiply(this);
    }

    public double modulus()
    {
        return Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2));
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(realPart, imaginaryPart);
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Complex)) return false;
        
        Complex otherComplex = (Complex) other;
        return (
            (Double.compare(realPart, otherComplex.realPart) == 0) &
            (Double.compare(imaginaryPart, otherComplex.imaginaryPart) == 0)
            );
    }

    @Override
    public String toString()
    {
        String numberAsString = realPart + " + " + imaginaryPart + "i";
        return numberAsString;
    }

}
