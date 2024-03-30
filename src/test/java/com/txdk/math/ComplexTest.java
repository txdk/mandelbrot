package com.txdk.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class ComplexTest {

    private Complex complex;
    private Complex otherComplex;
    private Complex imaginaryUnit;

    @Before
    public void setup()
    {
        complex = new Complex(3, 4);
        otherComplex = new Complex(1.5, 2.5);
        imaginaryUnit = new Complex(0, 1);
    }

    @Test
    public void toStringTest()
    {
        assertEquals(complex.toString(), "3.0 + 4.0i");
    }

    @Test
    public void equalsTest()
    {
        Complex sameComplex = new Complex(3, 4);
        Complex differentComplex = new Complex(3, -4);
        assertEquals(complex, sameComplex);
        assertNotEquals(complex, differentComplex);
    }

    @Test
    public void addTest()
    {   
        Complex sum = new Complex(4.5, 6.5);
        assertEquals(complex.add(otherComplex), sum);
    }

    @Test
    public void multiplyTest()
    {
        Complex product = new Complex(-5.5, 13.5);
        assertEquals(complex.multiply(otherComplex), product);
    }

    @Test
    public void squareTest()
    {
        assertEquals(imaginaryUnit.square(), new Complex(-1, 0));
        assertEquals(complex.square(), new Complex(-7, 24));
    }

    @Test
    public void modulusTest()
    {
        double absoluteValue = complex.modulus();
        assertEquals(absoluteValue, 5, Math.ulp(absoluteValue));
    }
    
}
