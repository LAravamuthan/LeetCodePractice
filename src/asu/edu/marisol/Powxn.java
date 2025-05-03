package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Powxn {

    /**
     * Mathematical jugglary, Thing is X^n is nothing but (X*X)^N/2, hence 2 ^ 100 usually done 100 steps boils
     * down to 10 steps.
     *
     * (2)^100 = (4)^50 = (16)^25 = 16 * (16)^24 = 16 * (256)^12 and so on
     *
     * , Recursion approach.
     *
     * @time-complexity - O (logn).
     * @space-complexity - O (1).
     */
    public double myPow(double x, int n) {
        return binaryPow(x, n);
    }

    private double binaryPow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return binaryPow(1/x, -n);

        if (n % 2 == 0) return binaryPow(x * x, n/2);
        else return x * binaryPow(x * x, (n - 1)/2);
    }


    /**
     * Mathematical jugglary, Thing is X^n is nothing but (X*X)^N/2, hence 2 ^ 100 usually done 100 steps boils
     * down to 10 steps.
     *
     * (2)^100 = (4)^50 = (16)^25 = 16 * (16)^24 = 16 * (256)^12 and so on
     *
     * , Iterative approach.
     *
     * @time-complexity - O (logn).
     * @space-complexity - O (1).
     */
    public double myPow2(double x, int n) {
        return binaryPowIterative(x, n);
    }

    private double binaryPowIterative(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1/x; n = -n;
        }

        double result = 1.0;
        while (n != 1) {
            if (n % 2 == 1) {
                result = result * x;
                n = n - 1;
            }
            x = x * x;
            n /= 2;
        }

        return result;
    }

}
