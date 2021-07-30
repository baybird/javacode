/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparable;

/**
 *
 * Suppose that a class Complex has been defined for storing complex numbers. In
 * mathematics, complex numbers are those that can be written as (x + y i) where
 * x and y are real numbers and i is the square root of -1. In other words,
 * complex numbers have a real part (x) and an imaginary part (y). The class
 * includes the following members: private double x	real part private double y
 * imaginary part public Complex(double x, double y)	constructs a complex number
 * x + y * i public double getReal()	returns the real part of the number public
 * double getImaginary()	returns the imaginary part of the number public double
 * abs()	returns the absolute value of the number public String toString()
 * returns a String representation of the number public Complex add(Complex
 * other)	returns the result of adding another complex number to this one public
 * Complex subtract(Complex other)	returns the result of subtracting another
 * complex number from this one
 *
 * Your task is to modify the class to be Comparable by adding an appropriate
 * compareTo method. Complex objects should be compared using absolute value
 * with smaller absolute values considered "less" than numbers of higher
 * absolute value.
 *
 * The absolute value of a complex number is defined to be the square root of
 * the sum of the squares of x and y.
 */
public class Complex {

    public int compareTo(Complex other){
        if(abs() > other.abs()){
            return 1;
        }
        else if(abs() < other.abs()){
            return -1;
        }
        
        return 0;
    }
    
    public double abs(){
        return 0.0;
    }
}
