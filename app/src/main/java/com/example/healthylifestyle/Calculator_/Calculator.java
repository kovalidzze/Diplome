package com.example.healthylifestyle.Calculator_;

public class Calculator {

    public static double CalorieCalculation(double widht, double grow, int old, double activ, double gender, int goal)
    {
        final double const1 = 9.99;
        final double const2 = 6.25;
        final double const3 = 4.92;
        final int const4 = 161;
        double result = 0;

        result = const1 * widht + const2 * grow - const3 * old - const4;
        result *= activ;
        result *= gender;

        switch (goal)
        {
            case 1:
                return (result - (result * 20) / 100);
            case 0:
                return result;
            case 2:
                return (result + (result * 15) / 100);

            default:
                break;
        }
        return result;

    }
}
