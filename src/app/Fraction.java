/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author tranc
 */
public class Fraction {
    private int numerator;
    private int denominator;
    
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }
    
    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }
    
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }
        
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero!");
        }
        
        this.denominator = denominator;
    }
    
    public int getNumerator() {
        return this.numerator;
    }
    
    public int getDenominator() {
        return this.denominator;
    }

    @Override
    public String toString() {
        if (this.denominator < 0) {
            this.numerator = this.numerator * (-1);
            this.denominator = this.denominator * (-1);
        }

        if (this.numerator == 0) {
            return "0";
        } else if (this.denominator == 1) {
            return String.valueOf(this.numerator);
        } else {
            if (this.denominator == 0) {
                return "";
            }
            int numberGCD = gcd(this.numerator, this.denominator);
            if (this.numerator % numberGCD == 0 && this.denominator % numberGCD == 0) {
                if (this.denominator / numberGCD == 1) {
                    return String.valueOf(this.numerator / numberGCD);
                } else {
                    return this.numerator / numberGCD + "/" + this.denominator / numberGCD;
                }
            } else if (this.numerator % numberGCD == 0) {
                return this.numerator / numberGCD + "/" + this.denominator;
            } else if (this.denominator % numberGCD == 0) {
                return this.numerator + "/" + numberGCD / this.denominator;
            }
        }

        return "";
    }
    
    public Fraction add(Fraction other) {
        int a = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        int b = this.denominator * other.denominator;
        
        return new Fraction(a, b);
    }

    public Fraction add(int other) {
        return add(new Fraction(other));
    }

    public Fraction subtract(Fraction other) {
        int a = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        int b = this.denominator * other.denominator;
        
        return new Fraction(a, b);
    }

    public Fraction subtract(int other) {
        return subtract(new Fraction(other));
    }

    public Fraction multiply(Fraction other) {
        int a = this.numerator * other.numerator;
        int b = this.denominator * other.denominator;
        
        return new Fraction(a, b);
    }
    
    public Fraction multiply(int other) {
        return multiply(new Fraction(other));
    }

    
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        
        int a = this.numerator * other.denominator;
        int b = this.denominator * other.numerator;
        
        return new Fraction(a, b); 
    }
    
    public Fraction divide(int other) {
        return divide(new Fraction(other));
    }

    public static int gcd(int number1, int number2) {
        if (number2 == 0) {
            if (number1 < 0) {
                number1 *= -1;
            }
            return number1;
        }
        
        return gcd(number2, number1 % number2);
    }
}
